package week4.io.silsub;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestSilsub1 {
	public static void main(String[] args) {
//		fileSave();
		TestSilsub1 test = new TestSilsub1();
		test.fileRead();
	}
	
	public static void fileSave() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		FileOutputStream fin = null;
		try {
		System.out.print("파일명 입력 : ");
		String fileName = in.readLine();
			fin = new FileOutputStream(fileName);
			System.out.println("프로젝트 작성을 시작합니다.\n끝내시려면 exit를 입력하세요.");
			String line = null;
			while(!(line = in.readLine()).equals("exit")) {
				fin.write(line.getBytes());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
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
	
	public void fileRead() {
		System.out.print("불러올 파일명 입력 : ");
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(in.readLine()))){
			int data;
			while((data = bis.read()) != -1) {
				sb.append((char)data);
			}
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
