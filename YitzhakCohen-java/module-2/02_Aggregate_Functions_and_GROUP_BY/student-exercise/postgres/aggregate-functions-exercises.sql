-- The following queries utilize the "world" database.
-- Write queries for the following problems. 
-- Notes:
--   GNP is expressed in units of one million US Dollars
--   The value immediately after the problem statement is the expected number 
--   of rows that should be returned by the query.

-- 1. The name and state plus population of all cities in states that border Ohio 
-- (i.e. cities located in Pennsylvania, West Virginia, Kentucky, Indiana, and 
-- Michigan).  
-- The name and state should be returned as a single column called 
-- name_and_state and should contain values such as ‘Detroit, Michigan’.  
-- The results should be ordered alphabetically by state name and then by city 
-- name. 
-- (19 rows)
Select name || ', ' || district as name_and_state
        , population 
        from city
        where district in('Pennsylvania', 'West Virginia', 'Kentucky', 'Indiana', 'Michigan')
        Order by district ASC, name ASC;

-- 2. The name, country code, and region of all countries in Africa.  The name and
-- country code should be returned as a single column named country_and_code 
-- and should contain values such as ‘Angola (AGO)’ 
-- (58 rows)
Select name || ' ' || '(' || code || ')' as country_and_code
           , region
        from country
        where continent = 'Africa';
        

-- 3. The per capita GNP (i.e. GNP multipled by 1000000 then divided by population) of all countries in the 
-- world sorted from highest to lowest. Recall: GNP is express in units of one million US Dollars 
-- (highest per capita GNP in world: 37459.26)
Select trunc(gnp * 1000000 / population, 2) as per_capita_gnp
        from country
        where population <> 0 
	Order by per_capita_gnp DESC;
        


-- 4. The average life expectancy of countries in South America.
-- (average life expectancy in South America: 70.9461)
Select trunc(AVG(lifeexpectancy)::numeric,4) 
        from country
        where region = 'South America';
        

-- 5. The sum of the population of all cities in California.
-- (total population of all cities in California: 16716706)
Select SUM(population)
        from city
        where district = 'California';

-- 6. The sum of the population of all cities in China.
-- (total population of all cities in China: 175953614)
Select SUM(population)
        from city
        where countrycode = 'CHN';

-- 7. The maximum population of all countries in the world.
-- (largest country population in world: 1277558000)
Select MAX(population)
        from country;

-- 8. The maximum population of all cities in the world.
-- (largest city population in world: 10500000)
Select MAX(population)
        from city;

-- 9. The maximum population of all cities in Australia.
-- (largest city population in Australia: 3276207)
Select MAX(population)
        from city
        where countrycode = 'AUS';

-- 10. The minimum population of all countries in the world.
-- (smallest_country_population in world: 50)
Select MIN(population) as smallest_country_population_in_world
        from country
        where population <> 0;


-- 11. The average population of cities in the United States.
-- (avgerage city population in USA: 286955.3795)
Select trunc(AVG(population),4)
        from city
        where countrycode = 'USA';

-- 12. The average population of cities in China.
-- (average city population in China: 484720.6997 approx.)
Select trunc(AVG(population),4)
        from city
        where countrycode = 'CHN';

-- 13. The surface area of each continent ordered from highest to lowest.---???????
-- (largest continental surface area: 31881000, "Asia")
Select distinct continent, surfacearea                
        from country
        Group by surfacearea, continent 
        Order by continent DESC;
        
 
-- 14. The highest population density (population divided by surface area) of all 
-- countries in the world. 
-- (highest population density in world: 26277.7777)
Select  trunc((population/ surfacearea)::numeric, 4) as pop_density
        from country
        where population <> 0
        order by pop_density DESC
        Limit 1;


-- 15. The population density and life expectancy of the top ten countries with the 
-- highest life expectancies in descending order. 
-- (highest life expectancies in world: 83.5, 166.6666, "Andorra")
Select name, lifeexpectancy, trunc((population/ surfacearea)::numeric,4) as pop_density
        from country 
        where lifeexpectancy IS NOT NULL
        Order by lifeexpectancy DESC
        Limit 10;

-- 16. The difference between the previous and current GNP of all the countries in --?????
-- the world ordered by the absolute value of the difference. Display both 
-- difference and absolute difference.
-- (smallest difference: 1.00, 1.00, "Ecuador")
Select COUNT(abs(gnpold) as gnp_old - abs(gnp)) as current_gnp, name
        from country
        where gnpold IS NOT NULL
        Group by gnpold, gnp, name;
        --Order by Count(abs(gnpold) - abs(gnp)), DESC;
        

-- 17. The average population of cities in each country (hint: use city.countrycode) 
-- ordered from highest to lowest.
-- (highest avg population: 4017733.0000, "SGP")
Select trunc(AVG(population),4), countrycode
        from city
        Group by countrycode
        Order by AVG(population) DESC;
        
	
-- 18. The count of cities in each state in the USA, ordered by state name.
-- (45 rows)
Select district, Count(*)
        from city
        where countrycode = 'USA'
        Group by district
        Order by district ASC;
	
-- 19. The count of countries on each continent, ordered from highest to lowest.
-- (highest count: 58, "Africa")
Select continent, Count(*)
        from country
        Group by continent 
        Order by Count(*) DESC;
        
	
-- 20. The count of cities in each country ordered from highest to lowest.
-- (largest number of  cities ib a country: 363, "CHN")
Select Count(*), countrycode
        from city
        Group by countrycode
        Order by Count(*) DESC;
	
-- 21. The population of the largest city in each country ordered from highest to 
-- lowest.
-- (largest city population in world: 10500000, "IND")
select population, countrycode
        from city 
        Group by population, countrycode
        Order by population DESC;

-- 22. The average, minimum, and maximum non-null life expectancy of each continent 
-- ordered from lowest to highest average life expectancy. 
-- (lowest average life expectancy: 52.5719, 37.2, 76.8, "Africa")
Select trunc(AVG(lifeexpectancy)::numeric, 4), MIN(lifeexpectancy), MAX(lifeexpectancy), continent
        from country
        where lifeexpectancy IS NOT NULL
        Group by continent
        Order by AVG(lifeexpectancy) ASC;
