import java.io.*;
import java.util.*;

public class algo_1007_boj4485_zelda {

	//백준 4485 녹색옷 입은 애가 젤다지?
	//다익스트라라는데.. dp로 될거같음
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cnt=1;
		while(true) {
			
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			
			
			int[][] map = new int[n][n];
			int[][] dp = new int[n][n];
			
			//map
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//dp1
			dp[0][0] = map[0][0];
			for(int i=1;i<n;i++) {
				dp[0][i] = dp[0][i-1] + map[0][i];
				dp[i][0] = dp[i-1][0] + map[i][0];
			}
			//dp2
			for(int i=1;i<n;i++) {
				for(int j=1;j<n;j++) {
					dp[i][j] = Math.min(dp[i][j-1]+map[i][j], dp[i-1][j]+map[i][j]);
				}
			}
			
			System.out.println("Problem "+cnt+": "+dp[n-1][n-1]);
			cnt++;
		}
	}

}
