--------------------------------------------------------------------------------------------------------
-- Ordering, Grouping Basic Functions Lecture Code
--------------------------------------------------------------------------------------------------------
--
-- The order of rows in the result (returned) is undefined unless you code an ORDER BY
--
-- The database manager does not guarantee the order of the rown unless you have an ORDER BY
--
-- The same query without an ORDER BY may return the same order of the results 100 time in a row
--      the 101st time could be different 
--
-- If the order of the rows in the result matter - code an ORDER BY - DO NOT ASSUME THE ORDER IS ALWAYS THE SAME
--
-- null values are sorted as a group at the beginning of result - if included 
--      use IS NOT NULL to exclude null from the results

-- ORDER BY -  Sequence of Rows in Result
--
--    ORDER BY          -- Ascending Sequence (low-high)
--    ORDER BY ASC      -- Ascending Sequence (low-high)
--    ORDER BY DESC     -- Descending Sequence (high-low)

-- Show Populations of all countries in acscending order
Select name, population
        from country
        order by population;


-- Show Populations of all countries in descending order only if population is greater than 1000000
Select name, population
        from country
        where population > 1000000
        order by population DESC;


-- Show  the names of countries and continents in ascending order 
Select name, continent
        from country
        order by continent ASC;
        
-- Show population density 
Select name , population/ surfacearea 
        from country
        order by 2; 
        
Select name , population/ surfacearea as pop_density
        from country
        order by pop_density;        

--------------------------------------------------------------------------------------------------------
-- Limiting the number of rows in the result
--
-- LIMIT n   - Limit the number of rows in the result - always goes at thE end of the SELECT
--
-- LIMIT is a postreSQL wowrd - all database manager have a way to LIMIT results - might be called something else
--
-- Show the name and average life expectancy of the countries with the 10 highest life expectancies.
-- distinct shows the unique values
 Select distinct name, lifeexpectancy  -- distinct is applied to combinantion  all columns in the select
        from country
        where lifeexpectancy IS NOT NULL
        Order by lifeexpectancy DESC
        Limit 10; -- only show the first 10 rows from the result
        
 

--------------------------------------------------------------------------------------------------------
-- Concatenating values 
--
-- the concat operator (||) may be used to concatenate character (string) values in a result
--

-- Show the name & state in the format: "city-name, state"
-- of all cities in California, Oregon, or Washington.
-- sorted by state then city

Select name || ', ' || district as city_name    --column in result
        from city
        where district = 'California'
        OR district = 'Oregon'
        OR district = 'Washington'
        order by district, name;                -- order of rows in the result
 
 Select name || ', ' || district as city_name    --column in result
        from city
        where district in('California', 'Oregon', 'Washington')
        order by district, name;                -- order of rows in the result

--------------------------------------------------------------------------------------------------------
-- Aggregate functions - produce one row in result for each group specified
--
-- The group used by the aggregate functions is determined by the GROUP BY clause
-- if no GROUP BY clause is specified, the group is the set of rows in the result
--
--     AVG(column-expression)   - arithmentic average for group of non-NULL values in expression 
--     SUM(column-expression)   - arithmentic sum for group of a non-NULL values in expression 
--     MIN(column-expression)   - lowest value for group of non-NULL values in expression 
--     MAX(column-expression)   - highest value for group of non-NULL values in expression 
--     COUNT(*)                 - number of rows in the group
--     COUNT(column-expression) - number of rows for the group of non-NULL values in expression 
--
--
--      AVG, MIN, MAX, SUM - work on columns - AVG(column) Sum(column)
--
--      COUNT - works on rows - how many rows?
--
--
--
-- AVG(), SUM() may only be used with numeric data types
-- MIN(), MAX() may be used with numeric, character, date, time datatypes
--
-- COUNT() is applied to rows (not columns)
--
-- null values are ignored by all the aggregate functions
--
-- Show average life expectancy in the world
Select AVG(lifeexpectancy)         -- avg of non-null lifeexpectancy of the entire table
        from country;
                                   -- no group by specified so one value for entire table is generated 
-- Show average life expectancy of each continent
Select continent,  AVG(lifeexpectancy)         -- avg of non-null lifeexpectancy of the entire table
        from country
        where lifeexpectancy IS NOT NULL       -- don't include any rows if lifeexpectancy is unknown
        group by continent;                    -- specify the group for the aggregate function - one value for each continent 
               

-- Show the total population in Ohio
Select SUM(population) as Ohio_Population
        from city
        where district = 'Ohio';
        
-- Show the total population in Ohio
--
-- When using a Group By, the only columns allowed in the Select are columns 
--      named in the group by or in the function
--
-- column in the Select tells SQL you want one row in the result for every row that matches the where clause
-- GROUP BY tells SQL you want one row in the result for each distinct value for column in the finuction
--
-- confilicting requests when column not in group by is coded with aggregate 
-- 
--
-- This SQL causes an error - combines a column and aggregate function on the same select without a group by

--Select name, SUM(population) as Ohio_Population
--        from city
--        where district = 'Ohio'
            


-- Show the surface area of the smallest country in the world
Select name, MIN(surfacearea) as smallest_area
        from country
        Group By name 
        Order by Smallest_area ASC
        Limit 1;
        
        
Select name, surfacearea as smallest_area
        from country
        Order by Smallest_area ASC      -- combination of order by
        Limit 1;                        -- and limit 1 can be used in place of min/max

-- Show The 10 largest countries (by surface area) in the world
Select name, surfacearea
        from country 
        Order by surfacearea DESC
        Limit 10;

-- Show the number of countries who declared independence in 1991
Select count(*)                 -- * means all the rows
        from country 
        where indepyear = 1991;
        
        
Select count(name)         -- any column name can be included in count
        from country 
        where indepyear = 1991;        
        

--------------------------------------------------------------------------------------------------------
-- GROUP BY  - Specify the group to which the aggregate functions apply
--
--      GROUP BY column-expression
--
-- When using a GROUP BY the SELECT is limited ot aggreggate functions or columns in the GROUP BY
--
--

-- Show the number of countries where each language is spoken, order show them from most countries to least
Select count(*), language
        from countrylanguage
        group by language
        Order by count(*) DESC;
        


-- Show the average life expectancy of each continent ordered from highest to lowest



-- Exclude Antarctica from consideration for average life expectancy



-- What is the sum of the population of cities in each state in the USA ordered by state name



-- What is the average population of cities in each state in the USA ordered by state name


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


--------------------------------------------------------------------------------------------------------
--
-- Additional samples
--
-- You may alias column and table names to provide more descriptive names
--
SELECT name AS CityName 
  FROM city AS cities

-- Ordering allows columns to be displayed in ascending order, or descending order (Look at Arlington)
SELECT name
     , population 
  FROM city 
 WHERE countryCode='USA' 
 ORDER BY name ASC, population DESC
;
-- Limiting results allows rows to be returned in 'limited' clusters where LIMIT says how many, 
-- and an optional OFFSET specifies number of rows to skip
SELECT name
     , population 
  FROM city 
  LIMIT 10 OFFSET 10
;