package test.charIO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TestCFileIO01 {
	private Scanner sc = new Scanner(System.in);
	
	// Constructor
	public TestCFileIO01() {
		
	}
	// 문자 스트림으로 파일에 저장 처리
	public void fileSave() {
		FileWriter fw = null;
		System.out.print("저장할 파일 명 : ");
		String fileName = sc.next();
		System.out.println(fileName+" 저장 완료");
		
		try {
			fw = new FileWriter(fileName);
			// 대상 파일이 없으면 파일을 새로 만듦
			// 대상 파일이 있으면, 새로쓰기 상태로 열림.
			fw.write('A');
			fw.write("java program\n");
			char[] charr = {'a','p','p','l','e'};
			fw.write(charr);
			fw.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
		
	}
	
	// 문자 스트림으로 파일로 부터 읽어와서 콘솔에 출력
	public void fileRead() {
		System.out.print("불러올 파일명을 입력하세요 : ");
		try(FileReader fr = new FileReader(sc.next())) {
			int data;
			while((data = fr.read()) != -1) {
				System.out.print((char)data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		// 문자 기반 파일 입출력 테스트
		TestCFileIO01 test = new TestCFileIO01();
//		test.fileSave();
		test.fileRead();
	}

}
