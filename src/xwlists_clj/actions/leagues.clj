(ns xwlists-clj.actions.leagues
  (:gen-class)
  (:require [selmer.parser :as p]))

(defn admin
  "Renders the league admin view"
  []
  (p/render-file "views/leagues/admin.html.selmer" {}))

