

(in-ns 'project-euler)
(clojure.core/use 'clojure.core)

(defn palindrome? 
  "Finds whether the string is a palindrome."
  [string]
  (if (= (apply str (reverse (str string))) (str string)) true false))

(loop [number-1 100 number-2 100 highest 0]
  (if (> number-2 999)
		(print highest)
		(let [next-number-1 (if (= number-1 999) 100 (+ number-1 1)) next-number-2 (if (= number-1 999) (+ number-2 1) number-2) multiplied (* number-1 number-2)]
			(if (and (palindrome? multiplied) (> multiplied highest))
				(recur next-number-1 next-number-2 multiplied)
				(recur next-number-1 next-number-2 highest)))))
