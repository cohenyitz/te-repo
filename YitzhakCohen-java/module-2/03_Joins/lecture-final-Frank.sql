--
-- An SQL Join is needed when you require columns from multiple tables
--
-- Two Join formats:
--
--  Traditional: Opportunity for error - forget join predicates - Cartesian Product (A lot more rows that you want)
--
--     1. Select - the columns you want in the result using qualifiers if dupliacte names you need
--     2. From   - code table names separated by columns with optional correlation names (nicknames, aliases)
--     3. Where  - columns that match bewteen the tables (Join condition)
--     4. Additional Where predicates, GROUP BY, ORDER BY LIMIT are also allowed
--
--     if you forgot the join condition - no error was generated
--            what was returned is Catersian Product 
--                   each from from one table is returned with each row from the other
--     if one table had 100 rows and the other table had 1000 rows the result would have 100,000 rows
--
--   Modern:  Safer - no way to forget the join predicate
--
--     1. Select - the columns you want in the result using qualifiers if dupliacte names you need
--     2. From   - code one table name with optional correlation name (nickname, alias)
--     3. INNER JOIN - the type of Join - INNER JOIN is the matching Join
--     4. other-table - with optional correlation name (nickname, alias)
--     5. ON join-condition - any WHERE predicate you know
--
--
-- List city name, country, continent 
-- in the world
--
-- city name - City table
-- country name and continent is in the country table
--
-- We need a Join due to having columns in multiple tables
--
--
-- Traditional Syntax - 2 table join
--
Select ct.name as City_Name        -- City name    - City table
     , cy.name as Country_Name     -- Country Name - Country table
     , continent                   -- Continent    - Country table
  from city    ct      -- Correlation name (nickname or alias) may be assigned to table to ease coding    
      ,country cy      -- Correlation name (nickname or alias) may be assigned to table to ease coding 
 where cy.code = countrycode    -- Only rows where the country code in country = country code in city
   and cy.population > 1000000     -- Only show cityies with more than one million people
 order by cy.population  
 ;
 --
 -- Modern Syntax - 2 table join
 --
Select ct.name as City_Name        -- City name    - City table
     , cy.name as Country_Name     -- Country Name - Country table
     , continent                   -- Continent    - Country table
  from city    ct      -- Correlation name (nickname or alias) may be assigned to table to ease coding 
       inner join      -- type of join - inner join - match rws bewteen tables   
       ,country cy      -- Correlation name (nickname or alias) may be assigned to table to ease coding 
    on cy.code = countrycode    -- join condition - how to match rows bewteen the tables
    where cy.code = countrycode    -- Only rows where the country code in country = country code in city
   and cy.population > 1000000     -- Only show cityies with more than one million people
 order by cy.population  
 ;
--
-- Traditional Syntax - 3 table join
--
Select ct.name as City_Name        -- City name       - City table
     , cy.name as Country_Name     -- Country Name    - Country table
     , continent                   -- Continent       - Country table
     , language                    -- Language spoken - countrylanguage table
  from city    ct      -- Correlation name (nickname or alias) may be assigned to table to ease coding    
      ,country cy      -- Correlation name (nickname or alias) may be assigned to table to ease coding
      ,countrylanguage cl 
 where cy.code = ct.countrycode       -- Only rows where the country code in country = country code in city
   and cy.code = cl.countrycode
 ;
 --
 -- Modern Syntax - 3 table join
 --
Select ct.name as City_Name        -- City name       - City table
     , cy.name as Country_Name     -- Country Name    - Country table
     , continent                   -- Continent       - Country table
      , language                    -- Language spoken - countrylanguage table
  from city    ct      -- Correlation name (nickname or alias) may be assigned to table to ease coding 
       inner join      -- type of join - inner join - match rws bewteen tables   
       country cy      -- Correlation name (nickname or alias) may be assigned to table to ease coding 
    on cy.code = countrycode    -- join condition - how to match rows bewteen the tables
       inner join
       countrylanguage cl
    on cy.code = cl.countrycode
 ;