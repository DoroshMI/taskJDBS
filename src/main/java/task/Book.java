package task;

public class Book {
	
	private int bookID;
    private String author;
    private String title;
    
    public Book(){}
    
    public Book(String author, String title){
    	this.author=author;
    	this.title=title;
    }
    
    public Book(int bookID, String author, String title){
    	this.bookID=bookID;
    	this.author=author;
    	this.title=title;
    }
    
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String toString(){
		return getAuthor()+" \""+getTitle()+"\"";  
	}
    
}
