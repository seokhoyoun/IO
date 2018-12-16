package rewind.io;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class BookManager {
	private Scanner sc = new Scanner(System.in);
	
	public BookManager() {
		
	}
	
	public void fileSave() {
		Book[] bar = {
				new Book("java1","홍길동",20000,new GregorianCalendar(1999,10,06),0.12),
				new Book("java2","홍길주",10000,new GregorianCalendar(2019,05,06),0.12),
				new Book("java3","홍길순",30000,new GregorianCalendar(1979,03,06),0.12),
				new Book("java4","홍길현",40000,new GregorianCalendar(2009,03,06),0.12)
				};
		try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("books.dat")))){
			for(Book e : bar) {
				oos.writeObject(e);
			}
			System.out.println("books.dat 에 저장 완료!");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void fileRead() {
		Book[] bar = new Book[10];
		try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("books.dat")))) {
			for(int i = 0; i < bar.length; i++) {
				bar[i] = (Book)ois.readObject();
				System.out.println(bar[i].toString());
			}
		} catch (EOFException e) {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
