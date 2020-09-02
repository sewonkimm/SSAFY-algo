import java.io.*;
import java.util.*;
public class CabbageTest {
	//<스터디과제>
	//유기농배추 백준 1012번 dfs인듯? dfs가 실행될 때마다 cnt를 1씩 증가시키자(=새로운 배추무리)
	static int T;
	static int m,n,k;
	static int[][] map; //map하나만 쓰고 해보자
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = { 0, 0,-1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine()," ");
			
			m = Integer.parseInt(st.nextToken()); //가로, 너비
			n = Integer.parseInt(st.nextToken()); //세로, 높이
			k = Integer.parseInt(st.nextToken()); //배추개수
			
			map = new int[n][m];
			
			for(int i=0;i<k;i++) {
				st = new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			int cnt=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j] == 1) {
						cnt++;
						dfs(i,j);
					}
				}
			}
			System.out.println(cnt);
		}
	}
	static void dfs(int x,int y) { //visited을 안쓰려고 2로 바꿨다, 0으로 바꿔도될듯
		map[x][y] = 2;
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && ny>=0 && nx<n && ny<m) {
				if(map[nx][ny] == 1)
					dfs(nx,ny);
			}
		}
	}
}
