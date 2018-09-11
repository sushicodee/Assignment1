import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {

	static String filename = null;
	static Library lib = new Library();
	static Scanner in = new Scanner(System.in);
	static Boolean running = true;

	public static void main(String[] args) throws ClassNotFoundException, IOException {

		while (running) {

			System.out.println("1. For Loading Library "+"\n2. For Adding a book to the Library"+"\n3. For Listing all the books in the library"+"\n4. To save and quit"+"\n5. To delete a book");
				
			int answer = in.nextInt();
			
			switch(answer) {
			case 1:
				System.out.println("Enter the FIle name to load");
				filename=in.next();
				loadScript(filename);
				break;
			case 2:
				addbook();
				break;
			case 3:
				System.out.println(lib.toString());
				break;
			case 4:
				saveandquit();
				break;
				
			case 5:
				System.out.println("enter the isbn of the book you want to remove");
				String key=in.next();
				int val = Integer.parseInt(key);
				removebooks(val);
				break;
			default: System.out.println("Invalid choie");	
			break;
				/*
				default: System.out.println("Invalid choie");
				case 6:
				System.out.println("enter the isbn of the book you want to find");
				searchbook();
			
		*/
			}
					
		}
		System.exit(0);
	}

	 
		

	private static void removebooks(int id) {

		lib.removeBook(id);
			
		}

	private static void addbook() {
		// TODO Auto-generated method stub
	 int isbn;
	 String title,author,publisher;
	 double price;
	 
	 
	 System.out.println("\n Enter the book ISBN");
	 isbn=in.nextInt();
	 
	 System.out.println("\nEnter the book title");
	 title=in.next();

	 System.out.println("\nEnter the book author");
	 author=in.next();

	 System.out.println("\nEnter the book publisher");
	 publisher=in.next();

	 System.out.println("\nEnter the book price");
	 price=in.nextDouble();
	 
	 LibraryManagement b=new LibraryManagement(isbn,title,author,publisher,price);
	 lib.addBook(b);
		
	}

	private static void saveandquit() {
		System.out.println("\n Enter a file name:");
		filename=in.next() + ".ser";
		running=false;		
		FileOutputStream fos=null;
		ObjectOutputStream out=null;
		try {
			fos=new FileOutputStream(filename);
			out=new ObjectOutputStream(fos);
			out.writeObject(lib);
			fos.close();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	private static void loadScript(String filename) throws ClassNotFoundException {
		FileInputStream fil=null;
		ObjectInputStream ois=null;
		
		File file1=new File(filename+".ser");
		if(file1.exists()) {
		try {
			fil=new FileInputStream(file1);
			ois=new ObjectInputStream(fil);
			lib=(Library) ois.readObject();
			fil.close();
			ois.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	else {
		System.out.println("\n the file does not exist");
	}
		
		
	}

}
