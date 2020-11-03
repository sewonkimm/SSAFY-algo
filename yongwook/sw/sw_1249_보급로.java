package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class sw_1249_보급로 {
	private static int[][] map;
	private static int N;
	private static int dx[] = {-1,1,0,0};// 상하
	private static int dy[] = {0,0,-1,1}; //좌우
	private static boolean[][] visit;
	private static int[][] min ;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		
		
		for (int T = 1; T <= tc; T++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visit = new boolean[N][N];
			min = new int[N][N];
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) -'0';
					min[i][j] = Integer.MAX_VALUE;	
				}
			}

			min[0][0]=0;
		
			bfs(0,0);

			System.out.println("#"+T+" "+min[N-1][N-1]);
		}
	}

	private static void bfs(int x, int y ) {


		Queue<Point> q = new LinkedList<Point>();	
		q.add(new Point(x,y));
		
		while(!q.isEmpty()) {
			Point temp = q.poll();
			//visit[temp.x][temp.y] = true;
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + temp.x;
				int ny = dy[i] + temp.y;
				if(nx <0 || nx>= N ||  ny<0 || ny>=N || visit[nx][ny] == true ) {
					continue;
				}else {
					int minnumber = map[nx][ny]+min[temp.x][temp.y];
				
					if(min[nx][ny] > minnumber) {
						min[nx][ny] = minnumber;
						q.add(new Point(nx,ny));
						
					}

				}

			}
		}
	}

	public static class Point{
		int x;
		int y;
			Point(int x, int y){
			this.x  = x;
			this.y = y;
		
		}
	}
}
