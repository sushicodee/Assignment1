
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Library implements Serializable {

	private static final long serialVersionUID = 5150760835797707938L;
	private List<LibraryManagement> collection;

	public Library() {
		collection = new ArrayList<LibraryManagement>();
	}

	public void addBook(LibraryManagement book) {
		collection.add(book);
	}

	public void removeBook(int id) {

		for (LibraryManagement lib : collection) {
			if (lib.getIsbn() == id) {
				collection.remove(collection.indexOf(lib));
				System.out.println("Deletion successful\n");
				break;
			} else {
				System.out.println("Deletion failed the book isbn does not exist.");
			}
		}
	}
	/*
	public LibraryManagement getByISBN(int id) {

		LibraryManagement book;
		book = collection.get(id);
		return book;
	}
	*/

	@Override
	public String toString() {
		Iterator<LibraryManagement> i = ((java.util.List<LibraryManagement>) collection).iterator();
		Object total = null;
		while (i.hasNext()) {
			LibraryManagement b = (LibraryManagement) i.next();
			total = total + b.toString();

		}
		return (String) total;

	}
}
