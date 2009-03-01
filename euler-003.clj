
(in-ns 'project-euler)
(clojure.core/use 'clojure.core)

(def large-composite-number 600851475143)

(defn isqrt 
  "Integer square root of a number."
  [number]
  (int (java.lang.Math/sqrt number)))

(defn prime? 
  "Finds out if a number is prime."
  [number]
  (loop [counter 2]
		(if (> counter (isqrt number)) true
    (if (= 0 (rem number counter)) 
			false
			(recur (+ counter 1)) 
      ))))

(loop [counter 2 highest 2]
	(if (> counter (isqrt large-composite-number))
		highest
	  (if (and (= 0 (rem large-composite-number counter)) (prime? counter) (>= counter highest))
			(recur (+ counter 1) counter)
			(recur (+ counter 1) highest))))


