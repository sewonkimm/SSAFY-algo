package sliver;

import java.util.Arrays;
import java.util.Scanner;

public class bj_2217_로프 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //입력 받고 
		int max = 0;
		int arr[] = new int[N];
		//배열입력
		for (int i = 0; i < N; i++) {
			arr[i]= sc.nextInt();				
		}
		Arrays.sort(arr); //정렬
		
		// 큰수부터 쭉내려오면서 로프의 최대중량을 계산하여 배열에 넣어줌 
		for (int i = N-1; i >= 0; i--) {
			arr[i] = arr[i] * (N-i);
			if(max<arr[i]) max = arr[i];
		}
		System.out.println(max);
	}
}
