import java.io.*;
import java.util.*;

public class algo_0928_boj11048_moveTest {

	//백준 11048 이동하기
	//dp로 위,왼쪽,왼쪽위 중에 제일 큰 것과 자기자신을 합쳐서 dp배열을 채워 나간다
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		int[][] dp = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = map[0][0];
		
		for(int i=1;i<m;i++) { //첫줄 가로
			dp[0][i] = dp[0][i-1]+map[0][i]; //얘네는 처음에 채워주는게 편하다
		}
		for(int i=1;i<n;i++) { //첫줄 세로
			dp[i][0] = dp[i-1][0]+map[i][0]; //얘네는 처음에 채워주는게 편하다
		}
		
		for(int i=1;i<n;i++) {
			for(int j=1;j<m;j++) {
				dp[i][j] = Math.max(dp[i][j-1] + map[i][j], dp[i-1][j] + map[i][j]); //왼쪽과 위 비교
				dp[i][j] = Math.max(dp[i-1][j-1] + map[i][j], dp[i][j]); //그 둘중에 큰 것과 왼쪽위 대각선과 비교
			}
		}
		
		System.out.println(dp[n-1][m-1]); //출력
	}

}
