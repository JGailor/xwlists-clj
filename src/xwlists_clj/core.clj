(ns xwlists-clj.core
  (:gen-class)
  (:require [org.httpkit.server :as server]
            [compojure.handler :as h]
            [xwlists-clj.routes :as routes]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (server/run-server (h/site #'routes/all-routes) {:port 8080}))
