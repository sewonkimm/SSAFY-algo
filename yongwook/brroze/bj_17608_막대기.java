package brroze;

import java.util.Scanner;

public class bj_17608_막대기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int arr[] = new int[N];
		int temp= 0;
		int result =0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		temp = arr[N-1];
		
		for (int i = N-1; i >= 0; i--) {
			if(arr[i]>temp) {
				temp=arr[i];
				result++;
				
			}
		}
		System.out.println(result+1);
	}
}
