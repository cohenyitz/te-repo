--------------------------------------------------------------------------------------------------------
-- Basic SELECT Lecture Code
--------------------------------------------------------------------------------------------------------
-- -- indicates a comment - anything following on the line is ignored
--
-- SQL SELECT statement - retrieve values form the database (Read)
--
-- A SELECT statement is often referred to as a query
--
-- Tell it WHAT you want not how to find it
--
-- In SQL NULL is a missing or unknown value - I don't know value
--
-- Cannot use = or != (actually any predicate but IS NULL or IS NOT NULL) with a NULL
-- 
-- Any operation involving a NULL results in a NULL
--
-- Basic syntax:
--
--      SELECT   - columns to include in the result (seperate mutiple column reqeusts with commas)
--      FROM     - table containing rows used in the query 
--      WHERE    - rows to include in the result - if omitted - all rows are included in result
--      ORDER BY - sequence of rows in the result
--                 without an ORDER BY the sequence of the rows in the result is not predictable
--                 if the sequence of teh rows in teh result matter - code an ORDER BY
--
-- WHERE predicates:  (predicates ia fancy name for conditions)
--
--        =  <>  !=  >  >=  <  <=     two ways to indicate not equal !=  <> 
--        IN(list-of-values)      -- alterative to a series of = OR
--        NOT IN(list-of-values)  -- alterative to a series of != AND
--        BETWEEN value AND value
--        IS NULL                 -- NULL represents a missing or unknown value - = doesn't work
--        IS NOT NULL             -- NULL represents a missing or unknown value -!= doesn't work
--        LIKE    (use wildcards: % means 0 to any number of any characters
--                                _ means exactly any one character
--        ILIKE   (case insensivtive LIKE - Postgres extension)
--
-- predicates may be combined using AND and OR
--
-- use parentheses to make your multi-predicate condition clear

-- The DISTINCT clause on a SELECT removes duplicate values from the result
-- based on the all columns that follow
--
-- The DISTINCT ON(columns/expression) clause on a SELECT removes duplicate values from the result
-- based on the all columns/expression inside the parentheses that follow (Postgres extension)
------------------------------------------------------------------------------------------------------

-- Selecting the names for all countries
SELECT name     -- I want to see the name column
  FROM country  -- in the country table
;               -- ; marks the end of an SQL statement - required if multiple statements are in file

-- Selecting the name and population of all countries
SELECT population, name   -- separate multiple columns with comma - columns in result are in same order as SELECT
FROM country
;


-- Selecting all columns from the city table
SELECT *    --  * indicates all columns in the order defined
from city   --  in the city table
;  


-- SELECT ... FROM ... WHERE
-- Selecting the cities in Ohio
SELECT *                           -- Show me all the columns in the order defined for table
 FROM city                         -- from the city table
WHERE district = 'Ohio'            -- if the district column equals 'Ohio' -- case matters
;                                  -- string literals are placed either in a set of single quotes or double quoutes 


-- Selecting countries that gained independence in the year 1776
SELECT *                   -- show me all the columns 
  FROM country             -- in the country
 WHERE indepyear = 1776    -- if the independence year is 1776 - numeric values are enclosed in any type of quotes
;

-- Selecting countries not in Asia
SELECT name, continent    -- show only name and continent columns
FROM country              -- in the country table
WHERE continent <> 'Asia' -- not in Asia
;


-- Selecting countries that do not have an independence year (it's missing, we don't know what it is)
SELECT name, indepyear
FROM country 
WHERE indepyear is Null  -- Use IS NULL to see if a column is null
;

-- Selecting countries that do have an independence year
SELECT name, indepyear 
FROM country 
WHERE indepyear IS NOT NULL  -- Use NOT NULL to see if column is not missing
;


-- Selecting countries that have a population greater than 5 million
SELECT * 
  FROM city 
 WHERE population > 5000000
;



-- SELECT ... FROM ... WHERE ... AND/OR
-- Selecting cities in Ohio and Population greater than 400,000
SELECT * 
FROM city 
WHERE district = 'Ohio' 
  AND population > 400000
;

-- Selecting country names on the continent North America or South America
-- IN predicate is a short-hand for a series of = OR
SELECT name, continent FROM country WHERE continent = 'North America' OR continent = 'South America';
SELECT name, continent FROM country WHERE continent IN ('North America', 'South America');
--SELECT name, continent FROM country WHERE continent = 'North America' OR 'South America';   -- ERROR!


-- SELECTING DATA w/arithmetic
-- Selecting the population, life expectancy, and population per area
--	note the use of the 'as' keyword
-- you can do simple arithmetic on the SELECT ( + - * /)
-- columns that are a result of an operation are called derived columns and don't have names
--                    unless you name them with an AS phrase
SELECT name
     , population
     , surFacEarea      as BillysCOlumn
     , lifeexpectancy
     , (population / surfacearea) as POPUlation_Density -- as name (1) NOT in any quotes (2) use _ to separate words
FROM country                                            --         (3) no spaces in name (4) case is ignored by postgres
WHERE continent='Asia'
;

--
-- List the continents with America in their name
--
select continent
  from country
 where continent like '%America%'  -- continent contains (%word%) the word America
 ;                                 -- % means 0 to any number of characters
 
--
-- List the continents whose name starts with 'South'
--
select continent
  from country
 where continent like 'South%'  -- continent starts with (word%) the word South
 ;                              -- % means 0 to any number of characters
 
 --
-- List the continents whose name ends with 'merica'
--
select continent
  from country
 where continent like '%merica'  -- continent ends with (%word) the word merica
 ;  

 --
-- List the continents whose name ends with 'merica'
--
select continent
  from country
 where continent ilike '%mericA'  -- continent ends with (%word) the word merica
 ;                                -- ilike ignores case


