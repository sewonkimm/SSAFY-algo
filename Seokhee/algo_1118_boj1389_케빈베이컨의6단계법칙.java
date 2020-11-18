import java.io.*;
import java.util.*;
public class algo_1118_boj1389_케빈베이컨의6단계법칙 {

	static int n;
	static int m;
	static int min = Integer.MAX_VALUE;
	static int[][] link;
	static int[][] dp;
	static int now;

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		link = new int[n+1][n+1];
		dp = new int[n+1][n+1];
		int from, to;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			
			link[to][from] = link[from][to] = 1;
		}
		//못가는 길 -1로 막기
		for(int i=1;i<=n;i++) {
			Arrays.fill(dp[i], -1);
		}
	
		for(int i=1;i<=n;i++) {
			bfs(i);
		}
		System.out.println(now);
	}
	
	static void bfs(int start) {
		dp[start][start] = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll(); //현재
			for(int i=1;i<=n;i++) {
				if(link[cur][i] == 0 || dp[start][i] != -1) continue; 
				
				dp[start][i] = dp[start][cur] +1;
				queue.offer(i);
			}
		}
		int sum =0;
		for(int i=1;i<=n;i++) {
			sum += dp[start][i];
		}
		if(min>sum) {
			min = sum;
			now = start;
		}	
	}
}












