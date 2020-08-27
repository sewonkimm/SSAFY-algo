package brroze;

import java.util.Arrays;
import java.util.Scanner;

public class bj_1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		double max= 0;
		double result = 0;
		int N = sc.nextInt();
		double subject[] = new double[N];
		for (int i = 0; i < subject.length; i++) {
			subject[i]= sc.nextInt();
			
		}
		
		for (int i = 0; i < subject.length; i++) { //최대값 구하기
			if(max< subject[i]) {
				max= subject[i];
			}
		}
		for (int i = 0; i < subject.length; i++) { //최대값과 비교하여 배열에 다시넣기
			subject[i]= subject[i]/max*100;
			result += subject[i];
		}
		
		System.out.println(result/subject.length);
		
		
	}
}
