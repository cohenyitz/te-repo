Select title
     from film
     inner join
     film_actor
  on film.film_id = film_actor.film_id
     inner join
     actor 
  on actor.actor_id = film_actor.actor_id 
  where first_name = 'NICK'
  And   last_name = 'STALLONE';
  
  Select title
     from film
     inner join
     film_actor
  on film.film_id = film_actor.film_id
     inner join
     actor 
  on actor.actor_id = film_actor.actor_id 
  where actor.actor_id in(select actor_id
                                from actor 
                                where first_name = 'NICK'
                                And   last_name = 'STALLONE');