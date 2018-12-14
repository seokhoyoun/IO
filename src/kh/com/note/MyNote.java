package kh.com.note;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyNote {
	// Field
	private Scanner sc = new Scanner(System.in);
	
	// Constructor
	public MyNote() {
		
	}
	
	// Method
	public void fileSave() throws IOException {
		System.out.println("파일에 저장할 내용을 입력하시오");
		StringBuilder sb = new StringBuilder();
			String line = null;
			while(!(line = sc.nextLine()).equals("exit")) {
				sb.append(line).append("\n"); // StringBuilder 를 사용하여 문자열을 반복해서 입력
			}
			System.out.print("저장하시겠습니까? (y/n) : ");
			if((sc.nextLine().toUpperCase().charAt(0)) == 'Y'){
				System.out.print("저장할 파일명 : ");
				String fileName = sc.next();
				BufferedWriter bw = new BufferedWriter(new FileWriter(fileName)); // 파일명 입력받아, 해당 파일에 출력 기록
				bw.write(sb.toString()); // 저장
				System.out.println(fileName + " 파일에 성공적으로 저장하였습니다.\n");
			}
	
	}
	
	public void fileOpen() throws IOException {
		System.out.print("불러올 파일명 : ");
		BufferedReader br = new BufferedReader(new FileReader(sc.next()));
		String line = null;
		while((line = br.readLine()) != null) {
			
		}
	}
	
	public void fileEdit() {
		
	}
	
	
}
