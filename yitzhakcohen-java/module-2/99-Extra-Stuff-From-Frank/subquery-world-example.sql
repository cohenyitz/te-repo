--
-- What is the smallest country by size?
--
select surfacearea
  from country
  order by surfacearea
 limit 1;
 --
 -- Karol asked: what's the name?
 --
 select name, surfacearea
  from country
  order by surfacearea
 limit 1;
 
  select name
  from country
  order by surfacearea
 limit 1;

--
-- What is the smallest country by size?
--
 select min(surfacearea)
   from country
;
 --
 -- Karol (Frank version) asked: what's the name and I want use use min()
 --
 -- Use a subquery to get the result from the database and use it in an outer query
 --
  select name, surfacearea
   from country
  where surfacearea = -- the smallest surfacearea in the country table
                    (Select min(surfacearea)
                       from country)
;
--
-- Which countries have a surfacearea greater than the average surfacearea of all countries?
--
-- 1. Find the average surfacearea of all countries
-- 2. See if a country's surfacearea is greater what we found is step 1
--

select name, surfacearea
  from country
 where surfacearea > (select avg(surfacearea)  -- the average surfacearea of all countries
                        from country)
order by surfacearea desc
 ;


