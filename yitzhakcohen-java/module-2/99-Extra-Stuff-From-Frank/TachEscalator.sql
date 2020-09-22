Begin transaction;  -- start of the Unit of Work

drop table if exists Courses     cascade;  -- delete any existing tables and their dependents from the databases
drop table if exists Locations   cascade;  -- if cascade is omitted - dependents must be dropped befor parents
drop table if exists Instructors cascade;
drop table if exists Cohorts     cascade;
drop table if exists Students    cascade;

drop sequence if exists seq_course_id;     -- delete sequence objects created in this SQL script
drop sequence if exists seq_student_id;


create sequence seq_course_id;  -- provide unique sequential values - nextval() will return teh next value
create sequence seq_student_id;

create table Courses (
 CourseID     integer      not null    default nextval('seq_course_id')  -- if CourseId not supplied on INSERT use sequence object to get course id
,Course_name  varchar(20)  not null
,Duration     integer      not null    default 14
,constraint pk_courses_courseID primary key (CourseID)  -- This table may be used a parent for referential integrity
)
;
create table Locations (
 LocationId    char(8)      not null
,City          varchar(21)  not null   -- longest U.S. city name has 21 characters
,State         char(2)      not null
,DateOpened    date         
,constraint pk_locations_locationId primary key (LocationID)
)
;

create table Instructors (
 instructorId         char(6)      not null
,firstName            varchar(20)  not null 
,middleName           varchar(20)
,lastName             varchar(20)  not null
,HomeLocation         char(8)      not null
,constraint pk_instructors_instructorId primary key (instructorId) 
);

create table Cohorts (
 cohortNumber      integer  not null
,courseId          integer  not null
,locationId        char(8)  not null
,instructorId      char(6)  
,maxStudents       smallint not null default 18
,currentEnrollment smallint not null default 0
,numGraduated      smallint not null default 0
,startDate         date
,graduationDate    date
,notes             text
,constraint pk_cohorts_cohortNumber_courseIdLocationId primary key (cohortNumber, courseId, locationId)
);
 
