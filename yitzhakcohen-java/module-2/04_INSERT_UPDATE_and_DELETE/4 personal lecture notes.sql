--
-- What is the smallest country by size?
--
select surfacearea
  from country
  order by surfacearea 
  limit 1;
--
--WHats the name?
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
--  What is the smallest country by size?
--
Select min(surfacearea)
  from country; 
--
--Karol (Frankversion) whats the name and I want to use min()
--
--Use a subquery to get the result from the database  and use it in an outer query
Select name, surfacearea
  from country 
  where surfacearea =  -- the smalllest surfacearea in the country table
                    (select min(surfacearea)from country); 
--
--
--
-- Which countries have a surfacearea greater than the average surfacearea of all countries?
--
-- 1. Find the average surfacearea of all countries  
-- 2. See if a country's surface is greater than what we found
--

Select name, surfacearea
  from country
  where surfacearea > (Select avg(surfacearea)       -- the average surfacearea of all countries
                        from country)
  Order by surfacearea DESC;

Select avg(surfacearea)       -- the average surfacearea of all countries
  from country;                    

  
