---------------------------------------------------------------------------------------------------------------------------------------
-- Referential Integrity - Enforcement of the Parent-Dependent relatiohnship
--                         ie. Ensure that every foreign key value has a matching primary key
--
-- Constraints are rules regarding the data that must be complied with:
--
--  NOT NULL - Column must have a value
--
--  UNIQUE   - Column value must be unique with the table 
--
--  PRIMARY KEY - Column is part of the unique identifier for a row in the table
--                UNIQUE and NOT NULL are implied
--
--  FOREIGN KEY - Column is part of a foreign key for the table.  
--                Value must have a matching value in the primary key of the parent table
--                Establishes the parent-dependent relationship
--
--  CHECK  -  Specifies acceptable values for a column - any simple WHERE predicate is allowed
--
--  DEFAULT - Specify a default value for column if no value is supplied on INSER
---------------------------------------------------------------------------------------------------------------------------------------
-- Unit Of Work (UOW) - A recoverable sequence of operations within an application process
-- 
-- BEGIN TRANSACTION - Mark the start of a unit of work
-- 
-- COMMIT - End a unit of work and save changes - automatically done if no errors
-- 
-- ROLLBACK - End a unit of work and undo changes - automatically done if errors
---------------------------------------------------------------------------------------------------------------------------------------
--  INSERT - add a row to a table
--
--  Format 1: INSERT INTO table-name 
--            (column-list)           -- must contain all non-null non-Default columns
--            VALUES(value-list)      -- order of values must match order of columns specified
--
--
--  Format 2: INSERT INTO table-name 
--            VALUES(value-list)      -- order of values must match order of columns as defined in the table
--
--
--  Format 3: INSERT INTO table-name 
--            (SELECT statement)      -- order of columns in the SELECT must match the order of columns as defined in the table
--                                    -- () are optional
--                                            
---------------------------------------------------------------------------------------------------------------------------------------
--  UPDATE - change data in a table
--
--  UPDATE table-name
--  SET column = new-value
--  WHERE condition            -- scope of update - DANGER!!!!! - if omitted, all rows are updated                                         
---------------------------------------------------------------------------------------------------------------------------------------
--  DELETE - Remove rows from a table
--
--  DELETE FROM table-name
--  WHERE condition            -- scope of delete - DANGER!!!!! - if omitted, all rows are deleted                                        
---------------------------------------------------------------------------------------------------------------------------------------
-- INSERT

-- 1. Add Klingon as a spoken language in the USA 
--          add a row to countrylanguage table

Begin Transaction;      -- Start of unit-of-work

insert into countrylanguage                                -- table to insert into
(countrycode, language, isofficial, percentage)            -- columns in the table
values('USA', 'Klingon', true, 80) ;                       -- value list must be in the same order as the column list

-- Verify the change was done correctly with a select

Select *
  from countrylanguage 
  where countrycode = 'USA' and language = 'Klingon';
Rollback;               -- End the unit of work with a Rollback until I am sure they area correct     

-----------------------------------------------------------

Begin Transaction;      -- Start of unit-of-work

insert into countrylanguage                                -- table to insert into
         
values('USA', 'Klingon', true, 80) ;                       -- value list must be in the same order as the columns defined in the table

-- Verify the change was done correctly with a select

Select *
  from countrylanguage 
  where countrycode = 'USA' and language = 'Klingon';                                                     --??????
Rollback;  

-- commit       --de-comment and cmment out the rollback when you want the cange to be permanent


-- 2. Add Klingon as a spoken language in Great Britain
Begin Transaction;      -- Start of unit-of-work

insert into countrylanguage                                -- table to insert into
(countrycode, language, isofficial, percentage)            -- columns in the table
values((select code from country where name = 'United Kingdom')
, 'Klingon', true, 80) ;                       -- value list must be in the same order as the column list



Select *
  from countrylanguage 
  where countrycode in (select code from coutry where name = 'United Kingdom') and language = 'Klingon';
rollback;
-- UPDATE

-- 1. Update the capital of the USA to Houston

BEGIN transaction;

update country
   set capital = (select id from city where name = 'Houston')   -- get the city from city
   where code = 'USA';
   
select capital, code 
  from country 
  where code = 'USA';
  
select id, name 
  from city 
  where name = 'Houston';     
   
commit;   
--rollback;   
   

-- 2. Update the capital of the USA to Washington DC and the head of state

BEGIN transaction;

update country
   set capital = (select id from city where name = 'Washington')   -- get the city from city
   , headofstate = 'Spongebob'
   where code = 'USA';
   
select capital, code, headofstate
  from country 
  where code = 'USA';
  
select id, name 
  from city 
  where name = 'Washington';     
   
commit;   
--rollback; 

-- DELETE

-- 1. Delete English as a spoken language in the USA

Begin transaction;

delete from countrylanguage
where countrycode = 'USA'
and language = 'English';

select * from countrylanguage where countrycode = 'USA';

rollback;

-- 2. Delete all occurrences of the Klingon language

Begin transaction;

delete from countrylanguage
where countrycode = 'USA'
and language = 'Klingon';

select * from countrylanguage where countrycode = 'Klingon';

rollback;
 


-- REFERENTIAL INTEGRITY

-- INSERT into a child/dependant is not allowed if there is no matching parent
--              Parent rows must be inserted or exist before dpendent rows
--
-- UPDATE - Cannot change the primary key of a parent if it has dependents 
--          Cannot change a depndent foreign key to a non-existent parent
--
-- DELETE - Cannot delete a parent row if it has dependents 
--                must delete all dependent rows before parent rows
--
-- 
-- a Cascade option can be place on the primary key constraint which says 
--      if changeis made to the primary key automatically cascade change to 
--              foreign keys in dependent 
--      UPDATE of primary will update all foreign keys if CASCADE in effect
--      DELETE of a parent will delete all dependet rows if CASCADE in effect
--
--
-- 1. Try just adding Elvish to the country language table.

-- 2. Try inserting English as a spoken language in the country ZZZ. What happens?

-- 3. Try deleting the country USA. What happens?

Begin transaction;

delete from country where code = 'USA';         -- Fails due to USA having enteries in City

Rollback;


-- CONSTRAINTS

-- 1. Try inserting English as a spoken language in the USA

-- 2. Try again. What happens?

-- 3. Let's relocate the USA to the continent - 'Outer Space'


-- How to view all of the constraints
-- Pull data from postgres system tables related to constraints 

SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS
SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE
SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS


-- TRANSACTIONS

-- 1. Try deleting all of the rows from the country language table and roll it back.

-- 2. Try updating all of the cities to be in the USA and roll it back
