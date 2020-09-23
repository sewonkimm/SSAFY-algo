/*
 * SWEA D2 1974 스도쿠 검증
 * 가로, 세로, 3X3 한번씩 검증하면 완료
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1974_CheckSudoku {
	
	static int[][] sudoku; // 스도쿠
	static boolean[] isCheck; // 검증

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sudoku = new int[9][9];
			boolean isNO = false; // 스도쿠가 성립되지 않을 때 더이상 확인하지 않음
			// 입력
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 가로 확인
			for (int i = 0; i < 9; i++) {
				if(!checkRow(i)) {
					System.out.println("#"+t+" "+0);
					isNO = true;
					break;
				}
			}
			if(isNO) continue;
			// 세로 확인
			for (int i = 0; i < 9; i++) {
				if(!checkCol(i)) {
					System.out.println("#"+t+" "+0);
					isNO = true;
					break;
				}
			}
			if(isNO) continue;
			// 3X3 확인
			for (int i = 0; i < 9; i+=3) {
				for (int j = 0; j < 9; j+=3) {
					if(!checkThree(i,j)) {
						System.out.println("#"+t+" "+0);
						isNO = true;
						break;
					}
				}
				if(isNO) break;
			}
			if(isNO) continue;
			System.out.println("#"+t+" "+1);
		}
	}
	
	private static boolean checkRow(int r) {
		isCheck = new boolean[10];
		for (int i = 0; i < 9; i++) {
			if(isCheck[sudoku[r][i]]) return false;
			isCheck[sudoku[r][i]] = true;
		}
		return true;
	}

	private static boolean checkCol(int c) {
		isCheck = new boolean[10];
		for (int i = 0; i < 9; i++) {
			if(isCheck[sudoku[i][c]]) return false;
			isCheck[sudoku[i][c]] = true;
		}
		return true;
	}
	
	private static boolean checkThree(int r, int c) {
		isCheck = new boolean[10];
		for (int i = r; i < r+3; i++) {
			for (int j = c; j < c+3; j++) {
				if(isCheck[sudoku[i][j]]) return false;
				isCheck[sudoku[i][j]] = true;
			}
		}
		return true;
	}
}
