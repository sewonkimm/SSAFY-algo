package com.ssafy;
import java.util.*;
import java.io.*;

public class CrashWallTest {

	static int n,m;
	static int[][] map;
	static int[][][] checked; //방문한 곳 1 / 벽 부순횟수 추가
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int cnt; //0
	static int min = 10000;

	static class Point{
		int x;
		int y;
		int crashCnt;
		int turn;
		
		public Point(int x, int y, int crashCnt,int turn) {
			super();
			this.x = x;
			this.y = y;
			this.crashCnt = crashCnt;
			this.turn = turn;
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);  
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		checked = new int[n][m][3];
		for(int i=0;i<n;i++) {
			String line = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		bfs();

		if(min == 10000) {
			System.out.println(-1);
			return;
		}
		System.out.println(min);
	}
	public static void bfs() {
		Queue<Point> queue = new LinkedList<Point>();
		
		queue.offer(new Point(0,0,0,1));
		checked[0][0][0] = 1;
		
		Point p;
		while(!queue.isEmpty()) {
			p = queue.poll();
			//System.out.println(p.x+" "+p.y+" "+p.crashCnt+" "+p.turn);
			checked[p.x][p.y][p.crashCnt] = 1;
			
			if(p.x == n-1 && p.y ==m-1 && p.crashCnt <= 1) {
				if(p.turn<min)
					min = p.turn;
				queue.clear();
				break;
			}
			
			for(int i=0;i<4;i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny<m) {
					
					if(map[nx][ny]==1 && checked[nx][ny][p.crashCnt+1] == 0 && p.crashCnt+1 <=1) {
						int nCnt = p.crashCnt+1;
						if(nCnt<=1) {
							queue.offer(new Point(nx,ny,nCnt,p.turn+1));
							checked[nx][ny][nCnt] = 1;
						}
					}
					else if(map[nx][ny]==0 && checked[nx][ny][p.crashCnt] ==0){
						int nCnt = p.crashCnt;
						if(nCnt<=1) {
							queue.offer(new Point(nx,ny,nCnt,p.turn+1));
							checked[nx][ny][nCnt] = 1;
						}
					}
					
					
				}
			}
			
			
		}
	}
}
