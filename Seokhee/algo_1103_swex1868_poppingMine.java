import java.util.*;
import java.io.*;

public class algo_1103_swex1868_poppingMine {

	static int n;
	static int[] dx = {-1,-1,-1,   0, 0,   1, 1, 1};
	static int[] dy = {-1, 0, 1,  -1, 1,  -1, 0, 1};
	static char[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			n = Integer.parseInt(br.readLine());
			map = new char[n][n];  // '*' or '.'
			visited = new boolean[n][n]; //false
			for(int i=0;i<n;i++) {
				String s = br.readLine();
				map[i] = s.toCharArray();
			}
			
			//두번에 걸쳐서 하는게 중요할듯??
			//1. 8방이 지뢰가 없는 곳으로 n*n돌기
			//2. 그다음에 다시 나머지처리
			int answer = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(check(i,j) == true && visited[i][j] == false && map[i][j] == '.') {
						answer++;
						dfs(i,j);
					}
				}
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j] == '.' && visited[i][j] == false) {
						visited[i][j] = true;
						answer++;
					}
				}
			}
			
			
			System.out.println("#"+t+" "+answer);
		}
	}
	static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i=0;i<8;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && ny>=0 && nx<n && ny<n && map[nx][ny] == '.') {
				if(check(nx,ny) == true && visited[nx][ny] == false && map[nx][ny] == '.') {
					dfs(nx,ny);
				}
				visited[nx][ny] = true;
			}
		}
	}
	static boolean check(int x,int y) {
		if(map[x][y] == '*') return false;
		for(int i=0;i<8;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && ny>=0 && nx<n && ny<n) {
				if(map[nx][ny] == '*') {
					return false;
				}
			}
		}
		return true;
	}
}
