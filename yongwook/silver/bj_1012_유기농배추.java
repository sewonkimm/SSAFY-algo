package sliver;

import java.util.Scanner;

public class bj_1012_유기농배추 {
		static int N, M,k ,result;
		static int map[][],visit[][];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt(); //테스트케이스
		
		 result = 0 ; //  흰배추ㅂ벌레
		
		for (int i = 0; i < t; i++) { //배열입력
			 M = sc.nextInt(); //배추밭크
			 N = sc.nextInt(); 
			 k = sc.nextInt(); //배추가심어진 개수
			 map = new int[N+1][M+1];
			visit = new int[N+1][M+1];
				
			result = 0;
			for (int j = 0; j < k; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				map[y][x] = 1;
			}
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					if(map[j][j2] == 1 && visit[j][j2]== 0) {
						dfs(j,j2);
						result++;
					}
						
				}			
			}
			System.out.println(result);
			
		}
		
		
	}
	
	public static void dfs(int x , int y) {
		visit[x][y]= 1; 
		int dx[] = {-1,1,0,0}; // 상하좌우
		int dy[] = {0,0,-1,1};
		
			for (int i = 0; i < 4; i++) {
				int nx = dx[i]+ x;
				int ny = dy[i]+ y;
				if(nx>=0 && ny >= 0 && nx< N && ny <M && visit[nx][ny]== 0 && map[nx][ny]==1 ) {
					dfs(nx,ny);
				}
			}
	}
}
