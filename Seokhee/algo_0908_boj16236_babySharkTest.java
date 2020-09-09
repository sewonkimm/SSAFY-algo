import java.io.*;
import java.util.*;
public class algo_0907_boj16236_babySharkTest {

	//백준 16236 아기상어
	//bfs써야할 듯, 상좌 하우 탐색하면서 물고기를 제일 빨리 
	//어렵당
	static int n;
	static int sx,sy;
	static int eat;
	static int[] nowFish;
	static int[][] map;
	static int[][] visited;
	static int past;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,-0,1};
	static Queue<BabyShark> queue = new LinkedList<>();
	static class BabyShark{
		int x;
		int y;
		int cnt;
		int nowSize;
		public BabyShark(int x, int y, int cnt, int nowSize) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.nowSize = nowSize;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new int[n][n];
		nowFish = new int[7]; //1~6 살아있는 개수
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					map[i][j] = 0;
					sx=i; sy=j; //시작위치
				}
				else if(map[i][j] != 0) nowFish[map[i][j]]++;
			}
		}		

		queue.add(new BabyShark(sx,sy,0,2));
		bfs();
	}
	
	static void bfs() {
		for(int i=0;i<n;i++) {
			Arrays.fill(visited[i], 0);
		}
		
		while(!queue.isEmpty()) {
			BabyShark b = queue.poll();
			int flag = 0;
			for(int i=1;i<7;i++) {
				if(nowFish[i] == 0)
					continue;
				flag = 1;	
			}
			if(flag==0) {
				System.out.println(b.cnt);
				return;
			}			
			int nx,ny;
			for(int i=0;i<4;i++) {
				nx = b.x + dx[i];
				ny = b.y + dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny<n) {
					if(visited[nx][ny] == 0 && b.nowSize >= map[nx][ny]) {
						if(map[nx][ny] !=0 && b.nowSize > map[nx][ny]) {
							//System.out.println(map[nx][ny]);
							eat++;
							if(eat == b.nowSize) {
								eat = 0;
								b.nowSize++;
							}
							nowFish[map[nx][ny]]--;
							map[nx][ny] = 0;
							queue.clear();
							queue.add(new BabyShark(nx,ny,b.cnt+1,b.nowSize));
							visited[b.x][b.y] = 1; 
							past = b.cnt+1;
							bfs();
							return;
						}
						visited[b.x][b.y] = 1; 
						queue.add(new BabyShark(nx,ny,b.cnt+1,b.nowSize));
					}
				}
			}
		}
		System.out.println(past);
		return;
	}
}
















