-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
Begin transaction;

insert into actor (actor_id, first_name, last_name)
            values ((select (Max(actor_id)+1) from actor), 'Hampton', 'Avenue');
            
insert into actor (actor_id, first_name, last_name)
            values ((select (Max(actor_id)+1) from actor), 'Lisa', 'Byway');            

select Max(actor_id), first_name, last_name
  from actor
  Group by first_name, last_name, actor_id
  Order by actor_id;

commit;          
--Rollback;             

-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.
Begin transaction;

--delete from film where title = 'Euclidean PI';   -Was trying to delete the previous additions that I made so that
--                                                      the film id would go down to 1000 like it originaly was. 

--commit;

insert into film (title, description, release_year, language_id, length)
          values ('Euclidean PI', 'The epic story of Euclid as a pizza delivery boy in
-- ancient Greece', 2008, 1, 198);

Select * 
  from film
 where title = 'Euclidean PI';
  
commit;  
--Rollback; 


-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.

Begin transaction;

insert into film_actor (actor_id, film_id)
     values ((select actor_id from actor where first_name = 'Hampton' And last_name = 'Avenue')
            ,(select film_id from film where title = 'Euclidean PI')); 
            
insert into film_actor (actor_id, film_id)
     values ((select actor_id from actor where first_name = 'Lisa' And last_name = 'Byway')
            ,(select film_id from film where title = 'Euclidean PI'));             
select *
  from film_actor
 where actor_id in (select actor_id from actor where first_name = 'Hampton' And last_name = 'Avenue');

select *
  from film_actor
 where actor_id in (select actor_id from actor where first_name = 'Lisa' And last_name = 'Byway');
  
commit;   
--rollback;

-- 4. Add Mathmagical to the category table.

Begin transaction;

insert into category(category_id, name)
              values((select (Max(category_id)+1) from category), 'Mathmagical');

select *
  from category
 where name = 'Mathmagical';

commit;               
--rollback;             

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"

Begin transaction;

insert into film_category(film_id, category_id)
                   values((select film_id from film where title = 'Euclidean PI')
                         ,(select category_id from category where name = 'Mathmagical'));
                         
insert into film_category(film_id, category_id)
                   values((select film_id from film where title = 'EGG IGBY')
                         ,(select category_id from category where name = 'Mathmagical'));
                         
insert into film_category(film_id, category_id)
                   values((select film_id from film where title = 'KARATE MOON')
                         ,(select category_id from category where name = 'Mathmagical'));
                         
insert into film_category(film_id, category_id)
                   values((select film_id from film where title = 'RANDOM GO')
                         ,(select category_id from category where name = 'Mathmagical'));
                         
insert into film_category(film_id, category_id)
                   values((select film_id from film where title = 'YOUNG LANGUAGE')
                         ,(select category_id from category where name = 'Mathmagical'));                                                                                                    

select *
  from film_category
 where category_id = 17;
 
commit; 
--rollback;

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)

Begin transaction;

update film
Set rating = 'G' 
where film_id IN (
                      Select film_id
                      from film_category 
                      where category_id = (Select category_id From category Where name = 'Mathmagical')
                   );
--Rollback;
commit;
--rollback;

-- 7. Add a copy of "Euclidean PI" to all the stores.
BEGIN TRANSACTION;

INSERT INTO inventory(film_id, store_id)
               VALUES(1006, 1);

INSERT INTO inventory(film_id, store_id)
               VALUES(1006, 2);
 
SELECT *
  FROM inventory
 WHERE film_id = 1006;

--ROLLBACK;
COMMIT;

-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>
BEGIN TRANSACTION;                                      -- No it did not delete, because the movie is still being used by other tables

DELETE FROM film WHERE title = 'Euclidean PI';

COMMIT;
-- 9. Delete Mathmagical from the category table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>
BEGIN TRANSACTION;                                      -- No it did not delete, because Mathmagical is still being referenced in other tables

DELETE FROM category WHERE name = 'Mathmagical';

COMMIT;

-- 10. Delete all links to Mathmagical in the film_category tale.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>
BEGIN TRANSACTION;                                      -- Yes it succeeded, because we are removing the "child" not the "parent"

DELETE FROM film_category WHERE category_id = 17;

COMMIT;

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)
-- <YOUR ANSWER HERE>
BEGIN TRANSACTION;                                      -- Yes it was deleted successfuly, because we removed the locations it was being referenced to
                                                        --              and now we can delete the "parent" successfuly.

DELETE FROM category WHERE name = 'Mathmagical';

COMMIT;

-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.

--NEED TO REMOVE FROM INVENTORY, NEED TO REMOVE FROM FILM ACTOR TABLE

BEGIN TRANSACTION;

DELETE FROM film WHERE title = 'Euclidean PI';

ROLLBACK;


SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS;
SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE;
SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS;
