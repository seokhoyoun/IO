package silsub3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class BookManager {
	// Field
	Scanner sc = new Scanner(System.in);
	
	// Constructor
	public BookManager() {
		
	}
	
	// Method
	
	public void fileSave() {
		Book[] bar = {
				new Book("자바의 정석","홍길동",30000,new GregorianCalendar(1999,11,22) ,0.1),
				new Book("지바의 정석2","홍길순",20000,new GregorianCalendar(1979,2,2) ,0.2),
				new Book("주바의 정석3","홍길현",120000,new GregorianCalendar(2019,2,12) ,0.3),
				
		};
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("books.dat")))){
			// 대상 파일이 없으면 자동으로 파일을 만든다.
			// 대상 파일이 있으면, 기본으로 파일 안에 내용을 지우고 새로쓰기 상태로 파일을 연다.
			// 파일 출력스트림 생성시에 추가쓰기(append) 모드를 True로 하면 대상파일이 있을 때, 기존 내용은 그대로 두고
			// 내용 뒤에 추가쓰기가 됨.
			for(int i = 0; i < bar.length; i++) {
				oos.writeObject(bar[i]);
			}System.out.println("books.dat 에 저장 완료! \n");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void fileRead() {
		int count = 0;
		Book[] bar = new Book[10];
		try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("books.dat")))){
			while(true) {
				System.out.println(bar[count++] = (Book)ois.readObject());
			}
		} catch(EOFException e) {
			System.out.println("\nbooks.dat 읽기 완료!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
