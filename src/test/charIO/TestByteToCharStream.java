package test.charIO;
import java.io.*;

public class TestByteToCharStream {

	public static void main(String[] args) {
		// 바이트 스트림을 문자스트림으로 바꾸기
		// 읽기용 스트림에만 적용할 수 있음.
		// 기본 스트림은 InputStream임
		// 보조 스트림이 Reader 이다.
		
		// 키보드 장치가 : System.in
		// public static final InputStream in;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("입력할 내용 : ");
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while((line = br.readLine()).equals("exit") == false) {
				sb.append(line).append("\n");
			}
			System.out.println("----------------------------");
			System.out.println(sb.toString());
			System.out.println("----------------------------");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
