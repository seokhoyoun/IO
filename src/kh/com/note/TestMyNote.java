package kh.com.note;

import java.io.IOException;
import java.util.Scanner;

public class TestMyNote {
	
	public static void menu() throws IOException {
		MyNote mn = new MyNote();
		Scanner sc = new Scanner(System.in);
		int mnum;
		do {
		System.out.print("	******   MyNote  *******\r\n" + 
				"\r\n" + 
				"	1. 노트 새로 만들기		//MyNote의 fileSave()\r\n" + 
				"	2. 노트 열기		//MyNote의 fileOpen()\r\n" + 
				"	3. 노트 열어서 수정하기	//MyNote의 fileEdit()\r\n" + 
				"	4. 끝내기		//main() 으로 리턴\r\n" + 
				"\r\n" + 
				"	메뉴 선택 : ");
			mnum = sc.nextInt();
		switch(mnum) {
		case 1 : mn.fileSave(); break;
		case 2 : mn.fileOpen(); break;
		case 3 : mn.fileEdit(); break;
		case 4 : System.out.println("프로그램을 종료합니다. ");return;
		
			}
		}while(true);
	}
	
	public static void main(String[] args) {
		try {
			menu();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
