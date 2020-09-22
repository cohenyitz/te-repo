--
-- Show any actors we have in the actor table who are not in any films
-- in the film table (ie. no entry in the film_actor table)

--
-- 1. Add some test data to the actor table we know are do not
--    have matches in the film table;

Begin transaction;
insert into actor (first_name, last_name) values('Nate', 'Elle');
insert into actor (first_name, last_name) values('Billy', 'Matthias');
insert into actor (first_name, last_name) values('Paul', 'Connor');
insert into actor (first_name, last_name) values('Brendan', 'Bryan');
insert into actor (first_name, last_name) values('Matt', 'Carl');
insert into actor (first_name, last_name) values('Gabe', 'Michael');
insert into actor (first_name, last_name) values('Justine', 'Jeff');
insert into actor (first_name, last_name) values('Tracy', 'Anthony');
insert into actor (first_name, last_name) values('Reva', '');
insert into actor (first_name, last_name) values('Karol', 'Yitzhak');

--
--  2a. Problem solved with sub-query
--

select actor_id, count(*)
from actor
where actor_id not in (Select actor_id from film_actor) 
group by actor_id
;

--
-- Problem solved with left-join actor table to file_actor table
--

select a.actor_id, a.first_name, a.last_name
from actor a
left join
film_actor fa
on a.actor_id = fa.actor_id
where fa.actor_id is null
;
--
-- 3. Reset table to original state before test data inserted
--
rollback;