---------------------------------------------------------------------------------------------------------------------------------------
-- Referential Integrity - Enforcement of the Parent-Dependent relationship
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
--  DEFAULT - Specify a default value for column if no value is supplied on INSERT
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
--            (column-list)           -- must contain all non-null and non-DEFAULT columns
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
--  WHERE condition            -- scope of update - DANGER!!!! - if omitted, all rows are updated                                         
---------------------------------------------------------------------------------------------------------------------------------------
--  DELETE - Remove rows from a table
--
--  DELETE FROM table-name
--  WHERE condition            -- scope of delete - DANGER!!!! - if omitted, all rows are deleted                                        
---------------------------------------------------------------------------------------------------------------------------------------
-- INSERT

-- 1. Add Klingon as a spoken language in the USA 
--   add a row to countrylanguage

Begin Transaction;  -- Start of a Unit-of-work

-- Perform the change operation

insert into countrylanguage                             -- table to insert into
      (countrycode, language,  percentage, isofficial)  -- columns in the table
values('USA'      , 'Klingon', 80        , true)        -- value list must be in the same order as the column list
;  

-- Verify the change was done correctly with a SELECT ot the data you changed

Select *
  from countrylanguage
 where countrycode = 'USA' and language = 'Klingon'
;

-- Undo the change until you have verified it was done correctly
--Rollback;           -- End the Unit of Work with a Rollback until I am sure they are correct

Commit;          -- de-comment and comment out the rollback when you want the chaneg to be permanent

-- 2. Add Klingon as a spoken language in Great Britain

Begin Transaction;  -- Start of a Unit-of-work

insert into countrylanguage                             -- table to insert into
      (countrycode, language,  percentage, isofficial)  -- columns in the table
values((select code from country where name = 'United Kingdom')
      , 'Klingon'
      , 80        
      , true)        -- value list must be in the same order as the column list
;  

Select *
  from countrylanguage
 where countrycode in (select code from country where name = 'United Kingdom')
  and language = 'Klingon'
;

-- Undo the change until you have verified it was done correctly
Rollback;   

-- UPDATE

-- 1. Update the capital of the USA to Houston

Begin transaction;

update country
   set capital = (select id from city where name = 'Houston')  -- get the city from city table
 where code = 'USA'
 ;
 
 select capital, code
   from country
  where code = 'USA';
 ;
 select id, name
   from city
  where name = 'Houston'
 ;
 
commit;

-- 2. Update the capital of the USA to Washington DC and the head of state
Begin transaction;

update country
   set capital = (select id from city where name = 'Washington')  -- get the city from city table
      ,headofstate = 'Spongebob' 
 where code = 'USA'
 ;
 
 select capital, code, headofstate
   from country
  where code = 'USA';
 ;
 select id, name
   from city
  where name = 'Washington'
 ;
 
commit;

-- DELETE

-- 1. Delete English as a spoken language in the USA
begin transaction;

delete from countrylanguage
where countrycode = 'USA'
  and language = 'English'
;

select * from countrylanguage where countrycode = 'USA';

rollback;

-- 2. Delete all occurrences of the Klingon language 
begin transaction;

delete from countrylanguage
 where language = 'Klingon'
;

select * from countrylanguage where countrycode = 'Klingon';

rollback;

-- REFERENTIAL INTEGRITY

-- INSERT into a child/dependent is not allowed if not matching parent
--        Parent rows must be inserted or exist before dependent rows
--
-- UPDATE - Cannot change the primary key of a parent if it has dependents
--          Cannot change a dependent foreign key to a non-existent parent
--
-- DELETE - Cannot delete a parent row if it has dependents
--                 must delete all dependent rows before parent row
--
--
--  a CASCADE option and be placed on the primary key constraint which says
--    if change is made to teh primary key automatically cascade change to 
--       foreign keys in dependent
--
--    UPDATE of primary will update all foreign keys if CASCADE in effect
--    DELETE of a parent will delete all dependent rows if CASCADE in effect
--
--
-- 1. Try just adding Elvish to the country language table.

-- 2. Try inserting English as a spoken language in the country ZZZ. What happens?

-- 3. Try deleting the country USA. What happens?
begin transaction;

delete from country where code = 'USA';  -- Fails due to USA having entries in City

Rollback;
-- CONSTRAINTS

-- 1. Try inserting English as a spoken language in the USA

-- 2. Try again. What happens?

-- 3. Let's relocate the USA to the continent - 'Outer Space'


-- How to view all of the constraints
-- Pull data from postgres system tables related to contraints

SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS
SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE
SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS


-- TRANSACTIONS

-- 1. Try deleting all of the rows from the country language table and roll it back.

-- 2. Try updating all of the cities to be in the USA and roll it back
