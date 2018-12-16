package rewind.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Testsilsub1 {

	public static void main(String[] args) {
		Testsilsub1 test = new Testsilsub1();
//		test.fileSave();
		test.fileRead();
	}
	
	public void fileSave() {
		System.out.print("새로 작성할 파일명 : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(br.readLine()))){
			System.out.println("파일에 저장할 내용을 입력하시오.");
			String line = null;
			while(!(line = br.readLine()).equals("exit")) {
				bw.write(line);
				bw.newLine();
			}
			System.out.println("파일에 성공적으로 저장되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("불러올 파일명 : ");
		try(BufferedReader br = new BufferedReader(new FileReader(in.readLine()))){
			StringBuilder sb = new StringBuilder(); String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일이 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
