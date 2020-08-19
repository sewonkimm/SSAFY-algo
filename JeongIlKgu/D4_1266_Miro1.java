/*
 * SWEA D4 1266 미로1
 * 0: 길 / 1: 벽 / 2: 시작점 / 3: 도착점
 * 3을 만날 수 있다면 결과는 1, 없다면 결과는 0
 * DFS를 이용(isVisited)
 * Delta를 이용해서 갈 수 있는 4가지 방향에 대한 검사
 * -> 벽이거나 이미 갔던 방향은 가지 않은다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D4_1266_Miro1 {
	
	static int[][] direction = {
			{-1,0}, // 상 
			{1,0},  // 하
			{0,-1}, // 좌
			{0,1}   // 우
	}; // Delta
	static int result, row, col; // 결과값, 시작점 
	static int[][] miro; // 미로 정보
	static boolean isVisited[][]; // 미로 각 위치 방문 정보

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			// 입력
			int testCaseNum = Integer.parseInt(in.readLine());
			miro = new int[16][16];
			isVisited = new boolean[16][16];
			for (int i = 0; i < 16; i++) {
				String s = in.readLine();
				for (int j = 0; j < 16; j++) {
					// 문자열로 입력되는 미로 정보 처리, 2일 경우에만 시작점의 좌표 정보를 확인
					if(s.charAt(j) == '0') continue;
					else if(s.charAt(j) == '1') miro[i][j] = 1;
					else if(s.charAt(j) == '2') {
						miro[i][j] = 2;
						row = i;
						col = j;
					}else if(s.charAt(j) == '3') miro[i][j] = 3;
				}
			}
			
			result = 0; // 시작하기 전 항상 결과를 0으로 초기화
			DFS(row,col);
			System.out.println("#" + testCaseNum + " " + result);
		}

	}

	public static void DFS(int r, int c) {
		// 방문했으면 True
		isVisited[r][c] = true;
		// 도착점에 간 경우 끝!
		if(miro[r][c] == 3) {
			result = 1;
			return;
		}
		// 상, 하, 좌, 우를 확인하면서 갈 수 있는 곳은 방문!
		for (int i = 0; i < 4; i++) {
			int nr = r + direction[i][0];
			int nc = c + direction[i][1];
			
			if(nr < 1 || nc < 1 || nr >= 16 || nc >= 16 || miro[nr][nc] == 1 || isVisited[nr][nc]) continue;
			
			DFS(nr,nc);
		}
	}
}
