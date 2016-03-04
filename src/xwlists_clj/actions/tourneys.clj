(ns xwlists-clj.actions.tourneys
  (:gen-class)
  (:require [selmer.parser :as selmer]
            [xwlists-clj.queries :as q]))

(defn index
  "Renders the index page for tourneys"
  []
  (let [tourneys (q/get-tourneys-with-venues q/db)]
    (selmer/render-file "views/tourneys/index.html.selmer"
                        {:tourneys tourneys})))

(defn admin
  "Renders the admin page of the tourneys section"
  []
  (let [tourneys (q/get-tourneys q/db)]
    (selmer/render-file "views/tourneys/admin.html.selmer"
                        {:tourneys tourneys})))

(defn show
  "Renders the show view for a tournament"
  [request]
  (let [tourney_id (get-in request [:params :id])
        tourney (q/get-tourney-by-id q/db {:id tourney_id})]
    (println tourney)
    (selmer/render-file "views/tourneys/show.html.selmer" {:tourney tourney})))