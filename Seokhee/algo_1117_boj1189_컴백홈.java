import java.util.*;
import java.io.*;

public class algo_1117_boj1189_컴백홈 {
	
	static int R,C,K;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] visited;
	static char[][] map;
	static int dist;
	static int totalCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); //높이
		C = Integer.parseInt(st.nextToken()); //가로
		K = Integer.parseInt(st.nextToken()); //거리
		
		map = new char[R][C]; //
		visited = new boolean[R][C]; //false
		
		for(int i=0;i<R;i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
		}
		
		visited[R-1][0] = true;
		dfs(R-1,0,0);
		
		System.out.println(totalCnt);
	}
	static void dfs(int x, int y, int distNow) {
		if(x == 0 && y == C-1) {
			if(distNow == K-1) {
				totalCnt++;
			}
			return;
		}
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && ny>=0 && nx<R && ny<C && map[nx][ny] != 'T' && !visited[nx][ny]) {
				visited[nx][ny] = true;
				distNow++;
				dfs(nx,ny,distNow);
				visited[nx][ny] = false;
				distNow--;
			}
		}
	}
	
}