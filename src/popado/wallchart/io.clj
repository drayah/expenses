(ns co.popado.finance.io
  (:require [clojure.java.io :as cio]))

(defn read-expense-csv
  "Read lines from a csv and return a seq"
  [file]
  (with-open [reader (cio/reader file)]
    (doall (line-seq reader))))
