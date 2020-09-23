import java.io.*;
import java.util.*;
public class algo_0923_boj17069_pipe2Test {

	//백준 17069 파이프옮기기
	//dp를 사용해서 1. 가로로 들어가기위해선 대각 혹은 가로로 들어와야함 2. 세로로 들어가기위해선 대각 혹은 세로로 들어와야함 3. 대각으로 들어가기위해선 대각 혹은 세로 혹은 가로이여야함(벽체크를 대각선은 2곳 더해줘야함)
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n+1][n+1]; //접근방식이 그점의 다음을 채우는 식이라서 n+1로 임시로 했음
		long[][][] dp = new long[3][n+1][n+1];  //접근방식이 그점의 다음을 채우는 식이라서 n+1로 임시로 했음
		//0 가로, 1 세로, 2 대각선 + 좌표
		dp[0][0][1] = 1;
		StringTokenizer st;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j+1] != 1) //벽없으면
					dp[0][i][j+1] += dp[0][i][j] + dp[2][i][j]; 
				if(map[i+1][j] != 1) //벽없으면
					dp[1][i+1][j] += dp[1][i][j] + dp[2][i][j];
				if(map[i+1][j+1] != 1 && map[i+1][j] != 1 && map[i][j+1] != 1) //벽없으면
					dp[2][i+1][j+1] += dp[0][i][j] + dp[1][i][j] + dp[2][i][j];	
			}
		}
		
		System.out.println(dp[0][n-1][n-1] + dp[1][n-1][n-1] + dp[2][n-1][n-1]);
		
	}

}
