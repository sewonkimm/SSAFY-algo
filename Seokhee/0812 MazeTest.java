import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MazeTest {

	static int[][] map;
	//static int[][] checked;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int flag=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1;t<=10;t++) {
			int T=Integer.parseInt(br.readLine());
			
			map = new int[16][16];
			//checked = new int[16][16];
			
			for(int i=0;i<16;i++) {
				String st = br.readLine();
				for(int j=0;j<16;j++) {
					map[i][j] = st.charAt(j)-'0';
				}
			}
	
			
			dfs(1,1);
			if(flag == 1)
				System.out.println("#"+t+" "+1);
			else System.out.println("#"+t+" "+0);
			flag = 0;
		}

	}
	
	static void dfs(int x,int y) {
		if(map[x][y] == 3) {
			flag=1;
			return;
		}
		map[x][y] = 1;
		//checked[x][y] = 1;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0 && ny>=0 && nx<16 && ny<16) {
				if(map[nx][ny] == 0 || map[nx][ny] == 3) {
					dfs(nx,ny);
				}
			}
		}
	}

}
