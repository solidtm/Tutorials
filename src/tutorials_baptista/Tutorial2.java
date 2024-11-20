package tutorials_baptista;

public class Tutorial2 {
    public static void main(String[] args) {

    }

    /*
    * Basic concepts in MySQL
    * 1. Databases - is a collection of tables that store related data.
    * 2. Table - a structure composed of rows and columns, where each row represents a record,
    * and each column represents an attribute if a record.
    * 3. Schemas - is a logical container for database objects (such as tables, views, stored procedures)
    * 4. Keys -
    *    Primary key - A colum or set of columns that uniquely identifies a row in a table
    *    Foreign key - A column that refers to the primary key of another table, used to establish a relationship between two tables.
    *
    * Basic SQL syntaxes in MYSQL
    * 1. Creating a database - create database <database name>
    * 2. Using a database - use <database name>
         Data types in MYSQL
         * Number data types
         * 1. INT - Integer values
         * 2. FLOAT, BOOLEAN - Floating point number 3.143
         * 3. DECIMALS - Fixed point numbers
         * String data types
         * 4. VARCHAR - Variable length of strings
         * 5. CHAR - Fixed length of strings
         * 6. TEXT - Long text data
         * Date and Time
         * 7. DATE - Date in YYYY-MM-DD format
         * 8. TIME - Time in HH:MM:SS format
         * 9. DATETIME - Date and time in YYYY-MM-DD HH:MM:SS format
         * 10.TIMESTAMP - Date and time in YYYY-MM-DD HH:MM:SS format with automatic updates
    * 3. Creating a table - create table <table name>(parameters of the table column with their data types);
    * 4. Inserting data into a table - insert into <table name> values (parameters for the table columns)
    * 5. Querying data from a table - select * from <table_name>
    * 6. Updating data in a table - update <table_name> set <column_name> = <value>
    * 7. Deleting data from a table -
    *    a) delete a row from a table - delete from <table_name> where <column_name> = <value>
    *    b) delete all rows in a table - truncate table <table name>
    *    c) delete a table from the database - drop table <table name>
    *
    * Advanced MYSQL features
    * 1. JOINS - An operation that combines data from two  or more tables based on a related column, using a foreign key
    *    a) Inner Join - Returns a specific record that has matching values in both of the tables
    *            select students.first_name, students.last_name, courses.course.name
    *            from students
    *            inner join enrollments on students.student_id = enrollment_id
    *            inner join courses on enrollments.course_id = courses.course_id;
    *
    *    b) Left Join -
    *
    *
    *
    *
    * */
}
