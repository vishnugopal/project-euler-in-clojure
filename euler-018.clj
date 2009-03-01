
(in-ns 'project-euler)
(clojure.core/use 'clojure.core)

(def integer-triangle 
	[75
	95 64
	17 47 82
	18 35 87 10
	20  4 82 47 65
	19  1 23 75  3 34
	88  2 77 73  7 63 67
	99 65  4 28  6 16 70 92
	41 41 26 56 83 40 80 70 33
	41 48 72 33 47 32 37 16 94 29
	53 71 44 65 25 43 91 52 97 51 14
	70 11 33 28 77 73 17 78 39 68 17 57
	91 71 52 38 17 14 91 43 58 50 27 29 48
	63 66  4 68 89 53 67 30 73 16 69 87 40 31
	 4 62 98 27 23  9 70 98 73 93 38 53 60 04 23])

(defn find-height-in-triangle 
  "Find the height in triangle for an Nth element, 
	(n * (n + 1) / 2) is the max-height of any tree, so 
	essentially we find n : (n * (n + 1) / 2) >= N"
  [N]
  (loop [n 0]
    (if (>= (/ (* n (+ n 1)) 2) (+ N 1)) 
      n
			(recur (+ n 1)))))
			
(defn find-children
  "Find the positions of children of any position in a triangle"
  [N]
  (let [height (find-height-in-triangle N)]
    [(+ N height) (+ N height 1)]))

(def max-height-of-triangle (find-height-in-triangle (- (count integer-triangle) 1)))

(loop [max-array []]
  (if (> (count max-array) max-height-of-triangle) 
    (apply max max-array)
		(let []
		  )))

(integer-triangle 10)
(integer-triangle 15)
(integer-triangle 16)
(find-children 10)

