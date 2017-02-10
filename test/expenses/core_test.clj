(ns expenses.core-test
  (:require [expectations :refer :all]
            [expenses.core :refer :all]))

; should return correct real return given nominal return and inflation
(expect 0 (real-return 1 1))
(expect 1 (real-return 1 0))
(expect (approximately 0.99) (real-return 2 1))
(expect (approximately 1.566) (real-return 1.8 0.23))
(expect (approximately 0.997) (real-return 1.35 0.35))
(expect (approximately 1.067) (real-return 1.33 0.26))

; should return correct keyword for index
(expect :date (keyword-for-index 0))
(expect :amount (keyword-for-index 1))
(expect :category (keyword-for-index 2))
(expect :subcategory (keyword-for-index 3))
(expect :type (keyword-for-index 4))
(expect :unknown (keyword-for-index 5)) 
(expect :unknown (keyword-for-index 6))
(expect :payee (keyword-for-index 7))
(expect :unknown (keyword-for-index 8))
(expect :unknown (keyword-for-index 9))
(expect :account (keyword-for-index 10))

; should return correct type when parsing string values 
(expect 0M (parse-value :amount ""))
(expect 1.1M (parse-value :amount "1.1"))
(expect NumberFormatException (parse-value :amount "not a number"))
(expect "" (parse-value :unknown ""))
(expect "a" (parse-value :unknown "a"))
(expect "2001-01-01" (parse-value :date "2001-01-01"))