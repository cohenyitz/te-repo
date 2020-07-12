<<<<<<< HEAD
--------------------------------------------------------------------------------------------------------
-- Basic SELECT Lecture Code
--------------------------------------------------------------------------------------------------------
-- -- indicates a comment - anything following on the line is ignored
--
-- SQL SELECT statement - retrieve values form the database (Read)
--
-- A SELECT statement is often referred to as a query
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
-- WHERE predicates:
--
--        =  <>  !=  >  >=  <  <=  two ways to indicate inc=dicate not equal != <>
--        IN(list-of-values)      -- alterative to a series of = OR
--        NOT IN(list-of-values)  -- alterative to a series of != AND
--        BETWEEN value AND value
--        IS NULL
--        IS NOT NULL
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
SELECT name                     -- I want to see the name column
FROM country                    -- in the country table
;                               -- ; marks the end of an SQL statement - required if multiple statements are in a file

-- Selecting the name and population of all countries
SELECT name, population         -- seperate multiple columns with comma
FROM country;


-- Selecting all columns from the city table
SELECT *                        -- * indicates all columns in the order defined 
from city;                      -- in the coty table
=======
-- SELECT ... FROM
-- Selecting the names for all countries


-- Selecting the name and population of all countries


-- Selecting all columns from the city table
>>>>>>> 2de066a2a834a98f53726bdeaa95028e2c365ee0


-- SELECT ... FROM ... WHERE
-- Selecting the cities in Ohio
<<<<<<< HEAD
SELECT *                        -- Show me all the rows
FROM city WHERE district = 'Ohio';-- drom the city table
                                -- if the districe column equals "Ohito" -- case matters
                                -- string letters are placed either in a set of singel quotes or double quotes 
=======
>>>>>>> 2de066a2a834a98f53726bdeaa95028e2c365ee0


-- Selecting countries that gained independence in the year 1776


-- Selecting countries not in Asia


-- Selecting countries that do not have an independence year

-- Selecting countries that do have an independence year


-- Selecting countries that have a population greater than 5 million



-- SELECT ... FROM ... WHERE ... AND/OR
-- Selecting cities in Ohio and Population greater than 400,000

-- Selecting country names on the continent North America or South America




-- SELECTING DATA w/arithmetic
-- Selecting the population, life expectancy, and population per area
--	note the use of the 'as' keyword


--
-- List the continents with America in their name

select continent 
  from country
where continent like '%America%'  --continent conatins(%word%) the word America 
;                                 -- % means 0 to any number of characters

--
-- List the continents whose name starts with 'South'

select continent 
  from country
where continent like 'South%'  --continent starts (word%) with the word South
;                              -- % means 0 to any number of characters 

--
-- List the continents whose name ends with 'merica'

select continent 
  from country
where continent like '%merica'  --continent ends with (%word)  the word merica
;                              -- % means 0 to any number of characters 

--
-- List the continents whose name ends with 'merica'

select continent 
  from country
where continent ilike '%mericA'  --continent ends with (%word)  the word merica
;                              -- % means 0 to any number of characters 
                               ilike ignores the case                    
