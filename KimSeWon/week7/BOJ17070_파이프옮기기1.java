import java.util.Scanner;

public class BOJ17070_파이프옮기기1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int[][][] dp = new int[N][N][3];
		// dp[r][c][i] : r, c에 i 파이프를 놓았을 때 경우의 수 (i -> 0:가로, 1:세로, 2:대각선)
		dp[0][1][0] = 1;
		
		for(int r=0; r<N; r++) {
			for(int c=1; c<N; c++) {
				
				if(c+1 < N && map[r][c+1] != 1) {
					dp[r][c+1][0] = dp[r][c][0] + dp[r][c][2];
				}
				
				if(r+1 < N && map[r+1][c] != 1) {
					dp[r+1][c][1] = dp[r][c][1] + dp[r][c][2];
				}
				
				if(r+1 < N && c+1 < N && map[r][c+1] != 1 && map[r+1][c] != 1 && map[r+1][c+1] != 1) {
					dp[r+1][c+1][2] = dp[r][c][0] + dp[r][c][1] + dp[r][c][2];
				}
				
			}
		}
		
		System.out.println(dp[N-1][N-1][0]+dp[N-1][N-1][1]+dp[N-1][N-1][2]);
		sc.close();
	}

}
