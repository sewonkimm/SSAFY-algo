package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_2667_단지번호붙이기 {
	static int N,homenumber, complexnumber;
	static int result[];
	static int visit[][],map[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};

	public static void main(String[] args) throws NumberFormatException, IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		result = new int[N*N];
		visit = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			String input = br.readLine();
			for (int j = 0; j < map.length; j++) {
				map[i][j] = input.charAt(j)-'0';
			}
		}

		int cnt =0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j]==1 & visit[i][j] == 0) {
					dfs(i, j);
					complexnumber++;
					result[cnt++] = homenumber ;
					homenumber = 0;
				}
			}
		}
		System.out.println(complexnumber);
		Arrays.sort(result);
		for (int i = 0; i < result.length; i++) {
			if(result[i] !=0)
			System.out.println(result[i]);
		}
	}
	public static void dfs(int x , int y) {
		homenumber++;
		visit[x][y] = 1;
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(nx>= 0 && ny>=0 && nx<N && ny<N && visit[nx][ny]==0 && map[nx][ny]==1 ) {
				dfs(nx,ny);
			}
		}
	}

}
