(ns wallchart.expenses.utils.io
  (:require [clojure.java.io :as io]
            [clojure.data.csv :as csv]))

(defn read-csv!
  "Reads csv from given path, given optional map of parameters e.g {:separator \\,}"
  [csv-path & params]
  (let [[options]                              params
        {:keys [separator] :or {separator \;}} options]
    (with-open [reader (io/reader csv-path)]
      (->> (csv/read-csv reader :separator separator)
          (drop 1) ;header
          (mapv identity)))))
