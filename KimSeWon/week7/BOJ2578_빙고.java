package com.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 사회자가 번호를 부름
 * 2. 번호 체크 
 * 3. 빙고 나왔는지 확인
 */

public class BOJ2578_빙고 {

	static int[][] bingo = new int[5][5];
	static boolean[][] check = new boolean[5][5];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] call = new int[25];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				call[5 * i + j] = Integer.parseInt(st.nextToken());
			}
		}

		// 빙고 부름
		for (int i = 0; i < 25; i++) {
			int num = call[i];
			check(num);
			
			if(i >=5 && isBingo()) {
					System.out.println(i+1);
					break;
				}
			}
		}

	private static void check(int num) {
		// 숫자 체크
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (bingo[i][j] == num) {
					check[i][j] = true;
					break;
				}
			}
		}
	}
	
	private static boolean isBingo() {
		int bingoCnt = 0;
		
		// 세로 줄 확인
		for (int i = 0; i < 5; i++) {
			boolean bingo = true;
			if(!check[0][i]) {
				bingo = false;
				continue;
			}
			for (int j = 0; j < 4; j++) {
				if(check[j][i] != check[j+1][i]) {
					bingo = false;
					break;
				}
			}
			if(bingo)	bingoCnt++;
		}

		// 가로줄 확인
		for (int i = 0; i < 5; i++) {
			boolean bingo = true;
			if(!check[i][0]) {
				bingo = false;
				continue;
			}
			for (int j = 0; j < 4; j++) {
				if(check[i][j] != check[i][j+1]) {
					bingo = false;
					break;
				}
			}
			if(bingo)	bingoCnt++;
		}
		
		// 대각선 확인
		boolean bingo1 = true;
		for (int i = 0; i < 4; i++) {
			if(!check[i][i] || check[i][i] != check[i+1][i+1]) {
				bingo1 = false;
				break;
			}
		}
		if(bingo1)	{
			bingoCnt++;
		}

		boolean bingo2 = true;
		for (int i = 0; i < 4; i++) {
			if(!check[4-i][i] || check[4-i][i] != check[4-i-1][i+1]) {
				bingo2 = false;
				break;
			}
		}
		if(bingo2)	{
			bingoCnt++;
		}

		// 빙고가 3줄 이상이면 종료
		if(bingoCnt >= 3) 	return true;
		return false;
	}

}
