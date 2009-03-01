
(in-ns 'project-euler)
(clojure.core/use 'clojure.core)

(def upper-limit 2000000)

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
			(recur (+ counter 1))))))


(loop [counter 2 sum 0]
	(if (> counter upper-limit)
		sum
	  (if (prime? counter)
			(recur (+ counter 1) (+ sum counter))
			(recur (+ counter 1) sum))))