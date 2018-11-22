(defproject wallchart "0.1.0-SNAPSHOT"
  :description "Experimenting with personal finances"
  :url "https://github.com/drayah/wallchart"
  :min-lein-version "2.8.1"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/data.csv "0.1.4"]
                 [clj-time "0.15.1"]]
  :plugins [[lein-cloverage "1.0.13"]]
  :main ^:skip-aot wallchart.main
  :uberjar-name "wallchart-api.jar"
  :target-path "target/%s"
  :profiles {:dev {:dependencies [[midje "1.9.4"]
                                  [cloverage "1.0.13"]]
                   :plugins [[lein-midje "3.2.1"]
                             [lein-ancient "0.6.15"]]}
             :uberjar {:aot :all}})
