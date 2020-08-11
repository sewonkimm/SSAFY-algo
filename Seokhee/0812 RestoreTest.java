package com.ssafy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RestoreTest {

	//벽부수기와 매우 흡사하게 진행됩니다. 
	final static int MAX = Integer.MAX_VALUE;
	static int[][] map;
	static int[][][] checked; //몇번 메꾸고 도착했는가? 까지 담자 처음에는 0 , 도착하면 1
	
	static int[] dx = {-1,1,0,0}; //상하좌우
	static int[] dy = {0,0,-1,1};

	static int n; 
	static int min;
	
	//좌표를 담아둘 클래스, 우선순위큐의 조건을 바꿔주기위해 implements Comparable
	static public class Point implements Comparable<Point>{
		int x;
		int y;
		int res; //얼마나 땅을 메꾸면서 x,y점에 도달했는가
		
		public Point(int x,int y,int res){
			this.x = x;
			this.y = y;
			this.res = res;
		}

		//res에 따라서 정렬시켜서 최대한 적게 메꾸면서 도착한 애들 우선적으로 큐에서 나갈수 있도록 (이미 줄이도록 노력했지만 더욱더 계산량을 줄이기위해서)
		@Override
		public int compareTo(Point o) {
			return this.res - o.res;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			n = Integer.parseInt(br.readLine());
			
			map = new int[n][n];
			checked = new int[n][n][1000];
			
			for(int i=0;i<n;i++) {
				String st = new String(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j] = st.charAt(j)-'0';
				}
			}

			//min을 최대로 놓고 bfs시작
			min = MAX;
			bfs();
			System.out.println("#"+t+" "+min);
		}
		
		
	}

	static void bfs() {
		//Queue<Point> queue = new LinkedList<Point>();	

		//우선순위큐를 하나 제작합니다 여기에 들어간 녀석들은 restore가 작은 순서대로 앞에서 자동정렬 됩니다(우선순위큐의 정렬속도는 퀵소트의 속도로 매우 빠릅니다)
		PriorityQueue<Point> queue = new PriorityQueue<Point>();
		queue.add(new Point(0,0,0));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			checked[p.x][p.y][p.res] = 1; //x점 y점에 res만큼 땅을 메꾸면서 왔다 방문체크 
			
			//System.out.println(p.x+" "+p.y+" "+p.res);
			
			if(p.x == n-1 && p.y == n-1) {
				if(min>p.res)   //우측아래 끝점에 도착시 min과 비교
					min = p.res;
			}
			else {
				for(int i=0;i<4;i++) {
					int nx = p.x+dx[i];
					int ny = p.y+dy[i]; //전형적인 상하좌우 탐색
					if(nx>=0 && ny>=0 && nx<n && ny<n) { //전형적인 상하좌우 조건
						int restore = p.res + map[nx][ny]; //앞으로 갈 곳에서 메꿔야할 땅 + 현재 메꾼 양
						for(int j=restore;j>=0;j--) { //이거보다 덜메꾸고 이 점에 도착한 적이 있니?
							if(checked[nx][ny][j] == 1) { //있으면 for문 종료
								j = -1;
							}
							if(j == 0) { //없다면 offer
								queue.offer(new Point(nx,ny,restore));
								checked[nx][ny][restore] = 1; //하고 해당점 방문체크 
							}
						}
					}
				}
			}
		}
	}
	
}
