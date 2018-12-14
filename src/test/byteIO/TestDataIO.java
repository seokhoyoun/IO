package test.byteIO;
import java.io.*;

public class TestDataIO {
	
	public void fileSave() {
		// DataOutputStream 클래스는 값을 종류별로 기록할 수 있는 메소드를 제공하는 보조스트림 클래스이다.
		// 기록된 순서로 값을 읽어야한다!!
	/*	try(FileOutputStream fos = new FileOutputStream("member.dat");
				DataOutputStream dos = new DataOutputStream(fos);){*/
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("member.dat"))){
			String name = "홍길동";
			int age = 27;
			char gender = '남';
			double height = 178.5;
			
			dos.writeUTF(name);
			dos.writeInt(age);
			dos.writeChar(gender);
			dos.writeDouble(height);
			dos.flush();
			
			System.out.println("파일에 기록 완료");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void fileRead() {
	/*	try(FileInputStream fis = new FileInputStream("member.dat");
				DataInputStream dis = new DataInputStream(fis)){*/
		try(DataInputStream dis = new DataInputStream(new FileInputStream("member.dat"))){
			String name = dis.readUTF();
			int age = dis.readInt();
			char gender = dis.readChar();
			double height = dis.readDouble();
			
			System.out.printf("%2s %2d %2s %2f",name,age,gender,height);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// data 입출력 보조스트림 테스트
		TestDataIO td = new TestDataIO();
//		td.fileSave();
		td.fileRead();
		
	}

}
