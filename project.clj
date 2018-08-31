(defproject expenses "0.1.0-SNAPSHOT"
  :description "Personal finances"
  :url "https://github.com/drayah/expenses"
  :min-lein-version "2.8.1"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.9.0"]]
  :plugins [[lein-cloverage "1.0.11"]]
  :main ^:skip-aot co.popado.finance.main
  :uberjar-name "expenses-api.jar"
  :target-path "target/%s"
  :profiles {:dev {:dependencies [[midje "1.9.2"]
                                  [cloverage "1.0.13"]]
                   :plugins [[lein-midje "3.2.1"]]}
             :uberjar {:aot :all}})
