# taskJDBS
///////////////DERBY////////////////////////////
To create the connect:

--Type the following in ij:  	

	ij> run 'CLASSPATH\dbscript\create_populate_tables.sql';
	ij> run 'D:\Maryan\Project\taskJDBC\dbscript\create_populate_tables.sql';

--Reconnect to the newly created database as user 'user'

	ij> connect 'jdbc:derby://localhost:1527/BookJDBC;user=user;password=secret';



//////////////ВИКОНАННЯ ПРГРАМИ//////////////////

>mvn clean package  dependency:copy-dependencies

>java -jar target/taskJDBC-1.0.jar

basic commands:

1. exit

2a. add J. Rowling “Harry Potter”
2b. add J. Rowling
2c. “Harry Potter”

3a. remove J. Rowling “Harry Potter”
3b. remove J. Rowling 
3c. remove “Harry Potter”
Якщо є співвпадіння то ввести номер рядка

4a. find add J. Rowling “Harry Potter”
4b. find add J. Rowling 
4c. find add “Harry Potter”

5.  edit 2 (тут вводимо ID)
    Далі програма просить оновлені дані для вказаного ID

6.  all	(виводить усі книги)

7.  clean (очищає усі книги у базі)



