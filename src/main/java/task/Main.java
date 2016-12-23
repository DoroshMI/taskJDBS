package task;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(System.in) ;
		BookDAO bookDAO = new BookDAO();
		List<Book> books;
		
		while (true){
			if (args.length == 0) System.out.println("Enter command or EXIT to exit:");

            String line = in.nextLine();
            if ("".equals(line)) continue;
            if (line.equalsIgnoreCase("EXIT")) {bookDAO.closeConnection(); return;}
            
            String command=StringUtil.command(line);
            switch(command) {
            
            case "add": 
            	Book book=StringUtil.query(line.substring(command.length(), line.length()));
            	if (book.getAuthor()==null) book.setAuthor("Unknown");
            	if (book.getTitle()==null) book.setTitle("Unknown");
            	bookDAO.addBook(book);
            	System.out.println("Book "+book+ " was added");          	 
            	break;
            	
        	case "remove": 
        		books=bookDAO.getBook(StringUtil.query(line.substring(command.length(), line.length())));
        		
        		if(books.size()==0) System.out.println("No matches");
        		if(books.size()==1) {
        			bookDAO.deleteBook(books.get(0).getBookID());
        			System.out.println("Book "+books.get(0)+ " was removed");
        		} else{
        			StringUtil.printTitle();
        			int i=1;
        			for(Book b: books) {
        				System.out.println(i++);
        				StringUtil.print(b);
        			}
        			System.out.println("Enter the number");
        			int number=Integer.valueOf(in.nextLine());
        			bookDAO.deleteBook(books.get(number-1).getBookID());
        			System.out.println("book with "+books.get(number-1)+" was deleted");
        		}
        		break;
        		
        	case "find":
        		books=bookDAO.getBook(StringUtil.query(line.substring(command.length(), line.length())));
        		if(books.size()==0) System.out.println("No matches");
        		else{
        			StringUtil.printTitle();
        			for(Book b: books) 
        				StringUtil.print(b);
        		}	 			
        	    break;	
        		
        	case "edit": 
        		int id=Integer.valueOf(line.substring(command.length(), line.length()).trim());
        		System.out.println("Enter new data:");
        		line=in.nextLine();
        		book=StringUtil.query(line.trim());
        		book.setBookID(id);
            	if (book.getAuthor()==null) book.setAuthor("Unknown");
            	if (book.getTitle()==null) book.setTitle("Unknown");
        		bookDAO.updateBook(book);
        		System.out.println("Data were updated"); 
        	    break;
        	    
        	case "all": 
        		books=bookDAO.getAllBooks();
        		StringUtil.printTitle();
        		for(Book b: books)  StringUtil.print(b);
        		break;
        		
        	case "clean": 
        		bookDAO.clean();
        		System.out.println("Table BOOKS was cleaned");            	
        		break;
        		
        	default: 
        	    System.err.println("Incorrect command");
        	    break;
            }
      
		}
		 
		
	}
	

}
