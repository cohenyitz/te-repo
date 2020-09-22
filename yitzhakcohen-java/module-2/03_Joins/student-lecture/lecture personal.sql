--
-- An SQL Join is needed when you require columns from multiple tables
--
-- Two Join fomats:
--
-- Tradiotianl: Opportunity for error - forget join predicates - Cartesian Product (A lot more rows than you want)
-- 
--      1. Select - the columns you want in theresult using qualifiers if duplicate names you need 
--      2. From   - code table names seperated by columns with optional correlation names (nicknames, alias)
--      3. Where  - columns that match between the tables (Join condition)
--      4. Additional where predicates, GROUP BY, ORDER BY, ORDER BY, LIMIT are also allowed 
--
--      if you forgot the join condition - no error was genterated 
--              what was returned is Catersian Product - each row from one table 
--                      is returned with each row from the other
--
--      if one table had 100 rows and the other table had 1000 rows the result would have 100,000
--
-- Modern:    Safer -   
--
--      1. Select - the columns you want in theresult using qualifiers if duplicate names you need 
--      2. From   - code one table name with optional correlation name (nickname, alias)
--      3. INNER JOIN - the type of Join - INNER JOIN is the matching Join
--      4. other-table - with optional correlation name (nickname, alias)
--      5. On join-condition - any WHERE predicate you know
--
-- List city name,country, continent
-- in the world
--
-- city name - city table
-- country name and continent is in the county table 
--
-- We need a Join due to having columns in multiple tables
--
-- Tradional Syntax
--
Select ct.name as City_Name                -- city name - city table        
     , cy.name as Country_Name             -- country name - country table
     , continent                        -- continent - country table
  from city       ct --correlatioin name (nick names or alias)may be assigned to table to ease coding 
     , country    cy --correlatioin name (nick names or alias)may be assigned to table to ease coding
  where cy.code = ct.countrycode             -- only rows where the country code in country =country code in city  
  And   cy.population > 1000000
  Order by cy.population;   
--            
--            
--            
--
-- Modern Syntax
--
Select ct.name as City_Name                -- city name - city table        
     , cy.name as Country_Name             -- country name - country table
     , continent                        -- continent - country table
  from city       ct --correlatioin name (nick names or alias)may be assigned to table to ease coding 
       inner join    -- type of join - inner join - matching rows between tables  
       country    cy --correlatioin name (nick names or alias)may be assigned to table to ease coding
  on cy.code = ct.countrycode;             -- join condintion - how to match rows between the tables                