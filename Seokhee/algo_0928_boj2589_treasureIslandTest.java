import java.io.*;
import java.util.*;

public class algo_0928_boj2589_treasureIslandTest {

	//백준 2589 보물섬
	//bfs고 갔던 곳도 또 가야될 것같음, check를 쓰겠지만 점 옮길때마다 다시 0으로 초기화시켜주던지, 새로 배열을 선언하던지 해야할듯?
	static int w; //가로 = 너비
	static int h; //세로 = 높이
	static int max;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static char[][] map;
	static Queue<Point> queue;
	static class Point{
		int x;
		int y;
		int dist;
		public Point(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		map = new char[h][w];
		
		String s;
		for(int i=0;i<h;i++) { //문자라 편하게 toCharArray로 넣고
			s = br.readLine();
			map[i] = s.toCharArray();
		}
		
		for(int i=0;i<h;i++) { //L인곳에서 시작하면 됨, 갔던 곳도 해야함
			for(int j=0;j<w;j++) {
				if(map[i][j] == 'L') {
					bfs(i,j);
				}
			}
		}
		
		System.out.println(max);
		
	}
	
	static void bfs(int x, int y) {
		queue = new LinkedList<Point>();
		queue.add(new Point(x,y,0));
		
		boolean[][] check = new boolean[h][w]; //false 초기화, 선언하는 방식으로 초기화 쉽게 하자
		check[x][y] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			if(max < p.dist) //가는곳마다 p와 그 점사이의 최단거리이므로  돌아갔는지 여부는 알 필요없고 그냥 비교
				max = p.dist;
			
			for(int i=0;i<4;i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(nx>=0 && ny>=0 && nx<h && ny<w) {
					if(map[nx][ny] == 'L' && check[nx][ny] == false) {
						check[nx][ny] = true;
						queue.add(new Point(nx,ny,p.dist+1));
					}
				}
			}
			
		}
	}

}
