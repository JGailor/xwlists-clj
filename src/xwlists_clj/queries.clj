(ns xwlists-clj.queries
  (:gen-class)
  (:require [hugsql.core :as hugsql]
            [jdbc.pool.c3p0 :as pool]
            [carica.core :refer [config]]))

(def db (pool/make-datasource-spec (config :db)))

(hugsql/def-db-fns "sql/events.sql")
(hugsql/def-db-fns "sql/tourneys.sql")
(hugsql/def-db-fns "sql/archetypes.sql")