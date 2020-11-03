package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1600_말이되고픈원숭이 {
	private static int W;
	private static int H;
	private static int[][] map;
	private static boolean[][][] visit;
	private static int dx[] = {-1, 1,  0, 0,-1,-2,-1,-2, 1, 2,1,2};  // 상하좌우  좌상 좌상  우상 우상 좌하 좌하 우하우하 
	private static int dy[] = { 0, 0, -1, 1,-2,-1, 2, 1,-2,-1,2,1};
	private static int K;
	public static void main(String[] args) throws Exception{


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		K = Integer.parseInt(br.readLine());



		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		visit= new boolean[H][W][K+1];
		map = new int[H][W];


		for (int j = 0; j < H; j++) {
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < W; k++) {
				map[j][k] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		for (int i = 0; i < K; i++) {
			visit[0][0][i]= true;
		}
		System.out.println(bfs());
	}

	private static int bfs() {


		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(0,0,0));
		visit[0][0][0] = true;
		int result =0;
		while(!q.isEmpty()) {
			int a = q.size();
			for (int k = 0; k <a ; k++) {
				Point temp = q.poll();
				if(temp.x == H-1 && temp.y == W-1) return result;

				for (int i = 0; i < 12; i++) {
					int nx = temp.x + dx[i];
					int ny = temp.y + dy[i];

					if(nx>=0 && ny>=0 && nx<H && ny <W  && map[nx][ny] == 0) {
						if( i<4 ) {
							if(visit[nx][ny][temp.cnt] == false) {
								q.add(new Point(nx,ny,temp.cnt));
								visit[nx][ny][temp.cnt] = true;
							}
						}
						else { 
							if( temp.cnt+1 <= K && visit[nx][ny][temp.cnt+1] == false ) {
								q.add(new Point(nx,ny,temp.cnt+1));
								visit[nx][ny][temp.cnt+1] = true;
							}
						}


					}
					
				}

			}
			result++;
		}
		return -1;
	}	
}
class Point {
	int x ;
	int y ;
	int cnt ;
	public Point(int x , int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

