(ns xwlists-clj.actions.archetypes
  (:gen-class)
  (:require [selmer.parser :as selmer]
            [xwlists-clj.queries :as q]
            [xwlists-clj.services.archetypes :as a]
            [ring.util.response :as r]))

(defn index
  "Renders the archetypes index page"
  [request]
  (let [archetypes (q/get-archetypes-with-tag-list q/db)]
    (selmer/render-file "views/archetypes/index.html.selmer" {:archetypes archetypes})))

(defn show
  "Renders the archetype page for an id"
  [request]
  (let [id (get-in request [:params :id])
        archetype (q/get-archetype-by-id q/db)]
    (if (nil? archetype)
      (r/not-found)
      (let [tourney-lists (q/get-archetype-tourney-lists q/db id)
            stats (a/compute-archetype-stats archetype tourney-lists)
            tags (q/get-all-tags q/db)]
        (selmer/render-file "views/archetypes/show.html.selmer"
                            {:archetype archetype
                             :stats stats
                             :tags tags})))))