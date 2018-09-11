import java.io.Serializable;

public class LibraryManagement implements Serializable {

	private static final long serialVersionUID = 8366362986887067988L;
	private int isbn;
	private String title, author, publisher;
	private double price;

	public LibraryManagement() {
		isbn = 0;
		title = null;
		author = null;
		publisher = null;
		price = 0;

	}

	public LibraryManagement(int isbn, String title, String author, String publisher, double price) {

		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;

	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {

		return "\n\n" + "ISBN:" + isbn + "\nTitle:" + title + "\nAuthor:" + author + "\nPublisher:" + publisher
				+ "\nPrice:" + price;
	}

}
