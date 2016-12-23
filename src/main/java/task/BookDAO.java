package task;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
public class BookDAO {
 
    private Connection conn;
 
    public BookDAO() throws  IOException {
    	try{
    		conn = DBUtil.getConnection();
    	} catch (SQLException e) {
            e.printStackTrace();
        }  
    }
    
    public int addBook( Book book) {
    	int result=0;
    	try {
            String query = "insert into books (author, title) values (?,?)";  
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, book.getAuthor() );
            preparedStatement.setString( 2, book.getTitle());
            result=preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.err.println("Command ADD is not executed!!!!");
        }
    	return result;
    }
    
    public int deleteBook( int bookID ) {
    	int result=0;
        try {
            String query = "delete from books where bookId=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, bookID);
            result=preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.err.println("Command DELETE is not executed!!!!");
        }
        return result;
    }
    
    public int updateBook(Book newBook ) {
    	int result=0;
        try {
            String query = "update books set  author=?, title=? where bookId=? ";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, newBook.getAuthor() );
            preparedStatement.setString( 2, newBook.getTitle() );
            preparedStatement.setInt( 3, newBook.getBookID() );
            
            result=preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
        	System.err.println("Command UPDATE is not executed!!!!");
        }
        return result;
    }
    
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery( "select * from books" );
            while( resultSet.next() ) {
                Book book = new Book();
                book.setBookID( resultSet.getInt( "bookID" ) );
                book.setAuthor( resultSet.getString( "author" ) );
                book.setTitle( resultSet.getString( "title" ) );
                books.add(book);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
        	System.err.println("Command ALL is not executed!!!!");
        }
        return books;
    }
    
    public List<Book> getBook( Book book ){
    	List<Book> books = new ArrayList<>();
    	try {
    		int i=0,j=0,k=0;
            String query = "select * from books where ";
    		if (book.getBookID()>0) {query +="bookId=?"; i=1;}
    		
    		if (book.getBookID()>0 && book.getAuthor()!=null) {query +="and author=?"; j=1;}
    		else if (book.getBookID()<=0 && book.getAuthor()!=null) {query +="author=?"; j=1;}
    		
    		if ((book.getBookID()>0 || book.getAuthor()!=null) && book.getTitle()!=null) {query +="and title=?"; k=1;}
    		else if ((book.getBookID()<=0 && book.getAuthor()==null) && book.getTitle()!=null) {query +="title=?"; k=1;}
    		
    		PreparedStatement preparedStatement = conn.prepareStatement( query );		
    		if (book.getBookID()>0) preparedStatement.setInt(i, book.getBookID());
    		if (book.getAuthor()!=null) preparedStatement.setString( i+j, book.getAuthor() );	
    		if (book.getTitle()!=null) preparedStatement.setString( i+j+k, book.getTitle() );
   		
         	ResultSet resultSet = preparedStatement.executeQuery();
         	while( resultSet.next() ) {
         		Book b = new Book();
         		b.setBookID( resultSet.getInt( "bookId" ) );
                b.setAuthor( resultSet.getString( "author" ) );
                b.setTitle( resultSet.getString( "title" ) );
                books.add(b);
         	}
         	resultSet.close();
         	preparedStatement.close();
    	} catch (SQLException e) {
    		System.err.println("Command  getBook is not executed!!!!");
    	}
    	return books;
    }
    
    public int clean( ){
    	int result=0;
    	try{
    		Statement stat = conn.createStatement();

    		result=stat.executeUpdate("DELETE FROM BOOKS");
    		
    	}catch (SQLException e) {
    		System.err.println("Command CLEAN is not executed!!!!");
    	}
    	return result; 
    }
    
    public void closeConnection( ) {
    	DBUtil.closeConnection(conn);
    }
    
 
}