(ns xwlists-clj.actions.events
  (:gen-class)
  (:require [selmer.parser :as selmer]
            [xwlists-clj.queries :as q]))

(defn show
  "Renders the list of events"
  []
  (let [events (q/get-events q/db)]
    (selmer/render-file "views/events/show.html.selmer" {:events events})))