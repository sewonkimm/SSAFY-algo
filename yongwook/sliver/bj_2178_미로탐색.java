package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
	
public class bj_2178_미로탐색 {
	static int N ,M;
	static int map[][];
	static int visit[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new int[N][M];
		// 미로입력
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j]= input.charAt(j)-'0';
			}
		}
		
		// bfs
		bfs(0,0);
		System.out.println(map[N-1][M-1]);
	}
	public static void bfs(int x, int y) {
		visit[x][y] = 1;
		Queue<Point> queue = new LinkedList<Point>();
		
		queue.add(new Point(x,y));
		while(!queue.isEmpty()) {
			Point temp = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = dx[i]+ temp.x;
				int ny = dy[i]+ temp.y;
				if(nx>=0 && ny >=0 && nx<N && ny<M && map[nx][ny]==1 && visit[nx][ny]==0) {
					queue.add(new Point(nx,ny));
					map[nx][ny] = map[temp.x][temp.y]+1;
					visit[nx][ny] = 1;
				}
			}
		}
		
	}
	
	

	
}
class Point{
	int x;
	int y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
