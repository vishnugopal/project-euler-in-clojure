
(in-ns 'project-euler)
(clojure.core/use 'clojure.core)

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

(loop [counter 0 number 1	previous-prime 1]
	(if (> counter 10001) 
	  (print previous-prime)
	  (if (prime? number) 
	    (recur (+ counter 1) (+ number 1) number)
			(recur counter (+ number 1) number))))