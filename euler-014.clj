
(in-ns 'project-euler)
(clojure.core/use 'clojure.core)

(defn next-number-in-collatz-sequence 
  "Finds the next number in the collatz sequence, returns nil when the param is 1"
  [number]
  (cond 
		(= 1 number) nil
		(odd? number) (+ (* 3 number) 1)
		(even? number) (/ number 2)))

(def starting-number 1000000)


(defn chain-length-for-collatz-sequence
  "Finds the chain length of collatz sequence for a number."
  [number]
  (loop [counter number chain-length 1]
    (if (= counter 1) 
      chain-length 
			(recur (next-number-in-collatz-sequence counter) (+ chain-length 1)))))

(defn ln 
	"Log to the base 2"
	[number]
	(/ (java.lang.Math/log number)(java.lang.Math/log 2)))

(defn perfect-multiple-of-2? 
  "Is the number a perfect multiple of 2?"
  [number]
  (if (integer? (rationalize (ln number))) true false))

(perfect-multiple-of-2? 50)

(loop [counter starting-number maximum-chain-length 0 collatz-number 0]
  (if (= counter 1)
		collatz-number 
		(let [chain-length 
			;; we ignore perfect multiples of 2 since they have a predictably low chain length
			(if (perfect-multiple-of-2? counter) 0 (chain-length-for-collatz-sequence counter))]
		  (if (> chain-length maximum-chain-length) 
		    (recur (- counter 1) chain-length counter)
				(recur (- counter 1) maximum-chain-length collatz-number)))))