-- :name get-archetypes-with-tag-list :n
select la.id as id, la.pretty, count(distinct(tl.id)) as total_count, group_concat(distinct(t.tagtext)) as tag_list
from list_archtype la
left outer join tourney_list tl on la.id = tl.archtype_id
left outer join archtype_tag atag on la.id = atag.archtype_id
left outer join tag t on atag.tag_id = t.id
group by la.id
order by total_count desc

-- :name get-archetype-tourney-lists :? :n
select *
from tourney_list
where archtype_id = :id