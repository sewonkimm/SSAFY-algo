import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4613_러시아국기같은깃발 {

	static int N, M, min;
	static char[][] flag;
	static int[][] dp ;
	static int[] color;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase<=T; testCase++) {
			// input 
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			flag = new char[N][M]; 
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<M; j++) {
					flag[i][j] = str.charAt(j);
				}
			}
			
			// dp[i][0] : i번째줄을 W로 칠할 때 새로 칠해야하는 칸의 갯수
			// dp[i][1] : i번째줄을 B로 칠할 때 새로 칠해야하는 칸의 갯수
			// dp[i][2] : i번째줄을 R로 칠할 때 새로 칠해야하는 칸의 갯수
			dp = new int[N][3];	
			
			int countFirstLine = 0;
			int countLastLine = 0;
			for(int i=0; i<M; i++) {
				if(flag[0][i] != 'W')	countFirstLine++;
				if(flag[N-1][i] != 'R')	countLastLine++;
			}
			dp[0][0] = countFirstLine;	// 맨 첫번째 줄은 무조건 W로 칠함
			dp[N-1][2] = countLastLine;	// 맨 마지막 줄은 무조건 R로 칠함
			
			// 1 ~ N-2 까지의 라인 색 조합
			min = Integer.MAX_VALUE;
			color = new int[N-2];
			comb(N-2, 0, 0);
			
			int answer = dp[0][0] + dp[N-1][2] + min;			
			System.out.println("#"+testCase+" "+answer);
		} // End of testCase
	} // End of main

	private static void comb(int r, int cnt, int cur) {
		
		// 기저조건
		if(cnt == r) {
			// 1을 안 칠하고 바로 2부터 칠하는 경우 pass
			if(color[0] == 2)	return;
			
			// 0에서 2로 바로 넘어가는 경우 제외하기
			for(int i=0; i<color.length-1; i++) {
				if(color[i+1]-color[i] > 1) return;
			}

			// 1을 사용하지 않는 경우 제외
			boolean isOne = false;
			for(int i=0; i<color.length; i++) {
				if(color[i] == 1) {
					isOne = true;
					break;
				}
			}
			if(!isOne)	return;
						
			// color 조합대로 칸의 갯수 구하기
			int sum = 0;
			for(int i=0; i<color.length; i++) {
				if(dp[1+i][color[i]] == 0) {
					dp[1+i][color[i]] = paint(1+i, color[i]);
				}
				sum += dp[1+i][color[i]];
			}
			
			// 최소값 구하기
			min = Math.min(min, sum);
			return;
		}
		
		// 유도조건
		if(cur > 2)	return;
		
		color[cnt] = cur;
		comb(r, cnt+1, cur);
		comb(r, cnt, cur+1);
		
	}
	
	private static int paint(int row, int c) {
		char ch = 'W';
		if(c == 1)		ch = 'B';
		else if(c == 2) ch = 'R';
		
		int count = 0;
		for(int i=0; i<M; i++) {
			if(flag[row][i] != ch) {
				count++;
			}
		}
		return count;
	}
}
