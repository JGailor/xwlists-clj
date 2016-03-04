(ns xwlists-clj.routes
  (:gen-class)
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [xwlists-clj.actions.about :as about]
            [xwlists-clj.actions.leagues :as leagues]
            [xwlists-clj.actions.events :as events]
            [xwlists-clj.actions.tourneys :as tourneys]
            [xwlists-clj.actions.archetypes :as archetypes]))

(defroutes all-routes
  (GET "/about" [] about/show)                            ;; /about
  (GET "/archetypes" [] archetypes/index)                 ;; /archetypes
  (GET "/archetypes/:id" [] (archetypes/show))            ;; /archtype
  (GET "/cache/league_players" [] (str "ok"))             ;; /cache_league_players
  (GET "/cache_league_results" [] (str "ok"))             ;; /cache_league_results
  (GET "/events" [] events/show)                          ;; /events
  (GET "/escrow" [] (str "ok"))                           ;; /escrow
  (GET "/escrow/change" [] (str "ok"))                    ;; /escrow_change
  (GET "/escrow/list_url" [] (str "ok"))                  ;; /escrow_list_url
  (GET "/league_players" [] (str "ok"))                   ;; /league_players
  (GET "/leagues" [] [] (str "ok"))                       ;; /league
  (GET "/leagues/admin" [] leagues/admin)                 ;; /league_admin
  (GET "/leagues/matches" [] (str "ok"))                  ;; /league_matches
  (GET "/search" [] (str "ok"))                           ;; /search
  (GET "/search/guide" [] (str "ok"))                     ;; /search_guide
  (GET "/search/results" [] (str "ok"))                   ;; /search_results
  (POST "/tags" [] (str "ok"))                            ;; /add_tag
  (DELETE "/tags/:id" [id] (str "ok"))                    ;; /remove_tag
  (GET "/tourneys" [] tourneys/index)                     ;; /tourneys
  (GET "/tourneys/:id" [id] tourneys/show)                ;; /tourney_results
  (GET "/tourneys/:id/edit" [] (str "ok"))                ;; /edit_tourney_details
  (PUT "/tourneys/:id" [] (str "ok"))                     ;; /update_tourney_details
  (GET "/tourneys/admin" [] tourneys/admin)               ;; /tourney_admin
  (GET "/tourneys/:id/rankings" [] (str "ok"))            ;; /get_rankings
  (GET "/tourneys/:id/pre_elim_results" [] (str "ok"))    ;; /get_pre_elim_results
  (route/resources "/static" {:root "static"}))