import java.util.*;
import java.io.*;

public class algo_1103_swex5643_orderOfHeight {

	static int n,m;
	static int cnt;
	static int answer;
	static int[][] height,reverseHeight;
	static boolean[] visited;
	static boolean[] reverseVisited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		//for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			//n = Integer.parseInt(br.readLine()); //학생 수
			//m = Integer.parseInt(br.readLine()); //키를 비교한 횟수3
			n = Integer.parseInt(st.nextToken()); //학생 수
			m = Integer.parseInt(st.nextToken()); //키를 비교한 횟수
			height = new int[n+1][n+1]; //0으로 초기화
			reverseHeight = new int[n+1][n+1]; //0으로 초기화
			
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				height[a][b] = 1;
				reverseHeight[b][a] = 1;
			}
			
			answer = 0;
			
			for(int i=1;i<=n;i++) {
				visited = new boolean[n+1];
				reverseVisited = new boolean[n+1];
				cnt = 0;
				dfs(i);
				reverseDfs(i);
				
				if(cnt == n+1) 
					answer++;
			}
			//System.out.println("#"+t+" "+answer);
			System.out.println(answer);
		}
	//}
	static void dfs(int num) {
		cnt++;
		visited[num] = true;
		for(int i=1;i<=n;i++) {
			if(!visited[i] && height[num][i] == 1)
				dfs(i);
		}
	}
	static void reverseDfs(int num) {
		cnt++;
		reverseVisited[num] = true;
		for(int i=1;i<=n;i++) {
			if(!reverseVisited[i] && reverseHeight[num][i] == 1)
				reverseDfs(i);
		}
	}
}
