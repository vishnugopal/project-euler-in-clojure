

(in-ns 'project-euler)
(clojure.core/use 'clojure.core)

(def big-exponential-number (.pow (BigInteger/valueOf 2) (BigInteger/valueOf 1000)))

(defn sum-of-string 
  "Outputs the sum of all single digit numbers in a string"
  [string]
  (apply + (map #(Integer/parseInt (str %)) (replace {} string))))

(sum-of-string (str big-exponential-number))


