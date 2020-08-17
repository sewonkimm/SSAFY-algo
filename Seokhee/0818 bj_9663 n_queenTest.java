import java.util.*;
public class n_queenTest {

	static int[][] map; //0 초기화
	static int n;
	static int cnt;
	static int[] dx = {-1,1,0,0,-1,-1,1,1};
	static int[] dy = {0,0,-1,1,-1,1,-1,1}; //상하좌우 좌상 우상 좌하 우하
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
	
		dfs(0);
		System.out.println(cnt);

	}

	static void dfs(int q) {
		if(q == n) {
			cnt++;

			return;
		}

		for(int j=0;j<n;j++) {
			if(queenCheck(q,j) && (map[q][j] == 0)) {
				map[q][j] = 1;
				dfs(q+1);
				map[q][j] = 0;
			}
		}
		
		
	}
	
	static boolean queenCheck(int x,int y) {	
		for(int i=0;i<8;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			while(nx>=0 && ny>=0 && nx<n && ny<n) {

				if(map[nx][ny] == 1) {
					return false;
				}
				nx += dx[i];
				ny += dy[i];
			}
		}
		return true;
	}
}
