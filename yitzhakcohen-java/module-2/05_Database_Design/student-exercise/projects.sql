DROP TABLE IF EXISTS employee --Cascade;
DROP TABLE IF EXISTS department --Cascade;
DROP TABLE IF EXISTS employees_in_department --CASCADE;
DROP TABLE IF EXISTS project --Cascade;
DROP TABLE IF EXISTS employees_assigned_to_project --Cascade;

CREATE TABLE employee(
        employee_id serial NOT NULL,
        job_title varchar(65) NOT NULL,
        last_name varchar(65) NOT NULL,
        first_name varchar(65) NOT NULL,
        gender varchar(15) NOT NULL,
        date_of_birth varchar(20) NOT NULL,
        date_of_hire varchar(20) NOT NULL,
        department_of_employee varchar(65) NOT NULL,
        CONSTRAINT pk_employee_employee_id PRIMARY KEY (employee_id)
); 

CREATE TABLE department(
        department_number serial NOT NULL,
        name varchar(65) NOT NULL,
        CONSTRAINT pk_department_department_number PRIMARY KEY(department_number)
); 

CREATE TABLE employees_in_department(
        department_number integer NOT NULL,
        employee_id integer NOT NULL,
        CONSTRAINT pk_employees_in_department PRIMARY KEY (department_number, employee_id)
);

CREATE TABLE project(
        project_number serial NOT NULL,
        name varchar(255) NOT NULL,
        start_date varchar(15) NOT NULL,
        CONSTRAINT pk_project_project_number PRIMARY KEY (project_number)
);

CREATE TABLE employees_assigned_to_project(
        project_number integer NOT NULL,
        employee_id integer NOT NULL,
        CONSTRAINT pk_employees_assigned_to_project PRIMARY KEY (project_number, employee_id)
);


INSERT INTO employee(job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_of_employee)
               VALUES('Head of Marketing', 'West', 'Aahron', 'Male', '01/01/1989', '11/12/2015', 'Marketing Department');
INSERT INTO employee(job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_of_employee)
               VALUES('Head of Finance', 'Smith', 'Barbra', 'Female', '03/05/1989', '12/11/2015', 'Finance Department');               
INSERT INTO employee(job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_of_employee)
               VALUES('Head of Human Resources', 'Cooper', 'Caleb', 'Male', '04/10/1990', '01/15/2016', 'Human Resources Department');
INSERT INTO employee(job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_of_employee)
               VALUES('Marketing Coordinator', 'Jagger', 'Farnell', 'Male', '06/14/1991', '02/20/2020', 'Marketing Department');
INSERT INTO employee(job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_of_employee)
               VALUES('Marketing Analyst', 'Ellis', 'Hailey', 'Female', '08/12/1992', '04/15/2017', 'Marketing Department'); 
INSERT INTO employee(job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_of_employee)
               VALUES('Financial Analyst', 'Lincoln', 'Igor', 'Male', '12/12/1988', '03/30/2017', 'Finance Department'); 
INSERT INTO employee(job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_of_employee)
               VALUES('Auditor', 'Finley', 'Lakista', 'Female', '12/27/1992', '05/29/2018', 'Finance Department'); 
INSERT INTO employee(job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_of_employee)
               VALUES('Recruiter', 'McKenzie', 'Yannis', 'Female', '05/07/1993', '06/11/2018', 'Human Resources Department');  

INSERT INTO department(name)
                VALUES('Marketing Department');
INSERT INTO department(name)
                VALUES('Finance Department');
INSERT INTO department(name)
                VALUES('Human Resources Department');

INSERT INTO employees_in_department(department_number, employee_id)
                VALUES(1, 1);   
INSERT INTO employees_in_department(department_number, employee_id)
                VALUES(1, 4);  
INSERT INTO employees_in_department(department_number, employee_id)
                VALUES(1, 5);                                
INSERT INTO employees_in_department(department_number, employee_id)
                VALUES(2, 2);   
INSERT INTO employees_in_department(department_number, employee_id)
                VALUES(2, 6); 
INSERT INTO employees_in_department(department_number, employee_id)
                VALUES(2, 7);                                   
INSERT INTO employees_in_department(department_number, employee_id)
                VALUES(3, 3); 
INSERT INTO employees_in_department(department_number, employee_id)
                VALUES(3, 8);                       
                  
INSERT INTO employees_assigned_to_project(project_number, employee_id)
                                   VALUES(1, 5);                 
INSERT INTO employees_assigned_to_project(project_number, employee_id)
                                   VALUES(1, 4); 
INSERT INTO employees_assigned_to_project(project_number, employee_id)
                                   VALUES(1, 6);                                                          
INSERT INTO employees_assigned_to_project(project_number, employee_id)
                                   VALUES(2, 2);   
INSERT INTO employees_assigned_to_project(project_number, employee_id)
                                   VALUES(2, 6);   
INSERT INTO employees_assigned_to_project(project_number, employee_id)
                                   VALUES(3, 3);                                      
INSERT INTO employees_assigned_to_project(project_number, employee_id)
                                   VALUES(3, 8);   
INSERT INTO employees_assigned_to_project(project_number, employee_id)
                                   VALUES(3, 1);                                      
INSERT INTO employees_assigned_to_project(project_number, employee_id)
                                   VALUES(4, 2);   
INSERT INTO employees_assigned_to_project(project_number, employee_id)
                                   VALUES(4, 7);   

INSERT INTO project(name, start_date)
             VALUES('New Marketing Project', '01/01/2020');
INSERT INTO project(name, start_date)
             VALUES('Financial Projections Project', '12/15/2019');
INSERT INTO project(name, start_date)
             VALUES('Recruitment Marketing Project', '12/01/2019');
INSERT INTO project(name, start_date)
             VALUES('Tax Compliance Project', '11/01/2019');  
              
             
             
                                                 


ALTER TABLE employees_in_department
ADD FOREIGN KEY (department_number)
REFERENCES department(department_number);

ALTER TABLE employees_in_department
ADD FOREIGN KEY(employee_id)
REFERENCES employee(employee_id);

ALTER TABLE employees_assigned_to_project
ADD FOREIGN KEY (project_number)
REFERENCES project(project_number);

ALTER TABLE employees_assigned_to_project
ADD FOREIGN KEY(employee_id)
REFERENCES employee(employee_id);


          
--ROLLBACK;           