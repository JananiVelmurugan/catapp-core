CREATE TABLE student_mark_details(
id INT PRIMARY KEY AUTO_INCREMENT,
student_id INT,
subject_id INT,
cat1 INT DEFAULT 0,
cat2 INT DEFAULT 0,
cat3 INT DEFAULT 0,
internal INT DEFAULT 0,
FOREIGN KEY fk_student_id(student_id) REFERENCES students(id),
FOREIGN KEY fk_subject_id(subject_id) REFERENCES subjects(id)
);
 
 SELECT * FROM student_mark_details;
 
 
 INSERT INTO student_mark_details(student_id,subject_id,cat1,cat2,cat3,internal) VALUES(1,1,75,65,0,75);
 
 
 INSERT INTO student_mark_details(student_id,subject_id,cat1,cat2,cat3,internal) VALUES(1,2,75,85,0,85);
 