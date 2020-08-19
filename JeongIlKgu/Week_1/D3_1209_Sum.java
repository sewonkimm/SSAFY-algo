/*
 * D3 1209 Sum
 * 1) 행 기준으로 반복
 * 2) 열 기준으로 반복
 * 3) 대각선 2번
 * 1), 2), 3)을 실행하면서 각 행, 열, 대각으로
 * 최대값 비교
 */

package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_1209_Sum {
	
	static int[][] arr; // 값 저장할 배열
	static int max; // 더한 수의 최대값

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			// 배열 입력
			arr = new int[100][100];
			max = 0;
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 행과 열
			for (int i = 0; i < 100; i++) {
				int temp1 = 0;
				int temp2 = 0;
				for (int j = 0; j < 100; j++) {
					temp1 += arr[i][j]; // 행 기준 더하기
					temp2 += arr[j][i]; // 열 기준 더하기
				}
				// 확인
				if(temp1 > max) max = temp1;
				if(temp2 > max) max = temp2;
			}
			// 대각
			int temp1 = 0; 
			int temp2 = 0;
			for (int i = 0; i < 100; i++) {
				temp1 += arr[i][i]; // 오른쪽 아래로 내려가는 대각선
				temp2 += arr[i][99-i]; // 왼쪽 아래로 내려가는 대각선
			}
			// 확인
			if(temp1 > max) max = temp1;
			if(temp2 > max) max = temp2;
			
			System.out.println("#"+t+" "+max);
		}
	}

}
