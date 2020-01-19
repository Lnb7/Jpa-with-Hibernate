insert into course(id,name)values (1001,'JPA tutorial');
insert into course(id,name)values (1002,'Spring MVC tutorial');
insert into course(id,name)values (1003,'Spring Boot tutorial');


insert into passport(id,number) values(4001,'E123456');
insert into passport(id,number) values(4002,'N123456');
insert into passport(id,number) values(4003,'L123456');


insert into student(id,name,passport_id) values(2001,'LokiB',4001);
insert into student(id,name,passport_id) values(2002,'Ranga',4002);
insert into student(id,name,passport_id) values(2003,'Konda',4003);


insert into review(id,rating,description,course_id) values(5001,'5','Grate COurse',1001);
insert into review(id,rating,description,course_id) values(5002,'4','Wonderful COurse',1001);
insert into review(id,rating,description,course_id) values(5003,'5','Awesome COurse',1003);

insert into student_course(student_id,course_id) values(2001,1001);
insert into student_course(student_id,course_id) values(2002,1001);
insert into student_course(student_id,course_id) values(2003,1001);
insert into student_course(student_id,course_id) values(2001,1003);