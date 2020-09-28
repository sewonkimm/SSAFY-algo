/*
 * BJ 11048 이동하기
 * Delta를 이용해서 3가지 방향에서 현재를 찾는다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11048_Movement {
	
	// delta
	static int[] dirR = {0,1,1};
	static int[] dirC = {1,1,0};
	static int[][] room, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int R = Integer.parseInt(st.nextToken()); // N
		int C = Integer.parseInt(st.nextToken()); // M
		room = new int[R+1][C+1]; // 방
		dp = new int[R+1][C+1];
		// 사탕 입력
		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 가장 많은 사탕 길 찾기
		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				for (int i = 0; i < 3; i++) {
					int nr = r - dirR[i];
					int nc = c - dirC[i];
					dp[r][c] = Math.max(dp[r][c], dp[nr][nc]+room[r][c]);
				}
			}
		}
		System.out.println(dp[R][C]);
	}
}
