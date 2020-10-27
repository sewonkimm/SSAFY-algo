import java.io.*;
import java.util.*;

public class algo_1021_boj1600_monkeyHorse {

	//백준 말숭이 
	//k번만 말처럼 움직이기 가능
	static int k;
	static int w,h; //가로, 세로
	static int totalCnt;
	static int[][] map;
	static int[][][] visited;
	static int[] hx = {2,1,-1,-2,1,2,-2,-1};
	static int[] hy = {1,2,-2,-1,-2,-1,1,2};
	static int[] mx = {1,-1,0,0};
	static int[] my = {0,0,1,-1};
	static class Point{
		int x;
		int y;
		int k;
		int cnt;
		public Point(int x, int y, int k, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		visited = new int[h][w][31]; //초기조건 0, k(~30)번까지 말 행동 가능
		for(int i=0;i<h;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<w;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		totalCnt = -1;
		bfs();
		System.out.println(totalCnt);
	}
	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0,0,0,0));
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			if(p.x == h-1 && p.y == w-1) {
				totalCnt = p.cnt;
				queue.clear();
				return;
			}
			int nx,ny;
			
			if(p.k<k) { //말 행동 가능한 경우
				for(int i=0;i<8;i++) {
					int flag = 0;
					nx = p.x + hx[i];
					ny = p.y + hy[i];
					if(nx>=0 && ny>=0 && nx<h && ny<w) {
						if(map[nx][ny] == 0) {
							for(int j=1;j<=p.k+1;j++) {
								if(visited[nx][ny][j] == 1) {
									flag = 1;
									break;
								}	
							}
							if(flag == 0) {
								queue.add(new Point(nx,ny,p.k+1,p.cnt+1));
								visited[nx][ny][p.k+1] = 1;
							}
						}
					}
				}
			}
			for(int i=0;i<4;i++) { //원숭이 행동은 항상 가능함
				int flag = 0;
				nx = p.x + mx[i];
				ny = p.y + my[i];
				if(nx>=0 && ny>=0 && nx<h && ny<w) {
					if(map[nx][ny] == 0) {
						for(int j=0;j<=p.k;j++) {
							if(visited[nx][ny][j] == 1) {
								flag = 1;
								break;
							}	
						}
						if(flag == 0) {
							queue.add(new Point(nx,ny,p.k,p.cnt+1));
							visited[nx][ny][p.k] = 1;
						}
					}
				}
			}
		}
	}
}
