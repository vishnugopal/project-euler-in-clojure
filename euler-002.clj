
(in-ns 'project-euler)
(clojure.core/use 'clojure.core)

(defn sum-of-evens 
  "Returns the sum of all even numbers in this binary arglist."
  [number-1 number-2]
  (+ (if (even? number-1) number-1 0)
		 (if (even? number-2) number-2 0)))
	

(loop [number-1 1 number-2 1 sum 0]
	(if (> number-1 4000000)
		(print sum) 
		(let [sum-current (sum-of-evens number-1 number-2)] 
		(if (or (even? number-1) (even? number-2)) 
			(recur (+ number-1 number-2) (+ number-1 number-2 number-2) (+ sum sum-current))
			(recur (+ number-1 number-2) (+ number-1 number-2 number-2) sum)))))
	
