package test.byteIO;
import java.io.*;

public class TestObjectIO {
	
	public void fileSave() {
		// 파일기록에 사용할 객체 배열 준비
		Student[] sar = {
				new Student(12, "홍길동", 4.43, "경영학과"),
				new Student(25, "이순신", 4.5,  "체육학과"),
				new Student(37, "장영실", 3.87,  "정보통신학과")
		};
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.dat"))){
			for(int i = 0; i < sar.length; i++) {
				oos.writeObject(sar[i]);
			}
			System.out.println("파일 기록 완료 \n");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead() {
		int count = 0;
		Student[] sar = new Student[10];
		
		try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("student.dat")))) {
			while(true) {
				System.out.println(sar[count++] = (Student)ois.readObject());
//				count++;
			}
		} catch(EOFException e) {
			System.out.println("\n파일 읽기 완료 \n");
			/*for(int i= 0; i < count; i++) {
				System.out.println(sar[i]);
			}*/
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// 객체입출력 테스트
		TestObjectIO test = new TestObjectIO();
		test.fileSave();
		test.fileRead();
	}

}
