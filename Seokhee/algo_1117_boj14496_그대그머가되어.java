import java.io.*;
import java.util.*;

public class algo_1117_boj14496_그대그머가되어 {
	static int source, target;
	static int n,m;
	static int[][] map;
	static int answer = -1;
	//static boolean[][] visited;
	static boolean[] visited;
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		source = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][n+1];
		//visited = new boolean[n+1][n+1];
		visited = new boolean[n+1];
		
		int a=0,b=0;
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken()); 
			map[a][b] = map[b][a] = 1;
			
			if(a == source) {
				queue.add(new int[] {b,1});
				visited[b] = true;
			}
			if(b == source) {
				queue.add(new int[] {a,1});
				visited[a] = true;
			}
		}
		if(source!=target)
			bfs();
		else answer = 0;
		
		System.out.println(answer);
	}
	static void bfs() {
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			if(now[0] == target) {
				answer = now[1];
				return;
			}
			for(int i=1;i<=n;i++) {
				if(map[now[0]][i] == 1 && visited[i] == false) {
					//visited[now[0]][i] = true;
					visited[i] = true;
					queue.add(new int[] {i,now[1]+1});
				}
			}
		}
	}
}
