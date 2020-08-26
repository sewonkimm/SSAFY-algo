import java.io.*;
import java.util.*;
public class baconTest {
	
	//백준 1389번 케빈베이컨의 6단계 법칙
	//dfs 절대 안되고, bfs로 접근해야지 맞는데 완전하게 사용할 시 메모리초과가 나옴
	//다익스트라를 사용해서 그 점으로 가는 최소값을 dp배열에 집어넣자
	//그 이후 dp배열이 존재할 때, 다른점으로 이어가려면 link배열을 확인한 후, dp배열 목적지에 현재점+1(=다음점)을 해주는 식으로  
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
			
			link[to][from] = link[from][to] = 1; //무향그래프
		}
		//못가는 길 -1로 막기, -1이면 가는 방법이 아직은 없거나 쭉 없다. 이 점에서 이어나가기 불가능하다는 뜻
		for(int i=1;i<=n;i++) {
			Arrays.fill(dp[i], -1);
		}
	
		for(int i=1;i<=n;i++) {
			bfs(i);
		}
		System.out.println(now); //베이컨지수의 최솟값 min이 아닌 베이컨지수가 최소인 '사람'을 출력
	}
	
	static void bfs(int start) {
		dp[start][start] = 0; //나 자신은 비용이 0으로 도착 할 수 있음(못가는건 -1이라서 상관없다)
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll(); //현재
			for(int i=1;i<=n;i++) {
				if(link[cur][i] == 0 || dp[start][i] != -1) continue;  
				//이 점에서 해당 점으로 가는 길이 존재하지 않거나? , 시작 점에서 해당점으로 가는 길이 존재할 경우 더 해봤자 커지기만 하니까 스킵
				
				//시작점에서 해당점(비용) = 시작점에서 현재점 + 1(=다음점으로 가는데 쓰는 비용)
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












