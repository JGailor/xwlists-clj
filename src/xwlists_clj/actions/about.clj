(ns xwlists-clj.actions.about
  (:gen-class)
  (:require [selmer.parser :as p]))

(defn show
  "Renders the about page"
  []
  (p/render-file "views/about.html.selmer" {}))