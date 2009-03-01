
(in-ns 'project-euler)
(clojure.core/use 'clojure.core)

(use '[clojure.contrib.str-utils :only [re-split]])

(defn components-of-number
  "Split a number into its constituents (number < 9999)"
  [number]
  (let [thousands (int (/ number 1000.0)) hundreds (int (/ (rem number 1000) 100))
				tens (int (/ (rem number 100) 10)) ones (rem number 10)]
    {:thousands thousands :hundreds hundreds :tens tens :ones ones}))

(defn components-of-number-with-power
  "Split a number into its constituents (number < 9999)"
  [number]
	(let [components (components-of-number number)]	
	  {:thousands (* (:thousands components) 1000) 
		 :hundreds (* (:hundreds components) 100)
		 :tens (* (:tens components) 10)
		 :ones (:ones components)}))


(defn word-for-numeral
  "Maps a natural number into its word representation"
  [number]
  (let [map-for-numerals
		{0 "zero" 
		 1 "one" 2 "two" 3 "three" 4 "four" 5 "five" 6 "six" 7 "seven" 8 "eight" 9 "nine" 10 "ten"
		 11 "eleven" 12 "twelve" 13 "thirteen" 14 "fourteen" 15 "fifteen" 16 "sixteen" 
		 17 "seventeen" 18 "eighteen" 19 "nineteen" 
		 20 "twenty" 30 "thirty" 40 "forty" 50 "fifty" 60 "sixty" 70 "seventy" 80 "eighty" 90 "ninety"}]
    (if (map-for-numerals number) 
      (map-for-numerals number)
			(let [components (components-of-number number)]
			  (if (> (:thousands components) 0)
					(str (word-for-numeral (:thousands components)) " thousand")
					(if (> (:hundreds components) 0)
						(str (word-for-numeral (:hundreds components)) " hundred")))))))


(defn number-in-words 
  "Spell out a number in words (number < 1000)"
  [number]
  (let [components (components-of-number-with-power number) string-representation
    (.trim (str
		(if (> (components :thousands) 0) 
      (word-for-numeral (components :thousands)))
		(if (and (> (components :thousands) 0) (> (components :hundreds) 0)) " ")
		(if (> (components :hundreds) 0) 
		  (word-for-numeral (components :hundreds)))
		(if (and 
			(or (> (components :hundreds) 0)  (> (components :thousands) 0))
			(or (> (components :tens) 0)  (> (components :ones) 0))) " and ")
		(if (> (:tens (components-of-number number)) 1) 
		  (str 
				(word-for-numeral (components :tens))
				" "
				(if (> (components :ones) 0) (word-for-numeral (components :ones))))
			(word-for-numeral (+ (* (:tens (components-of-number number)) 10) (components :ones))))))]
			string-representation))

(defn count-letters-in-string 
  "Counts the letters in string"
  [string]
  (count (apply str (re-split #"\s" string))))


(loop [number 1 total-length 0]
  (if (> number 1000) 
    total-length
		(recur (+ number 1) (+ total-length (count-letters-in-string (number-in-words number))))))



