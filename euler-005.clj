

(in-ns 'project-euler)
(clojure.core/use 'clojure.core)

;; Notice the pattern here for smallest-evenly-divisble.
;; The algorithm below just implements that pattern.
;; Foe every number, check if it's divisible, if not, iterate from 2
;; until that number and multiply.
;;  1->1; 2->2; 3->6; 4->12; 5->60; 6->60; 7->420; 8->840; 9->2520

(def N-to-find 20)

(defn smallest-evenly-divisible 
  "Returns the smallest evenly divisible number"
  [counter smallest]
  (if (= counter (+ N-to-find 1))
		(print smallest)
	  (if (= 0 (rem smallest counter))
			(smallest-evenly-divisible (+ counter 1) smallest)
			(loop [counter-2 2]
				(if (= 0 (rem (* smallest counter-2) counter))
					(smallest-evenly-divisible (+ counter 1) (* smallest counter-2))
					(recur (+ counter-2 1)))))))
							
(smallest-evenly-divisible 1 1)







			

