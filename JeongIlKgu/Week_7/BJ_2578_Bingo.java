/*
 * BJ 2578 빙고
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2578_Bingo {
	
	static int[][] Bingo; // 철수의 빙고판
	static int num, count; // 심판이 부른 수, 심판이 부른 수 몇 번째인지

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Bingo = new int[5][5];
		// 철수의 빙고판 입력
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				Bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 사회자가 부르는 수
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				count++;
				num = Integer.parseInt(st.nextToken());
				erase();
				// 12번을 부르기 전까지는 빙고 3개가 안된다.
				if(count < 12) continue;
				if(check()) {
					System.out.println(count);
					return;
				}
			}
		}
	}
	
	// 사회자가 부른 수를 빙고에서 0으로 만든다.
	private static void erase() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(Bingo[i][j] == num) {
					Bingo[i][j] = 0;
					return;
				}
			}
		}
	}

	// 빙고가 몇 개인지 확인하는 함수 -> 가로 5개 세로 5개 대각선 2개
	// 빙고의 개수가 3개가 되면 종료
	private static boolean check() {
		int bingoCount = 0; // 빙고의 개수
		boolean isBingo = false; // 빙고인지 확인
		// 가로
		for (int r = 0; r < 5; r++) {
			isBingo = true;
			for (int c = 0; c < 5; c++) {
				if(Bingo[r][c] != 0) {
					isBingo = false;
					break;
				}
			}
			if(isBingo) bingoCount++;
		}
		// 세로
		for (int c = 0; c < 5; c++) {
			isBingo = true;
			for (int r = 0; r < 5; r++) {
				if(Bingo[r][c] != 0) {
					isBingo = false;
					break;
				}
			}
			if(isBingo) bingoCount++;
		}
		// 대각선
		isBingo = true;
		for (int i = 0; i < 5; i++) {
			if(Bingo[i][i] != 0) {
				isBingo = false;
				break;
			}
		}
		if(isBingo) bingoCount++;

		isBingo = true;
		for (int i = 0; i < 5; i++) {
			if(Bingo[i][4-i] != 0) {
				isBingo = false;
				break;
			}
		}
		if(isBingo) bingoCount++;
		
		
		if(bingoCount >= 3) return true;
		return false;
	}
}
