/*
 * BJ 11399 ATM
 * 오름차순 정리 후 갯수에 맞게 곱하기
 */

import java.util.Arrays;
import java.util.Scanner;

public class BJ_11399_ATM {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] line = new int[N];
		for (int i = 0; i < N; i++) {
			line[i] = sc.nextInt();
		}
		sc.close();
		Arrays.sort(line);
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += (line[i]*(N-i));
		}
		System.out.println(sum);
	}
	
}