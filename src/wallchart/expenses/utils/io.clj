(ns wallchart.expenses.utils.io
  (:require [clojure.java.io :as io]
            [clojure.data.csv :as csv]))

(defn read-expenses-csv!
  "Read lines from a csv and return a seq"
  [csv-path]
  (with-open [reader (io/reader csv-path)]
    (->> (csv/read-csv reader :separator \;)
         (drop 1)
         (mapv identity))))
