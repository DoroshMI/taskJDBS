///////////////DERBY////////////////////////////
To create the connect:

--Type the following in ij:  	

	ij> run 'CLASSPATH\dbscript\create_populate_tables.sql';
	ij> run 'D:\Maryan\Project\taskJDBC\dbscript\create_populate_tables.sql';

--Reconnect to the newly created database as user 'user'

	ij> connect 'jdbc:derby://localhost:1527/BookJDBC;user=user;password=secret';



//////////////¬» ќЌјЌЌя ѕ–√–јћ»//////////////////

>mvn clean package  dependency:copy-dependencies

>java -jar target/taskJDBC-1.0.jar

basic commands:

1. exit

2a. add J. Rowling УHarry PotterФ
2b. add J. Rowling
2c. УHarry PotterФ

3a. remove J. Rowling УHarry PotterФ
3b. remove J. Rowling 
3c. remove УHarry PotterФ
якщо Ї сп≥ввпад≥нн€ то ввести номер р€дка

4a. find add J. Rowling УHarry PotterФ
4b. find add J. Rowling 
4c. find add УHarry PotterФ

5.  edit 2 (тут вводимо ID)
    ƒал≥ програма просить оновлен≥ дан≥ дл€ вказаного ID

6.  all	(виводить ус≥ книги)

7.  clean (очищаЇ ус≥ книги у баз≥)



