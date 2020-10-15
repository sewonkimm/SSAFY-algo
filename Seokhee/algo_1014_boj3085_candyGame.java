import java.util.*;
import java.io.*;

public class algo_1014_boj3085_candyGame {

	static int n;
	static int[] dx1 = {0,0}; static int[] dy1 = {-1,1};
	static int[] dx2 = {-1,1}; static int[] dy2 = {0,0};
	static char[][] map;
	static int max;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		String s;
		for(int i=0;i<n;i++) {
			s = br.readLine();
			map[i] = s.toCharArray();
		}

		char temp;
		//1.교환 아래, 오른쪽으로만 하자 
		//2.최대찾기
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				//아래
				if(i+1<n) {
					temp = map[i][j];
					map[i][j] = map[i+1][j];
					map[i+1][j] = temp;
					
					cnt = check(map);
					
					if(max<cnt)
						max = cnt;
					
					temp = map[i][j];
					map[i][j] = map[i+1][j];
					map[i+1][j] = temp;
				}
				//오른쪽
				if(j+1<n) {
					temp = map[i][j];
					map[i][j] = map[i][j+1];
					map[i][j+1] = temp;
					
					cnt = check(map);
					
					if(max<cnt)
						max = cnt;
					
					temp = map[i][j];
					map[i][j] = map[i][j+1];
					map[i][j+1] = temp;
				}
			}
		}
		
		System.out.println(max);
		
	}
	
	static int check(char[][] a) {
		int n = a.length;
		int ans = 1;
		for (int i = 0; i < n; i++) {
			int cnt = 1;
			for (int j = 1; j < n; j++) {
				if (a[i][j] == a[i][j - 1]) {
					cnt += 1;
				} else {
					cnt = 1;
				}
				if (ans < cnt)
					ans = cnt;
			}
			cnt = 1;
			for (int j = 1; j < n; j++) {
				if (a[j][i] == a[j - 1][i]) {
					cnt += 1;
				} else {
					cnt = 1;
				}
				if (ans < cnt)
					ans = cnt;
			}
		}
		return ans;
	}
}
