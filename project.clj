(defproject xwlists-clj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.4.0"]
                 [selmer "1.0.0"]
                 [http-kit "2.1.19"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [com.layerware/hugsql "0.4.1"]
                 [clojure.jdbc/clojure.jdbc-c3p0 "0.3.1"]
                 [mysql/mysql-connector-java "5.1.38"]
                 [sonian/carica "1.2.1"]]
  :main ^:skip-aot xwlists-clj.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
