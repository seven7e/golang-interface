(ns complex
  (:require [dynbind]))

(def rect-tag 'rect)
(def polar-tag 'polar)

(defn make-rect [real image]
  (dynbind/attach-tag rect-tag (list (float real) (float image)))
)

(defn make-polar [abs arg]
  (dynbind/attach-tag polar-tag (list (float abs) (float arg)))
)

(dynbind/interface get-real)
(dynbind/interface get-image)
(dynbind/interface get-abs)
(dynbind/interface get-arg)
(dynbind/interface to-string)
; (println (macroexpand '(dynbind/interface to-string)))
; (println to-string)

(defn install-rect []
  (letfn [(get-real [c]
            (first c))
          (get-image [c]
            (first (rest c)))
          (get-abs [c]
            (let [r (get-real c) i (get-image c)]
              (Math/sqrt (+ (* r r) (* i i)))))
          (get-arg [c]
            (let [r (get-real c) i (get-image c)]
              (Math/atan (/ i r))))
          (to-string [c]
            ; (println c)
            (let [r (get-real c)
                  i (get-image c)
                  sgn-i (if (< i 0) "" "+")]
              (format "%f%s%fi" r sgn-i i)))]

    (dynbind/install rect-tag 'get-real get-real)
    (dynbind/install rect-tag 'get-image get-image)
    (dynbind/install rect-tag 'get-abs get-abs)
    (dynbind/install rect-tag 'get-arg get-arg)
    (dynbind/install rect-tag 'to-string to-string)
  )
)

(defn install-polar []
  (letfn [(get-real [c]
            (* (get-abs c) (Math/cos (get-arg c))))
          (get-image [c]
            (* (get-abs c) (Math/sin (get-arg c))))
          (get-abs [c]
            (first c))
          (get-arg [c]
            (first (rest c)))
          (to-string [c]
            ; (println c)
            (let [r (get-abs c)
                  i (get-arg c)]
              (format "%f*exp(%fi)" r i)))]

    (dynbind/install polar-tag 'get-real get-real)
    (dynbind/install polar-tag 'get-image get-image)
    (dynbind/install polar-tag 'get-abs get-abs)
    (dynbind/install polar-tag 'get-arg get-arg)
    (dynbind/install polar-tag 'to-string to-string)
  )
)

(install-rect)
(install-polar)

; (println (deref dynbind/vtable))

(defn add [c d]
  (make-rect (+ (get-real c) (get-real d))
             (+ (get-image c) (get-image d))
  )
)
