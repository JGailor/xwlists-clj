(ns xwlists-clj.services.archetypes
  (:gen-class))

(def default-pk 100)

(defn standard-format-tourney?
  "Is this tourney a standard format"
  [t]
  (= (t :format) "Standard - 100 Point Dogfight"))

(defn calculate-points-killed
  "Determines how to resolve points killed for a round result"
  [target result points-killed]
  (if (= (result :list1_id) (result target))
    (+ points-killed (get result :list1_score 0))
    (+ points-killed (get result :list2_score 0))))

(defn calculate-points-killable
  "Determines how to resolve points killable for a round result"
  [target result points-killable]
  (if (= (result :list1_id) (result target))
    (let [loser-points (result :loser_points 100)
          pk (if (= 0 loser-points) default-pk loser-points)]
      (+ points-killable pk))))

(defn calculate-points-lost
  "Determines how to resolve points lost in a round"
  [target result points-lost]
  (if (= (result :list1_id) (result target))
    (+ points-lost (get result :list2_score 0))
    (+ points-lost (get result :list1_score 0))))

(defn accumulate-round-rates
  "Combines an existing result for win rates with a new result"
  [acc result type]
  (let [field (if (= type :win) :winner_id :loser_id)
        points-field (if (= type :win) :winner_points :loser_points)
        draw (if (result :draw) 1 0)
        win (if (= 0 draw) 0 1)
        points-killed (calculate-points-killed field result (acc :points-killed 0))
        points-killable (calculate-points-killable field result (acc :points-killable 0))
        points-lost (calculate-points-lost field result (acc :points-lost 0))
        points-losable (+ (result points-field) (acc :points-losable 0))]
    {:points-killed points-killed :points-killable points-killable
     :points-lost points-lost :points-losable points-losable}))

(defn calculate-win-rates
  "Computes stats for rounds where the archetype won"
  [win-rates]
  (reduce (fn [acc])))

(defn compute-archetype-stats
  "Computes the stats for a given archetype based on tournaments"
  [archetype tournaments]
  (if (and (standard-format-tourney? tournament)
           (> (archetype :points) 0))
    (let [round_results (q/get-round-results-for-tourney-list q/db)])))