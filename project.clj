(defproject expenses "0.1.0-SNAPSHOT"
  :description "Personal finances hobby project"
  :url "https://github.com/drayah/expenses"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :plugins [[lein-expectations "0.0.8"]]
  :profiles {:dev {:dependencies [[expectations "2.2.0-alpha1"]]}})
