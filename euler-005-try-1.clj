
(in-ns 'project-euler)
(clojure.core/use 'clojure.core)


;; This solution doesn't work when N-to-find is 20
;; keeps looping forever.

(def N-to-find 10)

(defn divisible-upto-n? 
  "Asks if the given number is evenly divisible up to any natural number N."
  [number, N]
  (loop [counter 1]
		(if (> counter N) 
		  true
	    (if (not (= 0 (rem number counter)))
				false
				(recur (+ counter 1))))))
				
(loop [counter 1 smallest 1]
	(if (= counter (+ N-to-find 1))
		(print smallest)
	  (if (and (divisible-upto-n? smallest counter))
			(recur (+ counter 1) smallest)
			(recur counter (+ smallest 1)))))