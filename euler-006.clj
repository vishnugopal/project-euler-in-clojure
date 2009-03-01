
(in-ns 'project-euler)
(clojure.core/use 'clojure.core)

;; Remembered this from Jayadevan's Entrance coaching
;; (1 + 2 + ... + n) = (n * (n + 1)) / 2
;; (1^2 + 2^2 + ... + n^2) = ((n * (n + 1) * (2n + 1)) / 6)

(defn difference-of-squares-and-sum-of-squares 
  "See http://projecteuler.net/index.php?section=problems&id=6"
  [number]
  (- 
		(int (java.lang.Math/pow (/ (* (+ number 1) number) 2) 2))
		(/ (* number (+ number 1) (+ 1 (* 2 number))) 6)))

(difference-of-squares-and-sum-of-squares 100)