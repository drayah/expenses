(ns expenses.core 
  (:require [clojure.java.io :as cio]
            [clojure.string :as str]))

(defn real-return
  "Calculate the real rate of return given a nominal and inflation rate"
  [nominal inflation]
  (let [nominal (/ nominal 100)
        inflation (/ inflation 100)
        real-rate (- (/ (+ 1 nominal) (+ 1 inflation)) 1)]
    (* real-rate 100)))

(defn keyword-for-index 
  "Returns a keyword for index"
  [index]
  (case index
    0  :date
    1  :amount
    2  :category
    3  :subcategory
    4  :type
    7  :payee
    10 :account
       :unknown))

(defn parse-value
  "Parse a string value to a correct type"
  [keyword value]
  (case keyword
    :amount (if (empty? value) 0M (bigdec value))
            value))
    
(defn build-map
  "Given a seq of strings build an expense map"
  [strings]
  (loop [current strings
         index 0
         map {}]
    (if (empty? current) 
      map
      (let [keyword (keyword-for-index index)
            value (parse-value keyword (first current))
            map (if (= keyword :unknown) map (assoc map keyword value))]
        (recur (rest current) (inc index) map)))))

(defn line->expense
  "Transform an expense line to a map"
  [line]
  (let [elements (str/split line #";")]
    (build-map elements)))

(defn csv->expenses
  "Transform a seq of csv strings to a seq of expenses"
  [csv]
  (map line->expense csv))