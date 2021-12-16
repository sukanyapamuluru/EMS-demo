create table student_data(
id int, sname varchar(20));
insert into student_data values(5,'Mounika');
insert into student_data values(6,'Suresh');
alter table student_data add column age int(4);
update student_data set age=25 where id=5;
update student_data set age=27 where id=6;
alter table student_data rename column age to profeesion;
alter table student_data drop column profeesion;
truncate table student_data;
drop table student_data;

desc student_data;
select distinct*from student_data;

