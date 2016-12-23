package task;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	
	/**
	* Gets a connection from the properties specified in the file database.properties
	* @return the database connection
	*/
	public static Connection getConnection() throws SQLException, IOException {
		Properties props = new Properties();
		try (InputStream in = Files.newInputStream(Paths.get("database.properties"))){
	         props.load(in);
	    }

	    String drivers = props.getProperty("jdbc.drivers");
	    if (drivers != null) System.setProperty("jdbc.drivers", drivers);

	    String url = props.getProperty("jdbc.url");
	    String username = props.getProperty("jdbc.username");
	    String password = props.getProperty("jdbc.password");

	    return DriverManager.getConnection(url, username, password);
	}
	
	/**
	* Close a connection 
	* 
	*/
	public static void closeConnection( Connection toBeClosed ) {
        if( toBeClosed == null )
            return;
        try {
            toBeClosed.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	 /**
	 * Prints a result set.
	 * @param result the result set to be printed
	 */
	 public static void showResultSet(ResultSet result) throws SQLException{
		 ResultSetMetaData metaData = result.getMetaData();
	     int columnCount = metaData.getColumnCount();

	     for (int i = 1; i <= columnCount; i++){
	         if (i > 1) System.out.print(", ");
	         System.out.print(metaData.getColumnLabel(i));
	     }
	     System.out.println();

	     while (result.next()){
	         for (int i = 1; i <= columnCount; i++){
	            if (i > 1) System.out.print(", ");
	            System.out.print(result.getString(i));
	         }
	         System.out.println();
	      }
	   }

}
