
mysql> CREATE DATABASE exam_db;
Query OK, 1 row affected (0.05 sec)

mysql> USE exam_db;
Database changed
mysql> CREATE TABLE students (
    ->     id INT AUTO_INCREMENT PRIMARY KEY,
    ->     name VARCHAR(255) NOT NULL,
    ->     email VARCHAR(255) NOT NULL,
    ->     exam_name VARCHAR(255) NOT NULL
    -> );
Query OK, 0 rows affected (0.08 sec)

mysql> SHOW TABLES;
+-------------------+
| Tables_in_exam_db |
+-------------------+
| students          |
+-------------------+
1 row in set (0.03 sec)

mysql> SELECT * FROM students;
Empty set (0.05 sec)

mysql> SELECT * FROM students;
+----+---------------+----------------------------+-----------+
| id | name          | email                      | exam_name |
+----+---------------+----------------------------+-----------+
|  1 | vikas.singh91 | vikas.singh66551@gmail.com | java      |
+----+---------------+----------------------------+-----------+
1 row in set (0.00 sec)

mysql> SELECT * FROM students;
+----+---------------+----------------------------+-----------+
| id | name          | email                      | exam_name |
+----+---------------+----------------------------+-----------+
|  1 | vikas.singh91 | vikas.singh66551@gmail.com | java      |
|  2 | vikas.singh91 | vikas.singh66551@gmail.com | java      |
|  3 | rock          | vikas.singh66551@gmail.com | java      |
+----+---------------+----------------------------+-----------+




  <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/exam_db</property> ----------- > by hibernate.






  ![image](https://github.com/user-attachments/assets/51920dca-c3e9-4db6-a56f-bf0c8abd1226)



