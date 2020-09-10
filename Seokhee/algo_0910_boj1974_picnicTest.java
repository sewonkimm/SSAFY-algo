import java.util.*;
import java.io.*;
public class algo_0910_boj1974_picnicTest {
	//백준 1974 여행가자
	
	//dp로 해당 마을에서 다른 마을에 갈 수 있는 길이 있는지 (어디를 거쳤든)체크를 해서 두번 계산 안하기로 하면 편할듯
	//그 길을 거치는 과정에서 찾은 길을 다 dp에 길이 있다고 넣어주자
	//(1->3 과정에서 1->2->3 의 길이 있을 경우 2->3과 1->2도 길이 있다고 저장)
	static int n; //~200
	static int m; //~1000
	static int[][] link;
	static int[] plan;
	static boolean[] check; //방문여부
	static int[][] dp;
	static int flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		link = new int[n+1][n+1];
		plan = new int[m];//계획
		dp = new int[n+1][n+1];
		StringTokenizer st;
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=n;j++) {
				link[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1;i<=n;i++) {
			Arrays.fill(dp[i], -1); //-1의 의미 시도를 안해봐서 길이 있는지 모르겠다-> 시도해보라는 뜻!!
			//시도해서 없을 경우 0을 넣어주고 있을 경우 1을 넣어 줄 것.
			dp[i][i] = 1;
		}
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<m;i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}
		flag = 0;
		for(int i=0;i<m-1;i++) {
			if(dp[plan[i]][plan[i+1]]==-1) //길이 없다면
				bfs(plan[i],plan[i+1]);
			if(flag == 1) {
				System.out.println("NO");
				return;		
			}	
		}
		System.out.println("YES");
	}

	private static void bfs(int start, int end) {
		if(dp[start][end] == 1)
			return;
		else if(dp[start][end] == 0) {
			flag = 1;
			return;
		}
		Queue<int[]>queue = new LinkedList<>();
		for(int i=1;i<=n;i++) {
			if(dp[start][i] == -1 && link[start][i] == 1) {
				dp[start][i] = 1;
				queue.add(new int[] {start, i});		
			}
		}
		
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			for(int i=1;i<=n;i++) {
				if(i==arr[0] | link[arr[1]][i] == 0) continue;
				if(dp[arr[1]][i] == -1 && link[arr[1]][i] == 1) {
					dp[start][i] = 1;
					dp[arr[1]][i] = 1;
					queue.add(new int[] {arr[1], i});		
				}	
			}
		}
		for(int i=1;i<=n;i++) {
			if(dp[start][i] != 1) {
				dp[start][i] = 0;
			}
		}
		if(dp[start][end] == 1)
			return;
		else flag = 1;
	}
}
