/*
 * BJ 5567 결혼식
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_5567_Wedding {
	
	static int n, m;
	static int[][] friend;
	static int[] invited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		friend = new int[n+1][n+1];
		invited = new int[n+1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			friend[a][b] = friend[b][a] = 1;
		}
		
		// 친구와 친구의 친구 확인
		for (int i = 2; i <= n; i++) {
			if(friend[1][i] == 1) {
				invited[i] = 1;
				check(i);
			}
		}
		
		int count = 0;
		for (int i = 2; i <= n; i++) {
			if(invited[i] == 1) count++;
		}
		System.out.println(count);
	}
	
	public static void check(int i) {
		for (int j = 2; j <= n; j++) {
			if(i != j && friend[i][j] == 1) invited[j] = 1;
		}
	}

}
