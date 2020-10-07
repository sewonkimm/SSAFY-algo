import java.io.*;
import java.util.*;
public class algo_1006_boj2583_howManyArea {

	static int m,n,k;
	static int countArea;
	static int count;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] map;
	
	//백준 2583 영역구하기 
	//bfs를 활용해서 풀고 사각형 부분은 true로 만들어줘서 마치 방문한 것처럼 사용하자
	//0,0이 좌측 하단이고 직사각형의 대각선 양끝점이 주어지지만 평소하던대로 풀어도 상관없다
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());//높이
		n = Integer.parseInt(st.nextToken());//가로
		k = Integer.parseInt(st.nextToken());//직사각형 개수
		
		map = new boolean[m][n];
		
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			int ly = Integer.parseInt(st.nextToken());
			int lx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			
			for(int x=lx;x<rx;x++) {
				for(int y=ly;y<ry;y++) {
					map[x][y] = true;
				}
			}
		}
		
		List<Integer> list = new ArrayList<>();
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j] == false) {
					countArea = 0;
					count++;
					dfs(i,j);
					list.add(countArea);
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(count);
		
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
		
	}
	static void dfs(int a,int b) {
		map[a][b] = true;
		countArea++;
		
		for(int i=0;i<4;i++) {
			int nx = a+dx[i];
			int ny = b+dy[i];
			
			if(nx>=0 && ny>=0 && nx<m && ny<n) {
				if(map[nx][ny] == false) {
					dfs(nx,ny);
				}
			}
		}
	}

}
