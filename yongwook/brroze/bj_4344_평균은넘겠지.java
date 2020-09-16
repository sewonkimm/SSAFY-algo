package brroze;

import java.util.Scanner;

public class bj_4344_평균은넘겠지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int arr[] = new int[a];
			for (int j = 0; j < a; j++) {
				arr[j] = sc.nextInt();
			}
			int sum = 0;
			for (int j = 0; j < arr.length; j++) {
				sum += arr[j];
			}
			double avg= sum/a;
			
			int student = 0;
			for (int j = 0; j < arr.length; j++) {
				if	(arr[j] > avg) {
					student++;
				}
			}
			double result = (double)100*student/a;
			System.out.printf("%.3f",result);
			System.out.println("%");
		}
	}
}
