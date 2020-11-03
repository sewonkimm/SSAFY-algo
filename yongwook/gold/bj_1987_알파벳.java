package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj_1987_알파벳 {
	static char map[][] ;
	static boolean visit[] = new boolean[26];//알파벳 방문자
//	static ArrayList<Character> arr = new ArrayList<Character>();// 알파벳 담는 배열
	static int result =1; // 최종 이동칸수
	static int cnt =1; // 이동칸수
	static int R,C;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 R = Integer.parseInt(st.nextToken());
		 C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j]= input.charAt(j); 
			}
			
		}
		check(0,0);
		System.out.println(result);
		
	}
	
	public static void check(int x, int y) {
		visit[map[x][y]- 65]= true;
		int dx[] = {-1,1,0,0};//상하좌우
		int dy[] = {0,0,-1,1};
		
			for (int i = 0; i < 4; i++) {
				int nx = dx[i]+x;
				int ny = dy[i]+y;
				
				if(nx>=0 && ny>= 0 && nx<R && ny<C && visit[map[nx][ny]-65]!= true ) {
					++cnt;
					if(result < cnt)
						result = cnt;
					check(nx,ny);
				}
				
			}
			 cnt--;
		     visit[map[x][y]-65] = false;
	}
}
