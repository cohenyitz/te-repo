-- The following queries utilize the "dvdstore" database.

-- 1. All of the films that Nick Stallone has appeared in
-- (30 rows)
Select title 
        , first_name
        , last_name
   from actor        act
        inner join
        film_actor   fa
     on act.actor_id = fa.actor_id
        inner join
        film         fl   
     on fl.film_id = fa.film_id
     where first_name = 'NICK'
     And last_name = 'STALLONE';   

-- 2. All of the films that Rita Reynolds has appeared in
-- (20 rows)
Select title 
        , first_name
        , last_name
   from actor        act
        inner join
        film_actor   fa
     on act.actor_id = fa.actor_id
        inner join
        film         fl   
     on fl.film_id = fa.film_id
     where first_name = 'RITA'
     And last_name = 'REYNOLDS'; 

-- 3. All of the films that Judy Dean or River Dean have appeared in
-- (46 rows)
Select title 
        , first_name
        , last_name
   from actor        act
        inner join
        film_actor   fa
     on act.actor_id = fa.actor_id
        inner join
        film         fl   
     on fl.film_id = fa.film_id
     where (first_name = 'JUDY'
     And last_name = 'DEAN')
     OR  (first_name = 'RIVER'
     And last_name = 'DEAN'); 


-- 4. All of the the ‘Documentary’ films
-- (68 rows)
Select title 
        , name
   from category        cat
        inner join
        film_category   fc
     on cat.category_id = fc.category_id
        inner join
        film         fl   
     on fl.film_id = fc.category_id
     where name = 'Documentary'; 

-- 5. All of the ‘Comedy’ films
-- (58 rows)
Select title 
        , name
   from category        cat
        inner join
        film_category   fc
     on cat.category_id = fc.category_id
        inner join
        film         fl   
     on fl.film_id = fc.category_id
     where name = 'Comedy'; 

-- 6. All of the ‘Children’ films that are rated ‘G’
-- (10 rows)
Select title 
        , name
        , rating
   from category        cat --can be from any table
        inner join
        film_category   fc --table trying to link to
     on cat.category_id = fc.category_id -- matching/comparing/verifying keys between both tables...from table 1 = innerjoin table2
        inner join
        film         fl   
     on fl.film_id = fc.film_id
     where name = 'Children'  
     And rating = 'G';

-- 7. All of the ‘Family’ films that are rated ‘G’ and are less than 2 hours in length
-- (3 rows)
Select title, name, rating, length
        from category cat
        inner join 
        film_category 
     on cat.category_id = film_category.category_id  
        inner join
        film
     on film_category.film_id = film.film_id
     where name = 'Family'
     And rating = 'G'
     And length < 120;  

-- 8. All of the films featuring actor Matthew Leigh that are rated ‘G’
-- (9 rows)
Select  title, first_name, last_name, rating
       from actor
       inner join
       film_actor
    on actor.actor_id = film_actor.actor_id
       inner join
       film
    on film_actor.film_id = film.film_id
    where first_name = 'MATTHEW'
    And last_name = 'LEIGH'
    And rating = 'G';
    
-- 9. All of the ‘Sci-Fi’ films released in 2006
-- (61 rows)
Select title, name
       from category cat
       inner join
       film_category fc
    on cat.category_id = fc.category_id
       inner join
       film          fl
    on fc.film_id = fl.film_id
    where name = 'Sci-Fi'
    and release_year = 2006;

-- 10. All of the ‘Action’ films starring Nick Stallone
-- (2 rows)
Select first_name, last_name, title, name 
       from actor    act
       inner join
       film_actor    fa
    on act.actor_id = fa.actor_id
       inner join
       film          fl
    on fa.film_id = fl.film_id
       inner join
       film_category fc
    on fl.film_id = fc.film_id
       inner join
       category      cat
    on fc.category_id = cat.category_id
    where first_name = 'NICK'
    And last_name = 'STALLONE'
    And name = 'Action';

-- 11. The address of all stores, including street address, city, district, and country
-- (2 rows)
Select address, city, district, country
        from store
        inner join
        address
     on store.address_id = address.address_id
        inner join
        city
     on address.city_id = city.city_id
        inner join
        country
     on city.country_id = country.country_id;

-- 12. A list of all stores by ID, the store’s street address, and the name of the store’s manager
-- (2 rows)
Select store, address, first_name, last_name
       from store
       inner join 
       address
    on store.address_id = address.address_id
       inner join 
       staff
    on store.manager_staff_id = staff.staff_id;

-- 13. The first and last name of the top ten customers ranked by number of rentals 
-- (#1 should be “ELEANOR HUNT” with 46 rentals, #10 should have 39 rentals)
Select first_name, last_name, Count(*)
       from customer
       inner join
       rental
    on customer.customer_id = rental.customer_id
       inner join
       payment
    on rental.rental_id = payment.rental_id
    Group by last_name, first_name
    Order by Count(*) DESC
    Limit 10;
    

-- 14. The first and last name of the top ten customers ranked by dollars spent 
-- (#1 should be “KARL SEAL” with 221.55 spent, #10 should be “ANA BRADLEY” with 174.66 spent)
Select first_name, last_name,Sum(amount)  as total_spent
       from customer
       inner join
       payment
    on customer.customer_id = payment.customer_id
    Group by first_name, last_name
    Order by Sum(amount) DESC
    Limit 10;
    
-- 15. The store ID, street address, total number of rentals, total amount of sales (i.e. payments), and average sale of each store.
-- (NOTE: Keep in mind that an employee may work at multiple stores.)
-- (Store 1 has 7928 total rentals and Store 2 has 8121 total rentals)   ---???????
Select store, address, inventory, rental, payment, Sum(amount) 
        from store
        inner join 
        address
     on store.address_id = address.address_id
        inner join
        inventory
     on store.store_id = inventory.store_id
        inner join
        rental
     on inventory.inventory_id = rental.inventory_id
        inner join
        payment
     on rental.rental_id = payment.rental_id
     Group by store.store_id, address, inventory, rental, payment
     Order by store.store_id, amount DESC;
  --   where  Sum(rental_date = payment_date);

-- 16. The top ten film titles by number of rentals
-- (#1 should be “BUCKET BROTHERHOOD” with 34 rentals and #10 should have 31 rentals)

-- 17. The top five film categories by number of rentals 
-- (#1 should be “Sports” with 1179 rentals and #5 should be “Family” with 1096 rentals)

-- 18. The top five Action film titles by number of rentals 
-- (#1 should have 30 rentals and #5 should have 28 rentals)

-- 19. The top 10 actors ranked by number of rentals of films starring that actor 
-- (#1 should be “GINA DEGENERES” with 753 rentals and #10 should be “SEAN GUINESS” with 599 rentals)

-- 20. The top 5 “Comedy” actors ranked by number of rentals of films in the “Comedy” category starring that actor 
-- (#1 should have 87 rentals and #5 should have 72 rentals)
