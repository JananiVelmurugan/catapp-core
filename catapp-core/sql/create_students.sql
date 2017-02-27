CREATE TABLE students(
id INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(50) NOT NULL,
dept VARCHAR(10) NOT NULL); 
 INSERT INTO students(NAME,dept) VALUES('arun','ece'); 
 INSERT INTO students(NAME,dept) VALUES('balaji','ece'); 
 INSERT INTO students(NAME,dept) VALUES('divya','ece');
 SELECT * FROM students LIMIT 0, 1000; 