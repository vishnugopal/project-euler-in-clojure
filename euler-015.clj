
(in-ns 'project-euler)
(clojure.core/use 'clojure.core)


;;  Solution (courtesy Sherin)
;;  We're going to identify patterns here for each movement.
;;  Let's first list all the possible combinations for a 2x2 grid.

;; * * *
;; * * *
;; * * *

;; RRDD, DDRR, RDRD, RDDR, DRRD, DRDR

;; Now let's list the combinations for a 3x3 grid.

;; * * * *
;; * * * *
;; * * * *
;; * * * *

;; RRRDDD, RRDDDR, RRDRDD, RRDDRD, RDDDRR, RDDRDR, RDRRDD, RDRDRD, RDRDDR, ...

;; In all these cases we see, for a 2x2 grid, a total path length of 2 * 2, with each
;; D and R appearing 2 times. For 3x3, a total path length of 2 * 3, with each D and R
;; appearing 3 times. Generalizing, for an NxN grid, total path length of 2 * N, with
;; each pair appearing N times.

;; Thus the problem reduces to finding all combinations of R and D where R can appear N
;; times in a total size of 2N.

;; so we have the formula for combinations: n!/(r! * (n - r)!). Here n = 2N, and r = N,
;; so we have total paths = (2N)!/(N! ^ 2)

;; This is a simple function in clojure:


;; Using multiple arguments for default
(defn factorial
  "Find the factorial of a number"
  ([numb fact]
  (if (= numb 0)
		fact
		(recur (- numb 1) (* fact numb))))
	([number] (factorial number 1)))
	

(defn total-paths-for-nxn-grid 
  "Find the total paths from top corner to bottom in an NxN grid without backtracking"
  [N]
	(bigint (/ (factorial (* 2 N)) (java.lang.Math/pow (factorial N) 2))))
	
(total-paths-for-nxn-grid 20)

