package test.byteIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class TestFileIO {
	// 바이트 기반 파일 출력 스트림 클래스 사용
	// 파일을 하나 만들어서 파일에 카비도 입력값을 기록 저장 처리.
	
	//Field
	private Scanner sc = new Scanner(System.in);
	public void fileSave() {
		FileOutputStream fos = null;
		System.out.print("저장할 파일명 : ");
		String fileName = sc.next(); // 공백을 받지 않기 위함.
		try {
			fos = new FileOutputStream(fileName);
			// 파일과 현재 프로세스가 연견된 출력 스트림 생성됨.
			// 파일 출력 스트림 생성시에 대상 파일이 없으면, 자동으로 파일이 만들어짐.
			// 대상파일이 존재하면, 파일안의 내용을 지우면서 새로쓰기 상태로 파일이 열린다.
			
			// 파일에 데이터 기록 처리
			fos.write(65);
			byte[] bar = {74,65,86,65};
			fos.write(bar);
			String str = "oop programming";
			byte[] bstr = str.getBytes();
			fos.write(bstr, 4, 7);
			// fos.close(); 이곳에서 닫으면 예외 발생시 건너 뛰어짐
			// 예외가 발생하든 안하든 무조건 반납해야 함.
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				System.out.println(fileName+" 저장 완료");
			} catch (IOException e) {
				e.printStackTrace();
			} // 예외가 발생해도 실행하고 끝남. 물론 발생 안해도 실행. 하지만 코드가 더럽다. 
		}
	}
	
	// 바이트 기반 파일 입력 스트림 클래스 사용. 파일의 데이터를 읽어서 콘솔에 출력 처리.
	public void fileRead() {
		FileInputStream fin = null;
		
		System.out.print("읽을 파일명(*.dat) : ");
		String fileName = sc.next();
		
		try {
			fin = new FileInputStream(fileName);
			// 대상 파일이 없으면 에러 남.
			int data;
			while((data = fin.read()) != -1) {
				System.out.print((char)data);
			}
			System.out.println("\n읽기완료");
		} catch (FileNotFoundException e) {
			System.out.println(fileName + " 파일이 존재하지 않습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// 바이트 스트림 파일 입출력 테스트
		TestFileIO tf = new TestFileIO();
//		tf.fileSave();
		tf.fileRead();
	}

}
