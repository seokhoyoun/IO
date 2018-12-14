package week4.io.silsub;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TestSilsub1 {
	private Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		TestSilsub1 test = new TestSilsub1();
//		test.fileSave();
		test.fileRead();
	}
	
	public void fileSave() {
		System.out.print("저장할 파일명 : ");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(sc.next()))){
			System.out.println("저장할 내용을 입력하세요.(종료 = exit)");
			sc.nextLine(); // 버퍼 엔터키 제거
			String line;
			while(!(line = sc.nextLine()).equals("exit")) {
				bw.write(line);
				bw.newLine(); // 개행 처리
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead() {
		System.out.print("불러올 파일명 입력 : ");
		try (BufferedReader br = new BufferedReader(new FileReader(sc.next()))){
			StringBuilder sb = new StringBuilder();
				String line = null;
				while((line = br.readLine()) != null) {
					sb.append(line);
				}
				System.out.println(sb.toString());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