create table Students (
 studentID           integer not null default nextval('seq_student_id')
,cohortNumber        integer
,courseId            integer
,locationId          char(8)
,status              char(1) not null
,firstName           varchar(20)  not null 
,middleName          varchar(20)
,lastName            varchar(20)  not null  
,streetAddress       varchar(50)
,City                varchar(21)  not null   -- longest U.S. city name has 21 characters
,State               char(2)      not null  
,zipCode             char(10)
,email               varchar(320)            -- max size for an e-mail address - 06/2019
,twitterID           varchar(15)             -- max size for a twitter id - 06/2019
,preferredProNoun    varchar(20)
,whenAdded           timestamp with time zone default current_timestamp
,lastUpdated         timestamp with time zone default current_timestamp
,notes               text
,constraint pk_students_studentId primary key(studentID)  
,constraint ck_status CHECK (status IN ('A', 'E', 'I', 'R', 'G', 'W', 'K'))
-- status codes: A - Applied
--               E - Enrolled
--               I - Interviewed
--               R - Rejected
--               G - Graduated
--               W - Withdrawn-Personal
--               K - Withdrawn-Academic
);
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('IVORY', 'FRIEL', '7869 Carol Dr', 'Webster', 'IN', '47393', ' VEGAS',  13,'W');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('CARMINE', 'DITTMAR', '99863 Davinwood Dr', 'Hormigueros', 'PR', '660', ' VEGAS',  6,'E');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('LYNETTE', 'BELLER', '8675 Lawther Dr', 'Mount Nebo', 'WV', '26679', ' JAZZ',  13,'W');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('LENORE', 'WENGER', '28349 Laurel St', 'Wilmington', 'VT', '5363', ' OZ',  1,'R');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('ISIDRO', 'DERR', '986 Kinfield Trl', 'Ellicott City', 'MD', '21042', ' OZ',  1,'I');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('NED', 'LALLY', '38089 13Th Ln', 'Randolph', 'MS', '38864', ' OZ',  6,'A');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('FANNIE', 'SHOUP', '86111 Canberra Pl', 'Monterey Park', 'CA', '91755', ' OZ',  1,'I');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('HIPOLITO', 'SILLER', '92564 Natchez Trl', 'Tennessee Ridge', 'TN', '37061', ' MICKEY',  6,'E');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('IMOGENE', 'WESTRA', '34703 Pampas Ct', 'Red Head', 'FL', '32462', ' VEGAS',  5,'I');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('KIM', 'BALCH', '83477 Ardmore Rd', 'Sherwood', 'IA', '50579', ' PHX',  3,'E');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('COREY', 'FRAKES', '53967 Oakbrook Blvd', 'Gambrills', 'MD', '21144', ' OZ',  13,'W');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('MARIO', 'VEITH', '86651 14Th St', 'Waikoloa Village', 'HI', '96738', ' APPLE',  1,'W');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('KENNY', 'EMERY', '93531 Navigation Ct', 'Long Beach', 'MN', '56334', ' CLE',  1,'A');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('MANUELA', 'FRAILEY', '8660 Groveview Ct', 'Winchester', 'CA', '92545', ' LAX',  5,'E');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('ELIZABETH', 'HYSLOP', '61457 Lawndale Dr', 'Harcuvar', 'AZ', '85348', ' LAX',  6,'K');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('CHARLEY', 'LEAR', '31283 Clairmont Grove Ct', 'Muldoon', 'TX', '78949', ' CLE',  5,'A');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('BRUCE', 'BALAS', '52063 Olde Stonegate Ln', 'Great Cacapon', 'WV', '25422', ' OZ',  3,'K');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('MISTY', 'HIRD', '2181 Race St', 'Norway', 'MI', '49870', ' JAZZ',  6,'E');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('NANCY', 'BEDGOOD', '66483 Agnes Ct', 'Shelby', 'IN', '46377', ' VEGAS',  1,'E');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('REBA', 'LOVEDAY', '67985 Belfiore Rd', 'Efland', 'NC', '27243', ' VEGAS',  3,'K');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('SYDNEY', 'MILSTEAD', '31173 Ottawa Rd', 'Sheldon', 'WI', '54766', ' JAZZ',  13,'E');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('IKE', 'JOWERS', '67629 Adriatic Dr', 'Big Bend', 'LA', '71355', ' LAX',  5,'I');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('OPHELIA', 'CASADY', '75252 Hawk Ridge Trl', 'Dockton', 'WA', '98070', ' JAZZ',  13,'W');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('ADAN', 'DONAGHY', '69352 Nettlewood Ln', 'Grovont', 'WY', '83012', ' JAZZ',  1,'I');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('QUINTON', 'FENG', '51356 Forest Ave', 'Kechi', 'KS', '67067', ' COWTOWN',  3,'W');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('NICOLE', 'NUTTALL', '98851 Quail Roost', 'Cowgill', 'MO', '64637', ' MICKEY',  3,'A');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('SUSANA', 'DINAN', '43773 Gazelle St', 'New Castle', 'KY', '40058', ' JAZZ',  6,'W');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('LYNNETTE', 'RENWICK', '67060 Laclede Rd', 'Wynnedale', 'IN', '46228', ' PHX',  6,'K');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('OFELIA', 'TOLAN', '63187 Birchwood Dr', 'Derby', 'CO', '80024', ' VEGAS',  1,'R');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('RENEE', 'HANES', '68982 Leboeuf St', 'Grantsville', 'MD', '21536', ' CLE',  3,'R');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('QUENTIN', 'WINFREE', '23203 Juniper Ave', 'Davis', 'OK', '73030', ' APPLE',  13,'I');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('MONTE', 'ENNIS', '26491 Miami Way', 'Elmwood Place', 'OH', '45216', ' VEGAS',  6,'E');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('SAMUAL', 'CASTILLEJA', '97464 Polymnia St', 'Enka', 'NC', '28715', ' COWTOWN',  6,'I');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('CHI', 'SUNDBERG', '94832 Karl Dr', 'Bay Shore', 'NY', '11706', ' LAX',  3,'K');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('DARREL', 'PREVATTE', '69760 Arcadia Ave', 'Seabrook', 'MA', '2649', ' VEGAS',  13,'R');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('LAURIE', 'MCCLAIN', '59910 Fawn Crossing Ct', 'Anthony', 'WV', '24938', ' APPLE',  6,'R');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('DEWEY', 'SPATARO', '99017 Edenton Rd', 'Chicopee', 'KS', '66762', ' JAZZ',  6,'A');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('JEWEL', 'HIDALGO', '95181 Princeton Pl', 'Paragon Estates', 'CO', '80303', ' OZ',  3,'I');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('EDWARDO', 'POPP', '17283 Kinston Ridge Pl', 'Walloon Lake', 'MI', '49796', ' OZ',  13,'A');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('NICKOLAS', 'MONICO', '32631 Gifford St', 'Taylorsville', 'MS', '39168', ' APPLE',  6,'K');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('STEVEN', 'OPPERMAN', '22125 Grand Union Way', 'Jud', 'ND', '58454', ' APPLE',  13,'W');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('MERVIN', 'TOLAND', '47217 Method St', 'Port Alsworth', 'AK', '99653', ' LAX',  3,'I');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('KEENAN', 'EVERETTE', '88305 Continental Ave', 'Delaware', 'AR', '72835', ' JAZZ',  13,'W');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('SHELBY', 'KUCERA', '51589 Half Halt Ave', 'Lely Resort', 'FL', '34113', ' APPLE',  13,'K');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('VICENTE', 'MANNS', '69644 Penrith Rd', 'Farrar', 'TX', '75838', ' PHX',  5,'I');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('NORA', 'WHITELEY', '23639 Mill Point Cir', 'Tracy', 'MO', '64079', ' JAZZ',  6,'W');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('FLOYD', 'LESLEY', '9887 Cassio Ct', 'Backus Beach', 'MI', '48762', ' LAX',  6,'K');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('JOHNATHAN', 'TRAYLOR', '47526 Alan Pkwy', 'Separ', 'NM', '88045', ' CLE',  5,'E');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('LATOYA', 'FRAHM', '79190 Normancrest Ct', 'Buellton', 'CA', '93427', ' LAX',  5,'E');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('ALPHONSE', 'PATCH', '48710 Aberdale Way', 'Ravenna', 'MI', '49451', ' PHX',  1,'K');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('JUDSON', 'BOTSFORD', '48278 Nutcracker Pl', 'Reedsport', 'OR', '97467', ' JAZZ',  13,'A');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('SOL', 'ARNONE', '27320 Old Egbert Rd', 'Massillon', 'IA', '52255', ' OZ',  1,'A');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('JASON', 'LEDOUX', '80923 Davis Rd', 'Hamburg', 'PA', '19526', ' LAX',  5,'R');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('ALEX', 'WOOLSEY', '20990 Jonquil Pl', 'Yuba', 'WI', '54634', ' CLE',  1,'I');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('PARIS', 'SAYLOR', '31019 Pat Dr', 'Buhl', 'ID', '83316', ' OZ',  3,'R');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('LAKEISHA', 'AHRENS', '88278 57Th Ave', 'Jonestown', 'MS', '38639', ' CLE',  3,'E');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('REYNALDO', 'SHRYOCK', '5579 122Nd St', 'Padonia', 'KS', '66434', ' CLE',  3,'R');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('MIRIAM', 'BOLYARD', '43856 Folly Gate Ct', 'Gold Beach', 'OR', '97444', ' CLE',  6,'R');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('YOLANDA', 'MADDIX', '48867 Hollygrove St', 'Sebewaing', 'MI', '48759', ' MICKEY',  6,'K');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('KRISTIE', 'POLIZZI', '51493 Hickory Trace Dr', 'East White Plains', 'NY', '10604', ' COWTOWN',  3,'A');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('CARLOS', 'SYMONS', '31952 130Th Pl', 'Eatonville', 'FL', '32751', ' JAZZ',  13,'A');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('CHASE', 'RAMAGE', '13746 Peggy Ln', 'New London', 'WA', '98550', ' JAZZ',  5,'A');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('ALANA', 'WELCH', '38441 General Industrial Dr', 'Duck Hill', 'MS', '38925', ' APPLE',  5,'E');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('GILDA', 'BLATT', '42761 Bannock Ave', 'Symco', 'WI', '54949', ' APPLE',  13,'I');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('WARREN', 'NYGAARD', '4627 Cressa Ct', 'Yaurel Comunidad', 'PR', '714', ' APPLE',  5,'E');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('DAVE', 'HANSEN', '70010 Dumane St', 'Elsie', 'OR', '97138', ' VEGAS',  5,'I');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('ARNOLD', 'SALA', '36526 Gates Mills Blvd', 'Taunton', 'MA', '02780', ' VEGAS',  13,'K');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('BRENTON', 'ENGLES', '9918 Macedonia Rd', 'Prospectville', 'PA', '19002', ' CLE',  13,'R');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('BERNIE', 'PARADISO', '795 Artists Way', 'Goodenow', 'IL', '60401', ' LAX',  1,'R');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('ALEJANDRO', 'TRAPP', '80568 Kathleen Rd', 'Boxelder', 'WY', '82637', ' MICKEY',  1,'W');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('GINGER', 'MUSGRAVE', '914 Candlehill Dr', 'Eureka Mill', 'SC', '29706', ' CLE',  1,'R');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('MURRAY', 'CALDERA', '1493 Kingsbury Blvd', 'Bolinas', 'CA', '94924', ' VEGAS',  1,'R');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('KATIE', 'MICKELSON', '70653 Army Ave', 'Volo', 'IL', '60020', ' JAZZ',  6,'A');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('DEL', 'TURBEVILLE', '32146 Patio Ln', 'Schulte', 'KS', '67215', ' APPLE',  13,'R');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('WILLARD', 'MOREHOUSE', '25929 Lampkin Way', 'Selma', 'IA', '52551', ' MICKEY',  3,'E');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('LYMAN', 'HELT', '14063 Mason Andrew Way', 'Geneva', 'ID', '83238', ' PHX',  3,'A');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('MALCOM', 'REGER', '28533 Livingstone Way', 'Sloat', 'CA', '96103', ' LAX',  1,'E');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('VICENTE', 'MCCLUSKEY', '83090 Forest Point Blvd', 'Hubbell', 'NE', '68375', ' APPLE',  5,'A');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('COLEMAN', 'ARSENAULT', '20067 Airport Blvd', 'Broaddus', 'TX', '75929', ' CLE',  5,'A');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('SHELDON', 'DEVER', '39508 Aurora Dr', 'Dufur', 'OR', '97021', ' APPLE',  13,'E');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('OFELIA', 'HIGUCHI', '35140 Rainbow Way', 'Greensburg', 'OH', '44720', ' OZ',  3,'W');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('KASEY', 'BOBBY', '72143 Battle Point Dr', 'Aloe', 'TX', '77905', ' COWTOWN',  5,'A');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('PATRICE', 'HUGHLEY', '50095 Alder St', 'Danville', 'KY', '40422', ' VEGAS',  13,'I');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('ARLEN', 'LECHNER', '52643 Graham Trl', 'Spring Valley', 'KY', '40241', ' MICKEY',  1,'W');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('LESLEY', 'FERRY', '61419 Echo Canyon Dr', 'Verona', 'PA', '15147', ' COWTOWN',  3,'K');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('HAZEL', 'ARCHIE', '71947 Arbor Cir', 'Radcliff', 'KY', '40160', ' COWTOWN',  3,'A');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('ROSANNE', 'ANWAR', '94904 Kennel Ln', 'Lompoc', 'CA', '93436', ' JAZZ',  5,'K');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('DANNIE', 'BOUDREAU', '41350 Basil Ct', 'Nicholson', 'MS', '39466', ' JAZZ',  5,'W');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('DENVER', 'FIX', '65141 Castleton Rd', 'Senoia', 'GA', '30276', ' PHX',  1,'W');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('ISMAEL', 'ISABELLE', '54951 Eastman Ct', 'Waelder', 'TX', '78959', ' COWTOWN',  5,'W');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('ELLSWORTH', 'HUYNH', '35162 Globe Ave', 'Pisgah', 'MD', '20640', ' MICKEY',  13,'E');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('JULIO', 'BURGOON', '89466 Panorama Ave', 'Neylandville', 'TX', '75401', ' CLE',  6,'K');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('BEVERLEY', 'ROTHSCHILD', '79460 Cady Rd', 'East Danville', 'OH', '45133', ' PHX',  6,'A');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('REGGIE', 'DANNER', '74362 Mulberry Dr', 'Nipinnawasee', 'CA', '93601', ' APPLE',  6,'A');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('ELEANOR', 'TOLIVER', '75694 Kirkwood St', 'Sula', 'MT', '59871', ' APPLE',  6,'I');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('JACLYN', 'KUNKLE', '87550 Hana Maui Dr', 'Ickesburg', 'PA', '17037', ' PHX',  13,'I');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('KATE', 'BEERMAN', '95525 Oakleaf Dr', 'Lyons', 'IN', '47443', ' PHX',  3,'A');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('MICHEL', 'LEAVITT', '4473 Folk Ave', 'Elkader', 'IA', '52043', ' MICKEY',  6,'I');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('MEREDITH', 'BHATT', '63825 Morse Ct', 'Wannee', 'FL', '32619', ' APPLE',  13,'W');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('KENYA', 'SEVERS', '26451 Arrowwood Ln', 'Katherine', 'AZ', '86429', ' LAX',  1,'E');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('EVANGELINA', 'PRESS', '6172 Parkhurst Ln', 'Lida', 'NV', '89013', ' APPLE',  6,'E');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('SILAS', 'BORMANN', '95605 Halstead Ln', 'Olga', 'ND', '58249', ' OZ',  3,'I');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('MARSHA', 'LUTON', '58090 Bacardi Dr', 'Sun River Terrace', 'IL', '60964', ' LAX',  3,'W');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('CARMELA', 'JENNINGS', '70990 Harrison Steel Dr', 'Liberty', 'IN', '47353', ' MICKEY',  5,'K');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('RUDY', 'MOELLER', '59308 Providence Retreat Ln', 'Keyport', 'NJ', '7735', ' COWTOWN',  5,'I');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('MARCELINO', 'STOKES', '54742 Cliff Cir', 'Guthrie Center', 'IA', '50115', ' APPLE',  3,'W');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('SIDNEY', 'BRIESE', '36064 29Th Way', 'Joy', 'IL', '61260', ' OZ',  3,'R');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('ELVIRA', 'LOCKLEAR', '9853 Blackberry Ridge Ln', 'Camp Dennison', 'OH', '45111', ' VEGAS',  13,'R');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('RALPH', 'DUNFEE', '75039 Covert Ave', 'Calumet', 'IA', '51009', ' MICKEY',  3,'I');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('BENITA', 'JAROSZ', '98311 264Th Pl', 'Sheffield', 'IA', '50475', ' LAX',  13,'E');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('BRADLEY', 'LORUSSO', '50013 Bushmills Rd', 'Medinah', 'IL', '60157', ' COWTOWN',  1,'E');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('ANNIE', 'BEDOYA', '60281 Queenswater Ln', 'Palestine', 'IL', '62451', ' MICKEY',  3,'A');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('KENETH', 'VEASLEY', '278 Boedeker Dr', 'Pecktonville', 'MD', '21711', ' VEGAS',  3,'A');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('SHELTON', 'TOUCHSTONE', '78293 Armitage Ct', 'Whitney Point', 'NY', '13862', ' MICKEY',  13,'W');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('SOCORRO', 'COAN', '72105 Granville Rd', 'Oaklyn', 'NJ', '8107', ' CLE',  5,'I');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('MILTON', 'DEGUZMAN', '20470 Degas Ln', 'Rockcreek', 'OR', '97229', ' LAX',  3,'K');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('HALLIE', 'IKARD', '62570 Cedar Rock Dr', 'Belltown', 'CA', '92509', ' JAZZ',  6,'E');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('SAVANNAH', 'BRODBECK', '66346 Padua Dr', 'Athens', 'LA', '71003', ' MICKEY',  13,'R');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('ERICKA', 'BAUGH', '1270 Barclay Woods Ct', 'Bristol', 'IN', '46507', ' PHX',  3,'A');
Insert into Students
(firstname, lastname, streetaddress, city, state, zipcode, locationid, courseid, status)
Values('ELIJAH', 'NED', '3832 Aberdon Rd', 'Millport', 'NY', '14864', ' MICKEY',  6,'K');
Insert into cohorts
(cohortnumber, courseid, locationid, instructorid, StartDate, graduationDate)
values(12,  1, 'OZ       ', 'WyaEar', current_date, current_date + interval '70 days');
Insert into cohorts
(cohortnumber, courseid, locationid, instructorid, StartDate, graduationDate)
values(12,  1, 'MICKEY   ', 'WyaEar', current_date, current_date + interval '70 days');
Insert into cohorts
(cohortnumber, courseid, locationid, instructorid, StartDate, graduationDate)
values(13,  3, 'VEGAS    ', 'WyaEar', current_date, current_date + interval '70 days');
Insert into cohorts
(cohortnumber, courseid, locationid, instructorid, StartDate, graduationDate)
values(11,  1, 'PHX      ', 'FraFel', current_date, current_date + interval '70 days');
Insert into cohorts
(cohortnumber, courseid, locationid, instructorid, StartDate, graduationDate)
values(15,  3, 'OZ       ', 'LouArm', current_date, current_date + interval '70 days');
Insert into cohorts
(cohortnumber, courseid, locationid, instructorid, StartDate, graduationDate)
values(12,  3, 'OZ       ', 'Spock', current_date, current_date + interval '70 days');
Insert into cohorts
(cohortnumber, courseid, locationid, instructorid, StartDate, graduationDate)
values(13,  5, 'MICKEY   ', 'FreFli', current_date, current_date + interval '70 days');
Insert into cohorts
(cohortnumber, courseid, locationid, instructorid, StartDate, graduationDate)
values(11,  13, 'VEGAS    ', 'DonDuc', current_date, current_date + interval '70 days');
Insert into cohorts
(cohortnumber, courseid, locationid, instructorid, StartDate, graduationDate)
values(15,  1, 'PHX      ', 'Spock', current_date, current_date + interval '70 days');
Insert into cohorts
(cohortnumber, courseid, locationid, instructorid, StartDate, graduationDate)
values(14,  5, 'PHX      ', 'MayBak', current_date, current_date + interval '70 days');
Insert into cohorts
(cohortnumber, courseid, locationid, instructorid, StartDate, graduationDate)
values(13,  13, 'VEGAS    ', 'WyaEar', current_date, current_date + interval '70 days');
Insert into cohorts
(cohortnumber, courseid, locationid, instructorid, StartDate, graduationDate)
values(13,  1, 'APPLE    ', 'JeaPic', current_date, current_date + interval '70 days');
INSERT INTO instructors (instructorid, firstname, middlename, lastname, homelocation) VALUES ('MayBak', 'Mayfield', 'Dangerous', 'Baker', 'CLE     ');
INSERT INTO instructors (instructorid, firstname, middlename, lastname, homelocation) VALUES ('FreFli', 'Fred', null, 'Flintstone ', 'PHX     ');
INSERT INTO instructors (instructorid, firstname, middlename, lastname, homelocation) VALUES ('FraFel', 'Frank', 'J', 'Fella', 'CLE     ');
INSERT INTO instructors (instructorid, firstname, middlename, lastname, homelocation) VALUES ('WyaEar', 'Wyatt', null, 'Earp', 'PHX     ');
INSERT INTO instructors (instructorid, firstname, middlename, lastname, homelocation) VALUES ('LouArm', 'Louis', null, 'Armstrong', 'JAZZ    ');
INSERT INTO instructors (instructorid, firstname, middlename, lastname, homelocation) VALUES ('DonDuc', 'Donald', null, 'Duck', 'MICKEY  ');
INSERT INTO instructors (instructorid, firstname, middlename, lastname, homelocation) VALUES ('JeaPic', 'Jean', 'Luc', 'Picard', 'OZ      ');
INSERT INTO instructors (instructorid, firstname, middlename, lastname, homelocation) VALUES ('Spock ', 'Commander', null, 'Spock', 'APPLE   ');
INSERT INTO instructors (instructorid, firstname, middlename, lastname, homelocation) VALUES ('JamKir', 'James', 'T', 'Kirk', 'LAX     ');
INSERT INTO courses (courseid, course_name, duration) VALUES (3, 'Java-Corp', 8);
INSERT INTO courses (courseid, course_name, duration) VALUES (13, 'Python', 10);
INSERT INTO courses (courseid, course_name, duration) VALUES (1, 'Java', 14);
INSERT INTO courses (courseid, course_name, duration) VALUES (5, '.NET-Corp', 8);
INSERT INTO courses (courseid, course_name, duration) VALUES (6, '.NET', 14);
INSERT INTO locations (locationid, city, state, dateopened) VALUES ('PHX     ', 'Phoenix', 'AZ', '2017-08-31');
INSERT INTO locations (locationid, city, state, dateopened) VALUES ('CLE     ', 'Cleveland', 'OH', '2015-12-01');
INSERT INTO locations (locationid, city, state, dateopened) VALUES ('VEGAS   ', 'Las Vagas', 'NV', '2016-10-16');
INSERT INTO locations (locationid, city, state, dateopened) VALUES ('COWTOWN ', 'Ft. Worth', 'TX', '2019-01-12');
INSERT INTO locations (locationid, city, state, dateopened) VALUES ('LAX     ', 'Los Angeles', 'CA', null);
INSERT INTO locations (locationid, city, state, dateopened) VALUES ('APPLE   ', 'New York', 'NY', null);
INSERT INTO locations (locationid, city, state, dateopened) VALUES ('JAZZ    ', 'New Orleans', 'LA', '2016-03-19');
INSERT INTO locations (locationid, city, state, dateopened) VALUES ('OZ      ', 'Tornado', 'KS', '2019-02-27');
INSERT INTO locations (locationid, city, state, dateopened) VALUES ('MICKEY  ', 'ORLANDO', 'FL', '2018-01-13');
--
-- add foreign keys after tables are created initially loaded to avoid having to worry the order you create or load tables
--
alter table cohorts     add foreign key(courseId)     references Courses(courseId);
alter table cohorts     add foreign key(locationID)   references Locations(locationId);
alter table cohorts     add foreign key(instructorId) references Instructors(instructorId);
alter table Students    add foreign key(cohortNumber, courseID, locationID)   
                                                      references Cohorts(cohortNumber, courseId, locationID);
alter table Instructors add foreign key(homeLocation) references Locations(locationId);

commit;
