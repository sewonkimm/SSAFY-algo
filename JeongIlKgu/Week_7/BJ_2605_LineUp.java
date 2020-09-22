/*
 * BJ 2605 줄 세우기
 */

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2605_LineUp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 학생 수
		int[] order = new int[N+1]; // 학생들의 순서
		int[] answer = new int[N+1];
		Arrays.fill(order, 0);
		
		// 줄 세우기
		for (int i = 1; i <= N; i++) {
			// 줄을 선 학생의 번호 = 원래 번호 - 뽑은 번호
			int student = i-sc.nextInt(); 
			
			// 순서 배열에서 현재 들어온 학생의 순서보다 크거나 같은 학생들의 순서 +1
			for (int j = 1; j <= N; j++) {
				if(order[j] >= student) order[j]++;
			}
			
			order[i] = student;
		}
		
		// 순서 정리
		for (int i = 1; i <= N; i++) {
			answer[order[i]] = i;
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(answer[i] + " ");
		}
		
		sc.close();
	}

}
