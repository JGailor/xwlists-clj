-- :name get-tourney-by-id :? :1
select * from tourney where id = :id

-- :name get-tourneys :n
select * from tourney order by id;

-- :name get-tourneys-with-venues :n
select t.id as id,
       t.tourney_name as tourney_name,
       t.tourney_date as tourney_date,
       t.tourney_type as tourney_type,
       t.round_length as round_length,
       t.participant_count as participant_count,
       tv.country as venue_country,
       tv.state as venue_state,
       tv.city as venue_city,
       tv.venue as venue
from tourney t
left outer join tourney_venue tv on t.id = tv.tourney_id
order by t.id;

-- :name get-round-results-for-tourney-list
select *
from round_results
where
  winner_id = :list_id or
  loser_id = :list_id