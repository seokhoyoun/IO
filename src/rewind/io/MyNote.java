package rewind.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyNote {
	
	private Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		MyNote mn = new MyNote();
//		mn.fileSave();
//		mn.fileOpen();
		mn.fileEdit();
	}
	
	public void fileSave() {
		System.out.println("파일에 저장할 내용을 입력하세요");
		StringBuilder sb = new StringBuilder(); String line = null;
		while(!(line = sc.nextLine()).equals("exit")) {
			sb.append(line).append("\n");
		}
		System.out.print("저장하시겠습니까? (y/n) : ");
		if(sc.nextLine().toUpperCase().charAt(0) == 'Y') {
			System.out.print("저장할 파일명 : ");
			String fileName = sc.next();
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
				bw.write(sb.toString());
				System.out.println(fileName+" 파일에 성공적으로 저장하였습니다.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void fileOpen() {
		System.out.print("불러올 파일명 : ");
		try(BufferedReader br = new BufferedReader(new FileReader(sc.next()))){
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileEdit() {
		System.out.print("수정할 파일명 : ");
		String fileName = sc.next();
		try(BufferedReader br = new BufferedReader(new FileReader(fileName));
				BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true))){
			StringBuilder sb = new StringBuilder(); String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			System.out.println(sb.toString());
			System.out.println("파일에 추가할 내용을 입력하세요");
			while(!(line = sc.nextLine()).equals("exit")) {
				sb.append(line).append("\n");
			}
			System.out.println("변경된 내용을 파일에 추가하시겠습니까? (y/n) : ");
			if(sc.next().toUpperCase().charAt(0) == 'Y') {
				bw.write(sb.toString());
				System.out.println(fileName+" 파일의 내용이 변경되었습니다.");
			}
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
