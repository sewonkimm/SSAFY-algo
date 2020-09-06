import java.io.*;
import java.util.*;
public class boj3184_0906_sheepTest {

	//백준 0906 양
	//dfs로 섬찾기를 하듯이 찾고 안에서 자체적으로 계산을 마친뒤에 그 값을 전역변수에 더해주는 식으로 풀겠다.
	static int r,c;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int sheep,wolf;
	static int totalSheep,totalWolf;
	static int[][] checked; //0->1
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		String s;
		
		map = new char[r][c];
		checked = new int[r][c];
		
		for(int i=0;i<r;i++) {
			s =br.readLine();
			for(int j=0;j<c;j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == '#')
					checked[i][j] = 1; //벽은 이미 방문 한 것으로 처리
			}
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(checked[i][j] == 0) { //방문 안한곳에서 dfs 시작
					sheep = 0; wolf = 0;
					
					dfs(i,j); 

					if(sheep<=wolf) //늑대 승리
						sheep = 0;
					else if(sheep>wolf) //양 승리
						wolf = 0;
					
					//더해주기
					totalSheep += sheep;
					totalWolf += wolf;
				}
			}
		}
		System.out.println(totalSheep+" "+totalWolf);
	}
	private static void dfs(int x, int y) {
		
		checked[x][y] = 1; //방문한 것으로 처리
		if(map[x][y] == 'v')  wolf++;
		else if(map[x][y] == 'o') sheep++;
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0 && ny>=0 && nx<r && ny<c) { 
				if(checked[nx][ny] == 0) 
					dfs(nx,ny);			
			}
		}
	}
	

}
