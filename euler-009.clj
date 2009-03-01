(in-ns 'project-euler)
(clojure.core/use 'clojure.core)

;; Not entirely happy with this, since it takes quite a while.
;; Uses list comprehension.
;; One other result that might be useful from: 
;;  (a + b + c) ^ 2 = a * a + b * b + c * c + 2 ( a * b + b * c + c * a)
;;  and using the conditions above, we get: a * b + 1000 * c = 500000
;;  but that doesn't noticeably decrease the time spent.

(for [a (range 1 300) b (range a 400) c (range b 500) 
	:when (and (= (+ a b c) 1000) (= (* c c) (+ (* a a) (* b b))))] (* a b c))