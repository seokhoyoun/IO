package test.byteIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class TestFileIO2 {
	private static Scanner sc = new Scanner(System.in);
	
	public static void menu() {
		int mnum;
		TestFileIO2 tf2 = new TestFileIO2();
		do {
			System.out.println("\n*** 간단 메모장 ***\n"
					+ "\n1. 새 메모 기록 저장\n"
					+ "2. 메모 읽어오기 \n"
					+ "3. 종료 ");
			System.out.print("번호 선택 : ");
		mnum = sc.nextInt();
		switch(mnum) {
		case 1: tf2.fileSave(); break;
		case 2: tf2.fileRead(); break;
		case 3: System.out.println("메모장을 종료합니다."); return;
		default:System.out.println("잘못된 입력입니다.\n 다시 입력해주세요.");	
		}
		
		}while(true);
	}
	public void fileSave() {
		// 저장할 파일명 입력, 바이트 기반 파일 출력 스트림. 파일명은 키보드로 입력 받음
		// 기록할 내용은 키보드로 문자열로 입력받아서 파일에 기록 처리.
		// 반복 입력과 기록 처리
		// 종료 조건 : "exit" 가 입력되면 종료.
		FileOutputStream fos = null;
		System.out.print("저장 할 파일명 입력 : ");
		String fileName = sc.next();
		try {
			fos = new FileOutputStream(fileName);
			sc.nextLine();
			while(true) {
				System.out.println("입력을 시작합니다.");
				fos.write(sc.nextLine().getBytes());;
				System.out.print("종료하시겠습니까? (exit)\n"
						+ "계속하시려면 아무 키나 눌러주세요 : ");
				String exit = sc.nextLine();
				if(exit.equals("exit")) {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일이 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				System.out.println(fileName+" 저장 완료");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	public void fileRead() {
		// 바이트 기반 파일 입력 스트림 사용. 저장된 파일의 내용을 읽어서 콘솔에 출력 처리.
		FileInputStream fis = null;
		System.out.print("불러올 파일 명 : ");
		String fileName = sc.next();
		try {
			fis = new FileInputStream(fileName);
			int data;
			while((data = fis.read()) != -1) {
				System.out.print((char)data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		// 바이트 기반 파일 입출력 실습
		menu();
	}

}
