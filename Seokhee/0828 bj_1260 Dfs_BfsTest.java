import java.io.*;
import java.util.*;

public class Dfs_BfsTest {
	//<스터디과제>
	//백준 1260 dfs와 bfs
	//여기서 그래프는 무향그래프이다, 간선 입력 시 양 방향 다 연결해주자.
	static int n;
	static int m;
	static int v;
	static int[][] graph;
	static int[] visited; //0
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		graph = new int[n+1][n+1];
		
		//StringBuilder를 활용하자
		
		int x,y;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			graph[x][y] = graph[y][x] = 1; //양방향
		}
		//dfs
		sb = new StringBuilder("");
		visited = new int[n+1];
		sb.append(v+" ");
		visited[v] = 1;
		dfs(v);
		System.out.println(sb.toString());
		//bfs
		sb = new StringBuilder("");
		visited = new int[n+1];
		sb.append(v+" ");
		visited[v] = 1;
		bfs(v);
		System.out.println(sb.toString());
	}
	
	static void dfs(int s) {
		for(int i=1;i<=n;i++) {
			if(graph[s][i] == 1 && visited[i] == 0) {
				visited[i] = 1;
				sb.append(i+" ");
				dfs(i);
			}
		}
	}
	static void bfs(int s) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			for(int i=1;i<=n;i++) {
				if(graph[num][i] == 1 && visited[i] == 0) {
					visited[i] = 1;
					sb.append(i+" ");
					queue.add(i);
				}
			}
		}
	}
}












