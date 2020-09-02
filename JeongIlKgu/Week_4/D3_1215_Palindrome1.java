/*
 * SWEA D3 1215 회문1
 * 각 범위에서 주어진 길이/2 만큼 마주보며 다가온다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_1215_Palindrome1 {
	
	static int L, answer; // 주어진 길이, 회문의 개수
	static char[][] map; // 글자판

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			answer = 0;
			map = new char[8][8];
			L = Integer.parseInt(in.readLine());
			for (int i = 0; i < 8; i++) {
				String s = in.readLine();
				for (int j = 0; j < 8; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			// 행을 기준으로 열 요소 확인
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 9-L; j++) {
					if(checkRow(i,j)) answer++;
				}
			}
			// 열을 기준으로 행 요소 확인
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 9-L; j++) {
					if(checkCol(j,i)) answer++;
				}
			}
			System.out.println("#"+t+" "+answer);
		}
	}
	
	private static boolean checkRow(int i, int j) {
		for (int k = 0; k < L/2; k++) {
			if(map[i][j+k] != map[i][j+L-1-k]) return false;
		}
		return true;
	}
	
	private static boolean checkCol(int i, int j) {
		for (int k = 0; k < L/2; k++) {
			if(map[i+k][j] != map[i+L-1-k][j]) return false;
		}
		return true;
	}

}
