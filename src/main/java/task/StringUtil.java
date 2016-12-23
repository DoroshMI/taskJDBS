package task;

import java.util.Formatter;

public class StringUtil {

	private static Formatter f = new Formatter(System.out);
	public static void printTitle() {
	   
	    f.format("%-5s %s %40s\n", "ID", "Author", "Title");
	    f.format("%-5s %s %40s\n", "--", "------", "-----");
	}
	
	public static void print(Book book) {
	    f.format("%-5d %-41.40s %s\n", book.getBookID(), book.getAuthor(), book.getTitle());
	}
	
	public static String command(String line){
		line = line.trim();
		String c;
		if(line.indexOf(' ')<0) c=line;
		else c=line.substring(0, line.indexOf(' '));
		c=c.toLowerCase();	
		return c;
	}
	
	public static Book query (String line){
		Book book=null;
		String author=null;
		String title=null;
		line=line.trim();
		if (line.indexOf('"')>=1) {author=line.substring(0, line.indexOf('"')); title=line.substring(line.indexOf('"')+1,line.length()-1);}
		else if (line.indexOf('"')==0){title=line.substring(1,line.length()-1);}
		else author=line;
		
		if (author!=null) author=author.trim();
		if (title!=null) title=title.trim();
		book=new Book(author, title);
		return book;
	}
	
	
}
