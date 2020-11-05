/*
 * BJ 11504 돌려 돌려 돌림판
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BJ_11504_SwingSwingSwingBoard {
	
	// N등분할 정수, 자리수, X, Y수
	static int N, M, X, Y, result;
	static String[] board; // 돌림판

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			result = 0;
			
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			board = new String[N];
			
			sb.setLength(0);
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				sb.append(st.nextToken());
			}
			X = Integer.parseInt(sb.toString());
			
			sb.setLength(0);
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				sb.append(st.nextToken());
			}
			Y = Integer.parseInt(sb.toString());
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				board[i] = st.nextToken();
			}
			
			for (int i = 0; i < N; i++) {
				sb.setLength(0);
				int n = i;
				for (int j = 0; j < M; j++) {
					sb.append(board[n]);
					n = (n+1)%N;
				}
				int comp = Integer.parseInt(sb.toString());
				if(comp >= X && comp <= Y) result++;
			}
			
			System.out.println(result);
		}
	}
}
