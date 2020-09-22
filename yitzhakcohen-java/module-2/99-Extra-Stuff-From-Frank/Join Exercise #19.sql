--
-- 19. The top 10 actors ranked by number of rentals of films starring that actor 
-- (#1 should be “GINA DEGENERES” with 753 rentals and #10 should be “SEAN GUINESS” with 599 rentals)

-- Student Query
SELECT a.first_name || ' ' || a.last_name as actor_name , COUNT(r.rental_ID)
FROM actor a
INNER JOIN film_actor f_a ON f_a.actor_id = a.actor_id
INNER JOIN film f         ON f.film_id = f_a.film_id
INNER JOIN inventory i    ON i.film_id = f.film_id
INNER JOIN rental r       ON r.inventory_id = i.inventory_id
GROUP BY actor_name
ORDER BY 2 DESC
LIMIT 10
;
-- Frank Query
SELECT actor.first_name, actor.last_name, COUNT(*) AS rental_count
FROM film 
inner JOIN inventory  ON film.film_id = inventory.film_id
inner JOIN rental     ON inventory.inventory_id = rental.inventory_id
inner JOIN film_actor ON film.film_id = film_actor.film_id
inner JOIN actor      ON film_actor.actor_id = actor.actor_id
GROUP BY actor.actor_id, actor.first_name, actor.last_name
ORDER BY rental_count DESC
LIMIT 10