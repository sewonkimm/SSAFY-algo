/*
 * D1 2068 최대수 구하기
 * 각 테스트 케이스마다 수를 입력받는 동시에 최대값과 비교해서 출력
 */

package com.ssafy;

import java.util.Scanner;

public class D1_2068_findMaxNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int max = 0; // 최대값 저장
			for (int i = 0; i < 10; i++) {
				int a = sc.nextInt(); // 수 입력
				if(max < a) max = a; // 최대값 비교
			}
			System.out.println("#"+t+" "+max);
		}
		sc.close();
	}
}
