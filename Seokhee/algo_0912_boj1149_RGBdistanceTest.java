import java.io.*;
import java.util.*;
public class algo_0912_boj1149_RGBdistanceTest {

	//백준 rgb거리 1149번
	//전형적인 dp문제
	//지금 해당 색을 칠했을 때 그 직전에 나머지 두 색중에서 무엇을 칠했을 때 가장 비쌌는지 기록
	static int n;
	static int[][] cost;
	static int[][] dp;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		cost = new int[n][3];
		dp = new int[n][3];
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];
		//dp[i][j] i번째 칸에서 0=r, 1=g, 2=b 를 선택했을 때 최소비용 저장
		
		dp(0);
		

	}
	public static void dp(int row) {
		if(row==n-1) {
			min = Math.min(dp[n-1][0], dp[n-1][1]);
			min = Math.min(min, dp[n-1][2]);
			System.out.println(min);
			return;
		}
		//지금 칠할 때, 나머지 2색을 이거 직전에 칠했을 때 더 비싼 경우로 셈을 해줌
		dp[row+1][0] = Math.min(dp[row][1]+cost[row+1][0], dp[row][2]+cost[row+1][0]);
		dp[row+1][1] = Math.min(dp[row][0]+cost[row+1][1], dp[row][2]+cost[row+1][1]);
		dp[row+1][2] = Math.min(dp[row][0]+cost[row+1][2], dp[row][1]+cost[row+1][2]);

		dp(row+1);
	}

}











