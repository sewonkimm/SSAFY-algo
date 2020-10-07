
import java.io.*;
import java.util.*;

public class algo_1007_boj7569_tomato {

	//백준 7569 토마토
	//bfs인데 4방탐색에서 6방탐색으로 늘어남
	//헷갈릴까봐 그냥 dh를 두고 높이 이동은 2칸짜리 배열을 추가로 뒀다.
	static int m,n,h;
	static int[][][] map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[] dh = {1,-1};
	static int day;
	static Queue<Point> queue = new LinkedList<>();
	
	static class Point{
		int x;
		int y;
		int h;
		int cnt;
		public Point(int x, int y, int h, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.h = h;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[m][n][h];
		
		for(int i=0;i<h;i++) {
			for(int j=0;j<n;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<m;k++) {
					map[k][j][i] = Integer.parseInt(st.nextToken());
					if(map[k][j][i] == 1) { //여기서 바로 큐에 투입
						queue.add(new Point(k,j,i,0));
					}
				}
			}
		}
		
		bfs();
		System.out.println(day); //날짜 출력
	}
	static void bfs() {
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for(int i=0;i<4;i++) { //4방탐색, 높이는 변화없으므로 볼 필요없음
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				int nh = p.h;
				if(nx>=0 && ny>=0 && nx<m && ny<n) { 
					if(map[nx][ny][nh] == 0) {
						map[nx][ny][nh] = 1;
						queue.add(new Point(nx,ny,nh,p.cnt+1));
						if(day<p.cnt+1) //바뀐 토마토를 기준으로 날짜를 세자
							day = p.cnt+1;
					}
				}
			}
			for(int i=0;i<2;i++) { //2방탐색, 높이만 변하므로 높이만 보자
				int nx = p.x;
				int ny = p.y;
				int nh = p.h + dh[i];
				if(nh>=0 && nh<h) {
					if(map[nx][ny][nh] == 0) {
						map[nx][ny][nh] = 1;
						queue.add(new Point(nx,ny,nh,p.cnt+1));
						if(day<p.cnt+1) //바뀐 토마토를 기준으로 날짜를 세자
							day = p.cnt+1;
					}
				}
			}
		}
		
		//0이 존재하면 안바뀐 토마토가 있는 것 = 실패 = -1 출력
		for(int i=0;i<h;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<m;k++) {
					if(map[k][j][i] == 0) {
						day = -1;
					}
				}
			}
		}
		
	}

}
