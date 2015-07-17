(ns dynbind)

(def vtable (atom (hash-map)))

(defmacro interface [op]
  `(defn ~op [data# & ~'args]
  ;`(def ~op (fn [~'data & ~'args]
     (apply-generic data# ~(list 'quote op) ~'args))
)

  ;'(def (quote ~op) (fn [] "hello"))
(defn install [type-tag op func]
  (reset! vtable (assoc-in (deref vtable) [type-tag op] func))
)

(defn attach-tag [tag data]
  (list tag data)
)

(defn get-tag [obj] (first obj))
(defn get-content [obj] (second obj))

(defn getfn [type-tag op]
  (get-in (deref vtable) [type-tag op])
)

(defn apply-generic [data op args]
  ; (println data op args)
  (let [func (getfn (get-tag data) op)]
    ; (println data (get-tag data) op func)
    (apply func (cons (get-content data) args))
  )
)

; -------- Test routines ----------
(defn- mytest []
  (println @vtable)
  (install 'test-type 'test-op (fn [] "foo"))
  (println @vtable)
  (println ((getfn 'test-type 'test-op)))
)

;(mytest)

;(println (macroexpand '(interface test-print)))
;(interface test-print)
;(def obj "hello world")
;(defn test-print-mystr [msg] (println "Mystr:" msg))
;(def obj (attach-tag 'mystr obj))
;(install 'mystr 'test-print test-print-mystr)
;(test-print obj)

;(println (macroexpand '(defn foo [a] (println a))))
;(println (macroexpand `(defn ~'foo ~(vector 'a) (println ~'a))))
;(println (macroexpand (list 'defn 'foo (vector 'a) '(println a))))
;(interface test-op)

