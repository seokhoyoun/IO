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
		String line = null;
		while((line = sc.nextLine()) != "exit")
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(sc.next()))){
			
		} catch(Exception e) {
			
		}
	
	}
	
	public void fileOpen() {
		System.out.print("불러올 파일명 : ");
		
	}
	public void fileEdit() {
		
	}
	
	
}
