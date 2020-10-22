/*
 * BJ 14500 테트로미노
 * => 노가다? 나올 수 있는 모든 도형의 수는 19개(대칭,회전 포함)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14500_Tetromino {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int R = Integer.parseInt(st.nextToken()); // N
		int C = Integer.parseInt(st.nextToken()); // M 
		
		int[][] paper = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = Integer.MIN_VALUE;
		int sum = 0;
		
		// 1. 정사각형
		for (int i = 0; i < R-1; i++) {
			for (int j = 0; j < C-1; j++) {
				sum = paper[i][j]+paper[i][j+1]+paper[i+1][j]+paper[i+1][j+1];
				max = Math.max(max, sum);
			}
		}
		// 2. ㅡ
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C-3; j++) {
				sum = paper[i][j]+paper[i][j+1]+paper[i][j+2]+paper[i][j+3];
				max = Math.max(max, sum);
			}
		}
		// 3. ㅣ
		for (int i = 0; i < R-3; i++) {
			for (int j = 0; j < C; j++) {
				sum = paper[i][j]+paper[i+1][j]+paper[i+2][j]+paper[i+3][j];
				max = Math.max(max, sum);
			}
		}
		// 4. ㅜ
		for (int i = 0; i < R-1; i++) {
			for (int j = 0; j < C-2; j++) {
				sum = paper[i][j]+paper[i][j+1]+paper[i][j+2]+paper[i+1][j+1];
				max = Math.max(max, sum);
			}
		}
		// 5. ㅏ
		for (int i = 0; i < R-2; i++) {
			for (int j = 0; j < C-1; j++) {
				sum = paper[i][j]+paper[i+1][j]+paper[i+2][j]+paper[i+1][j+1];
				max = Math.max(max, sum);
			}
		}
		// 6. ㅗ
		for (int i = R-1; i >= 1; i--) {
			for (int j = 0; j < C-2; j++) {
				sum = paper[i][j]+paper[i][j+1]+paper[i][j+2]+paper[i-1][j+1];
				max = Math.max(max, sum);
			}
		}
		// 7. ㅓ
		for (int i = R-1; i >= 2; i--) {
			for (int j = C-1; j >= 1; j--) {
				sum = paper[i][j]+paper[i-1][j]+paper[i-2][j]+paper[i-1][j-1];
				max = Math.max(max, sum);
			}
		}
		// 8. ㅣ
		//     ㅡ
		//      ㅣ
		for (int i = 0; i < R-2; i++) {
			for (int j = 0; j < C-1; j++) {
				sum = paper[i][j]+paper[i+1][j]+paper[i+1][j+1]+paper[i+2][j+1];
				max = Math.max(max, sum);
			}
		}
		// 9.  ㅣ
		//    ㅡ
		//   ㅣ
		for (int i = 0; i < R-2; i++) {
			for (int j = C-1; j >= 1; j--) {
				sum = paper[i][j]+paper[i+1][j]+paper[i+1][j-1]+paper[i+2][j-1];
				max = Math.max(max, sum);
			}
		}
		// 10. ㄱㄴ
		for (int i = 0; i < R-1; i++) {
			for (int j = 0; j < C-2; j++) {
				sum = paper[i][j]+paper[i][j+1]+paper[i+1][j+1]+paper[i+1][j+2];
				max = Math.max(max, sum);
			}
		}
		// 11. ㄱㄴ 대칭
		for (int i = 0; i < R-1; i++) {
			for (int j = C-1; j >= 2; j--) {
				sum = paper[i][j]+paper[i][j-1]+paper[i+1][j-1]+paper[i+1][j-2];
				max = Math.max(max, sum);
			}
		}
		// 12. 
		for (int i = 0; i < R-1; i++) {
			for (int j = 0; j < C-2; j++) {
				sum = paper[i][j]+paper[i+1][j]+paper[i+1][j+1]+paper[i+1][j+2];
				max = Math.max(max, sum);
			}
		}
		// 13.
		for (int i = 0; i < R-2; i++) {
			for (int j = 0; j < C-1; j++) {
				sum = paper[i][j]+paper[i][j+1]+paper[i+1][j]+paper[i+2][j];
				max = Math.max(max, sum);
			}
		}
		// 14.
		for (int i = 0; i < R-1; i++) {
			for (int j = 0; j < C-2; j++) {
				sum = paper[i][j]+paper[i][j+1]+paper[i][j+2]+paper[i+1][j+2];
				max = Math.max(max, sum);
			}
		}
		// 15.
		for (int i = 0; i < R-2; i++) {
			for (int j = C-1; j >= 1; j--) {
				sum = paper[i][j]+paper[i+1][j]+paper[i+2][j]+paper[i+2][j-1];
				max = Math.max(max, sum);
			}
		}
		// 16.
		for (int i = R-1; i >= 1; i--) {
			for (int j = 0; j < C-2; j++) {
				sum = paper[i][j]+paper[i][j+1]+paper[i][j+2]+paper[i-1][j+2];
				max = Math.max(max, sum);
			}
		}
		// 17.
		for (int i = 0; i < R-2; i++) {
			for (int j = 0; j < C-1; j++) {
				sum = paper[i][j]+paper[i+1][j]+paper[i+2][j]+paper[i+2][j+1];
				max = Math.max(max, sum);
			}
		}
		// 18.
		for (int i = 0; i < R-1; i++) {
			for (int j = 0; j < C-2; j++) {
				sum = paper[i][j]+paper[i+1][j]+paper[i][j+1]+paper[i][j+2];
				max = Math.max(max, sum);
			}
		}
		// 19.
		for (int i = 0; i < R-2; i++) {
			for (int j = 0; j < C-1; j++) {
				sum = paper[i][j]+paper[i][j+1]+paper[i+1][j+1]+paper[i+2][j+1];
				max = Math.max(max, sum);
			}
		}
		System.out.println(max);
	}

}
