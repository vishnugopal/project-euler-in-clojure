
(in-ns 'project-euler)
(clojure.core/use 'clojure.core)

(defn triangle-number-nth 
  "Find the nth triangle number"
  [n]
  (/ (* n (+ n 1)) 2))

(defn isqrt 
  "Integer square root of a number."
  [number]
  (int (java.lang.Math/sqrt number)))

(defn count-factors 
  "Count the number of factors for a number"
  [number]
  (loop [counter 1 factors-count 0]
    (if (> counter (isqrt number)) 
      (* factors-count 2)
     	(if (= 0 (rem number counter)) 
				(recur (+ counter 1) (+ factors-count 1))
				(recur (+ counter 1) factors-count)))))

(loop [counter 1 max-factors 0]
  (let [current-triangle-number (triangle-number-nth counter)]
		(if (> max-factors 500)
			(triangle-number-nth (- counter 1))
			(let [current-count-factors (count-factors current-triangle-number)]
				(if (> current-count-factors max-factors) 
					(recur (+ counter 1) current-count-factors) 
					(recur (+ counter 1) max-factors))))))					

					
