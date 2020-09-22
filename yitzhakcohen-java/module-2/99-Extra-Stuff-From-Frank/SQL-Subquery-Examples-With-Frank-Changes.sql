--------------------------------------------------------------------------------------------------------
-- SUBQUERIES - Using the result from one query (inner query) in another query (outer query)
--
-- Frequently used in a WHERE clause with an IN predicate:
--
--       WHERE column-name IN (SELECT column-name FROM some-table WHERE some-predicate)
--
-- Any WHERE predicate may be used to connect the subquery in a WHERE clause, but you must
-- be sure a single value is returned from the subquery. 
--
-- Subqueries may also be used in a SELECT as a column-specification or a FROM as a table
-- (These are advanced concepts we will discuss later, if there is time)
--
-- Show the cities under the same given government leader


-- Show countries with the same independece year


-- Show the cities cities whose country has not yet declared independence yet


--
-- Subquery - use the result from one query in anotehr query (the outer query)
--
-- Used in WHERE - Where column in (subquery)
--
-- Subquery is always enclosed in ()
--
-- show the minimum life expectancy in the country table
-- include the name of the country
--
-- without min/limit
--
-- 1. run the subquery to get the min(lifeexpectancy)
-- 2. plug the resultof subquery into the where clause
--
-- it is safer to use IN instead = for a subquery - if subquery returns multiple values the = fails
--
select name, lifeexpectancy
  from country
where lifeexpectancy IN (select min(lifeexpectancy)  -- subquery - a select for a value used in a where clause
                          from country)       
;

--
-- Alternate solution without a subquery
--
select name, lifeexpectancy
  from country
  where lifeexpectancy is not Null
  order by lifeexpectancy asc
  limit 1
  ;
 --
 -- list name and lifeexpectancy for all countries where lifexpectancy is greater than the average lifeexpectency of all countries
 --
 -- 1. determine the average life expectancy
 -- 2. find all countries whose life expecancy if GT what you found in 1
 --
select name, lifeexpectancy
  from country
 where lifeexpectancy > (select avg(lifeexpectancy) 
                          from country)
   and continent = 'Europe'
 order by 2 desc
  ;
  