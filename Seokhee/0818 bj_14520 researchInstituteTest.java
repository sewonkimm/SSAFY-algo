import java.io.*;
import java.util.*;

public class researchInstituteTest {
	static int[][] ins; //연구소
	static int[][] copy;
	static int N; //세로 (높이 -x)
	static int M; //가로 (너비 -y)
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	//static int wall = 0; //'반드시' 3개 세우자
	static Queue<Virus> queue;
	static Queue<Virus> copyQ;
	static int max;
	static int cnt;
	static class Virus{
		int x;
		int y;
		public Virus(int x,int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] lines;
		lines = br.readLine().split(" ");
		N = Integer.parseInt(lines[0]);
		M = Integer.parseInt(lines[1]);
		ins = new int[N][M];
		copy = new int[N][M];
		max = 0;
		StringTokenizer st;
		queue = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				copy[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		dfs(0);
		System.out.println(max);
	}
	static void copyMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ins[i][j] = copy[i][j];
                if(copy[i][j] == 2) {
                	queue.offer(new Virus(i,j));
                }
            }
        }
	}
	static void dfs(int w) { //벽 생성
		if(w == 3) {
			copyMap();
			bfs();
			if(max<cnt)
				max = cnt;
			return;
		}
		//기본적인 백트래킹
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copy[i][j] == 0) {
					copy[i][j] = 1;
					dfs(w+1);
					copy[i][j] = 0;
				}
			}
		}
	}
	static void bfs() { //바이러스번식
		while(!queue.isEmpty()) {
			Virus v = queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = v.x+dx[i];
				int ny = v.y+dy[i];
				if(nx>=0 && ny>=0 && nx<N && ny<M) {
					if(ins[nx][ny] == 0) {
						ins[nx][ny] = 2;
						queue.offer(new Virus(nx,ny));
					}
				}
			}
		}
		cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(ins[i][j] == 0)
					cnt++;
			}
		}

	}
}
