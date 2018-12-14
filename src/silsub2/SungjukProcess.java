package silsub2;

import java.io.*;
import java.util.Scanner;

public class SungjukProcess {
	// Field
	private Scanner sc = new Scanner(System.in);
	
	public void sungjukSave() {
		try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("score.dat")))){
		while(true) {
			
		System.out.print("국어 점수를 입력해주세요 : ");
		int kor = sc.nextInt();
		System.out.print("수학 점수를 입력해주세요 : ");
		int math = sc.nextInt();
		System.out.print("영어 점수를 입력해주세요 : ");
		int eng = sc.nextInt();
		int sum = (kor + math + eng);
		double avg = sum/3;
			dos.writeInt(kor); // 국어 저장
			dos.writeInt(math); // 수학
			dos.writeInt(eng); // 영어
			dos.writeInt(sum); // 총점
			dos.writeDouble(avg); // 평균
		System.out.print("계속 저장하시겠습니까? (y/n) : ");
		if((sc.next().toUpperCase().charAt(0)) == 'N') {
			System.out.println("score.dat 에 저장 완료. \n"); break;
			}
		}
	} catch(IOException e) {
		e.printStackTrace();
	}
}
	
	public void scoreRead() {
		
		int totalSum = 0, count = 0;
		double totalAvg = 0;
		try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("score.dat")))){
		do {
			int kor = dis.readInt();
			int math = dis.readInt();
			int eng = dis.readInt();
			int sum = dis.readInt();
			double avg = (int)(dis.readDouble()*100)/100.00;
			System.out.printf("%d점\t%d점\t%d점\t총점 : %d\t평균 : %.2f\n",kor,math,eng,sum,avg);
			totalSum += sum;
			totalAvg += avg;
			count++;
		}while(true);
		
		} catch (EOFException e) {
			System.out.printf("총 합계 : %d\n총 평균 : %.2f\n",totalSum,totalAvg/count);
			System.out.println("score.dat 파일 읽기 완료.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		SungjukProcess sp = new SungjukProcess();
		sp.sungjukSave();
		sp.scoreRead();
		
	}

}
