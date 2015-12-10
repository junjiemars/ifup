(defproject ifup "0.1.0-SNAPSHOT"
  :description "get the configuration of your network interface **ifconfig** after you'd **ifup**"
  :url "http://ifup.sinaapp.com"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [compojure "1.4.0"]
                 [ring/ring-defaults "0.1.5"]
                 [org.clojure/tools.logging "0.3.1"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler ifup.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}
   :uberwar {:aot :all}}

  :javac-options ["-target" "1.6" "-source" "1.8"])
