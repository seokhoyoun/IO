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
	public void fileSave() {
		System.out.println("파일에 저장할 내용을 입력하세요 ");
		StringBuilder sb = new StringBuilder();
		MyNote mn = new MyNote();
		String line = null;
		while(!(line = sc.nextLine()).equals("exit")) {
			sb.append(line);
		}
		System.out.println("저장하시겠습니까? (y/n) : ");
		if((sc.next().toLowerCase().charAt(0)) == 'y') {
			System.out.print("저장할 파일명 : ");
			String fName = sc.next();
				try {
					if((mn.fileCheck(fName) == false)) {
						throw new TitleException("특수문자나 기호는 사용하실 수 없습니다.\n");
					}
				} catch (TitleException e) {
					System.out.println(e.getMessage());
					return;
				}
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(fName))){
				bw.write(sb.toString());
				bw.newLine();
				System.out.println(fName + " 파일에 성공적으로 저장하였습니다.");
			}catch (IOException e) {
				e.printStackTrace();
			} 
			
		}
	
	}
	
	public void fileOpen() {
		System.out.print("불러올 파일명 : ");
		String fName = sc.next();
		try(BufferedReader br = new BufferedReader(new FileReader(fName))){
			
		} catch (FileNotFoundException e) {
			System.out.println(fName+" 파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void fileEdit() {
		
	}
	
	// test
	public boolean fileCheck(String title) {
		char[] tc = title.toCharArray();
		for(int i = 0; i < tc.length; i++) {
			if(!(Character.isLetterOrDigit(tc[i]))) {
				return false;
			}
		}
		return true;
	}
	
}
