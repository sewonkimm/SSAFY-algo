package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_3184_양 {
	static int N,M, wolf,amount;
	static int result[]= new int[2];
	static char map[][];
	static int visit[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visit = new int[N][M];
		String input = null;
		//배열생성
		for (int i = 0; i < N; i++) {
			input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j]= input.charAt(j); 
			}
		}
		//알고리즘
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visit[i][j]==0 && map[i][j] != '#') {
					dfs(i,j);
					if(wolf<amount) {
						wolf = 0;
						result[0]+= amount;
						amount = 0;
					}else {
						amount = 0;
						result[1]+= wolf;
						wolf = 0;
					}
				}
			}
		}
		System.out.println(result[0]+" "+result[1]);
	}
	private static void dfs(int x ,int y) {
		
		visit[x][y] = 1;
		if(map[x][y]== 'v') {
			wolf++;
			
		}
		if(map[x][y]== 'o') {
			amount++;
		}
		for (int i = 0; i < 4; i++) {
			int nx = dx[i]+x;
			int ny = dy[i]+y;
			if(nx>=0 && ny>=0 && nx<N && ny<M && visit[nx][ny]== 0  && map[nx][ny] !='#' ) {
				dfs(nx,ny);
			}
		}
	}
}


