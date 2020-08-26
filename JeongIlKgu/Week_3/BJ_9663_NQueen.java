/*
 * BJ 9663 N-Queen
 */

import java.util.Scanner;

public class BJ_9663_NQueen {
	
	static int N, totalCount; // 체스판의 크기, 서로 공격할 수 없게 놓는 경우의 수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			int[] col = new int[N+1]; // 1~N까지 두기 위해서
			col[1] = i; // 1행 i열 -> Queen
			dfs(col,1); // 첫번째 행에 Queen 배치
		}
		System.out.println(totalCount);
		sc.close();
	}
	
	public static void dfs(int[] col, int row) {
		// 모든 Queen을 배치했을 때
		if(row == N) totalCount++;
		else {
			for (int i = 1; i <= N; i++) {
				// 다음 행에 Queen을 배치하고 다른 Queen과 겹치지 않는다면 그 다음 행으로
				col[row+1] = i;
				if(isOk(col,row+1)) dfs(col,row+1);
			}
		}
	}

	public static boolean isOk(int[] col, int row) {
		for (int i = 1; i < row; i++) {
			// i행과 row행의 열이 같은 경우
			if(col[i] == col[row]) return false;
			// 대각에 위치하는 경우
			if(Math.abs(i-row) == Math.abs(col[i]-col[row])) return false;
		}
		return true;
	}
}
