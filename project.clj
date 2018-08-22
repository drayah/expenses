(defproject expenses "0.1.0-SNAPSHOT"
  :description "Personal finances hobby project"
  :url "https://github.com/drayah/expenses"
  :min-lein-version "2.8.1"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.9.0"]]
  :plugins [[lein-coverage "1.0.11"]]
  :profiles {:dev {:dependencies [[midje "1.9.2"]
                                  [cloverage "1.0.13"]]
                   :plugins [[lein-midje "3.2.1"]]}
             :uberjar {:aot :all}})
