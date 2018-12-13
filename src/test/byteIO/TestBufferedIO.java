package test.byteIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class TestBufferedIO {
	private Scanner sc = new Scanner(System.in);
	// Constructor
	public TestBufferedIO() {
		
	}
	// 저장
	public void fileSave() {
		BufferedOutputStream bos = null;
		FileOutputStream fos = null;
		
		System.out.println("저장할 파일명 : ");
		String fileName =sc.next();
		
		try {
			fos = new FileOutputStream(fileName);
			bos = new BufferedOutputStream(fos);
			
			System.out.println("파일에 기록할 내용을 입력하세요 ");
			String str = null;
			sc.nextLine();
			while(!(str = sc.nextLine()).equals("exit")) {
				bos.write(str.getBytes());
			}
			bos.flush();
			System.out.println("파일 저장 완료");
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException e) {
			System.out.println("파일 기록 오류");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bos.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	// 불러오기
	public void fileRead() {
		System.out.print("불러올 파일명 : ");
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sc.next()))) {
			int data;
			while((data = bis.read()) != -1) {
				System.out.print((char)data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fileSave2()	{
	
	System.out.print("저장할 파일명 : ");
	try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(sc.next()))) {
		System.out.println("파일에 기록할 내용을 입력하세요 (종료 = exit)  ");
		String str = null;
		sc.nextLine();
		while(!(str = sc.nextLine()).equals("exit")) {
			bos.write(str.getBytes());
		}
		bos.flush();
		System.out.println("파일 저장 완료");
		
	}catch (Exception e) {
		e.printStackTrace();
	} 
	
}
	public static void main(String[] args) {
		// buffer를 이용한 보조스트림 사용 테스트
		TestBufferedIO test = new TestBufferedIO();
//		test.fileSave2();
		test.fileRead();
		
	}

}
