
(in-ns 'project-euler)
(clojure.core/use 'clojure.core)

(loop [number 1 sum 0]
  (if (= number 1000))
  (print sum)
  (if (or (= (rem number 3) 0))))

(loop [number 1 sum 0]
	(if (= number 1000) 
		(print sum)
  	(if (or (= (rem number 3) 0 ) (= (rem number 5) 0 )) 
			(recur (+ number 1) (+ sum number)) 
			(recur (+ number 1) sum))))
	



