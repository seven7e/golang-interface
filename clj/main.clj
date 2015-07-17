(ns main
    (:require [complex]))

(defn print-it [c]
  (println "------------")
  (println "raw storage:" c)
  (println "complex:" (complex/to-string c))
  (println "real:" (complex/get-real c) "image:" (complex/get-image c))
  (println "abs:" (complex/get-abs c) "arg:" (complex/get-arg c))
)

(def a (let [sqrt-half (Math/sqrt 0.5)]
  (complex/make-rect sqrt-half sqrt-half)))
(print-it a)
(def b (complex/make-polar 1 (- (/ Math/PI 4))))
(print-it b)
(def c (complex/add a b))
(print-it c)