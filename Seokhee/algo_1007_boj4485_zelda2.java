import java.io.*;
import java.util.*;

public class algo_1007_boj4485_zelda2 {

	//백준 4485 녹색옷 입은 애가 젤다지?
	//다익스트라로 하겠습니다 죄송합니다
	static int[] dx = {1,0,0,-1};
	static int[] dy = {0,1,-1,0};
	
	static class Point implements Comparable<Point>{
		int x;
		int y;
		int cost;
		
		public Point(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) { //pq인데 작은게 앞으로 오도록 하자, 최솟값 찾기이므로
			return this.cost - o.cost; // this - o 면 오름차순(양수면 자리바꿈)
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cnt=1;
		while(true) {
			
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			
			
			int[][] map = new int[n][n];
			int[][] dist = new int[n][n];
			
			int INF = 0x3f3f3f3f; //무한
			
			//map
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = INF; //다 일단 넣어줌
				}
			}
			
			dist[0][0] = map[0][0]; //초기작업
			
			//= new PriorityQueue<Point>(); 에서 Point 꼭 쓰자!!!!!
			PriorityQueue<Point> pq = new PriorityQueue<Point>();
			pq.add(new Point(0,0,map[0][0]));
			
			while(!pq.isEmpty()) {
				Point p = pq.poll();
				
				for(int i=0;i<4;i++) { //4방탐색 bfs랑 동일하게 진행되지만 pq안에서 진행
					int nx = p.x+dx[i];
					int ny = p.y+dy[i];
					
					if(nx>=0 && ny>=0 && nx<n && ny<n) { //최솟값이 우선시되도록
						if(dist[nx][ny] > dist[p.x][p.y] + map[nx][ny]) {
							dist[nx][ny] = dist[p.x][p.y] + map[nx][ny];
							pq.add(new Point(nx,ny,dist[nx][ny]));
						}
					}
				}
			}
			
			//출력
			System.out.println("Problem "+cnt+": "+dist[n-1][n-1]);
			cnt++;
		}
	}

}
