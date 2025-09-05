# Student Management System

##  Overview
A simple Java console application to manage student records with MySQL integration.

##  Setup
1. Create MySQL database and table:
   ```sql
   CREATE DATABASE student_db;
   USE student_db;
   CREATE TABLE students (
     roll_no INT PRIMARY KEY,
     name VARCHAR(100),
     department VARCHAR(50),
     email VARCHAR(100),
     phone VARCHAR(15)
   );

##  Compile
javac -cp "lib/mysql-connector-j-9.4.0.jar;src" src/*.java

##  Run
java -cp "lib/mysql-connector-j-9.4.0.jar;src" Main
## Features
- Add new students  
- Update student details  
- View all students  
- Persistent storage with MySQL


  >  **Note**: Download `mysql-connector-j-9.4.0.jar` from the official MySQL site and place it into the `lib/` folder before compiling/running.
