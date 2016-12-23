-- Create the database and connect to it.
connect 'jdbc:derby://localhost:1527/BookJDBC;create=true';

-- Add a user to the database, username user, password secret
CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY('derby.user.dev','user');

-- Grant all privileges to user dev
CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY('derby.database.fullAccessUsers','secret');

-- Disconnect from the newly created database
disconnect;

-- Reconnect to the newly created database as user dev
connect 'jdbc:derby://localhost:1527/BookJDBC;user=user;password=secret';

-- Create tables
CREATE TABLE BOOKS (BookID INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), Author VARCHAR(25), Title VARCHAR(60)  );
-- Populate tables

INSERT INTO BOOKS (Author, Title) VALUES ('J. Rowling', 'Harry Potter');


