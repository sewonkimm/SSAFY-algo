/*
 * BJ 2630 색종이 만들기
 * => 분할 정복(쿼드 트리)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2630_MakeColorPaper {
	
	static int[][] paper;
	static int resultBlue, resultWhite; // 흰:0, 파:1

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		check(0, 0, N);
		System.out.println(resultWhite);
		System.out.println(resultBlue);
	}
	
	private static boolean isAble(int row, int col, int size) {
		int t = paper[row][col];
		for (int i = row; i < row+size; i++) {
			for (int j = col; j < col+size; j++) {
				if(paper[i][j] != t) return false;
			}
		}
		return true;
	}
	
	private static void check(int r, int c, int size) {
		if(isAble(r,c,size)) {
			if(paper[r][c] == 0) resultWhite++;
			else resultBlue++;
		}else {
			int newSize = size/2;
			
			check(r, c, newSize);
			check(r, c+newSize, newSize);
			check(r+newSize, c, newSize);
			check(r+newSize, c+newSize, newSize);
		}
	}

}
