/*
 * BJ 2563 색종이
 * 100 x 100 도화지 배열에 각 색종이의 면적만큼 체크하면서 면적확인
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2563_ColorPaper {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine()); // 색종이 개수
		int x, y; // 시작 x, y 좌표
		int count = 0; // 총 면전
		int[][] paper = new int[101][101]; // 도화지
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			for (int r = x; r < x+10; r++) {
				for (int c = y; c < y+10; c++) {
					// 이미 색종이가 채우고 있는 부분은 skip
					if(paper[r][c] == 1) continue;
					paper[r][c] = 1;
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
