package rewind.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class SungjukProcess {
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		SungjukProcess sp = new SungjukProcess();
//		sp.scoreSave();
		sp.scoreRead();
	}
	
	public void scoreSave() {
		try(DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("score.dat")))){
			while(true) {
				System.out.print("국어 점수 입력 : ");
				int kor = sc.nextInt();
				dos.writeInt(kor);
				System.out.print("영어 점수 입력 : ");
				int eng = sc.nextInt();
				dos.writeInt(eng);
				System.out.print("수학 점수 입력 : ");
				int math = sc.nextInt();
				dos.writeInt(math);
				int sum = kor + eng + math; // 합계
				double avg = sum/3; // 평균
				dos.writeInt(sum);
				dos.writeDouble(avg);
				System.out.print("\n계속 저장하시겠습니까? (y/n): ");
				if((sc.next().toLowerCase().charAt(0)) != 'y')
					break;
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("score.dat 파일이 존재하지 않습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void scoreRead() {
		int count = 0, totalSum = 0;
		double totalAvg = 0;
		try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("score.dat")))){
			while(true) {
				int kor = dis.readInt();
				int eng = dis.readInt();
				int math = dis.readInt();
				int sum = dis.readInt();
				double avg = dis.readDouble();
				totalSum += sum;
				totalAvg += avg;
				System.out.printf("%d번 :%5d%5d%5d%5d  평균 : %.2f \n",count,kor,eng,math,sum,avg);
				count++;
			}
		} catch (EOFException e) {
			System.out.printf("전체 총점 : %d\n전체 평균 : %.2f",totalSum,totalAvg/count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
