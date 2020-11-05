/*
 * BJ 2636 치즈
 * => 시뮬레이션, BFS
 * 치즈로 막혀있는 숨구멍을 어떻게 구현할 것인가!
 * 각 치즈 조각에서 BFS를 통해 어느 한 부분이라도 x에 닿는다면 구멍 X
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2636_Cheese {
	
	static int R, C, countCheese;
	static int[][] cheese;
	static boolean[][] isVisited, isNotHole;
	static class Pos{
		int row, col;

		public Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	static int[] dirR = {-1,1,0,0};
	static int[] dirC = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		cheese = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		while(!checkCheese()) {
			time++;
			isNotHole = new boolean[R][C];
			countCheese();
			for (int i = 1; i < R-1; i++) {
				for (int j = 1; j < C-1; j++) {
					if(cheese[i][j] == 1) BFS(i,j);
				}
			}
			
			for (int i = 1; i < R-1; i++) {
				for (int j = 1; j < C-1; j++) {
					if(isNotHole[i][j]) cheese[i][j] = 0;
				}
			}
		}
		
		System.out.println(time);
		System.out.println(countCheese);
	}
	
	private static boolean checkCheese() {
		for (int i = 1; i < R-1; i++) {
			for (int j = 1; j < C-1; j++) {
				if(cheese[i][j] == 1) return false;
			}
		}
		return true;
	}

	private static void BFS(int r,int c) {
		Queue<Pos> q = new LinkedList<Pos>();
		isVisited = new boolean[R][C];
		
		q.offer(new Pos(r, c));
		isVisited[r][c] = true;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			if(p.row == 0 || p.col == 0 || p.row == R-1 || p.col == C-1) {
				isNotHole[r][c] = true;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = p.row + dirR[i];
				int nc = p.col + dirC[i];
				
				if(nr<0 || nc<0 || nr>=R || nc>=C || isVisited[nr][nc] || cheese[nr][nc] == 1) continue;
				
				q.offer(new Pos(nr, nc));
				isVisited[nr][nc] = true;
			}
		}
	}
	
	private static void countCheese() {
		int count = 0;
		for (int i = 1; i < R-1; i++) {
			for (int j = 1; j < C-1; j++) {
				if(cheese[i][j] == 1) count++;
			}
		}
		countCheese = count;
	}
}













