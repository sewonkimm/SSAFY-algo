/*
 * BJ 1600 말이 되고픈 원숭이
 * => BFS, 총 12개의 방향을 가지고 Queue에 원숭이의 위치 넣기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1600_MonkeyWantsToBeHorse {
	
	static int K, R, C, min;
	static class Monkey{
		int r, c, horseCount, movement;

		public Monkey(int r, int c, int horseCount, int movement) {
			this.r = r;
			this.c = c;
			this.horseCount = horseCount;
			this.movement = movement;
		}
	}
	static Queue<Monkey> q = new LinkedList<Monkey>();
	// Normal delta
	static int[] dirR = {-1,1,0,0};
	static int[] dirC = {0,0,-1,1};
	// Horse delta
	static int[] HorseR = {-1,-2,-2,-1,1,2,2,1};
	static int[] HorseC = {-2,-1,1,2,2,1,-1,-2};
	static int[][] map;
	static boolean[][][] isVisited;
	static boolean check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		isVisited = new boolean[R][C][K+1];
		min = Integer.MAX_VALUE;
		
		q.offer(new Monkey(0, 0, K, 0));		
		isVisited[0][0][K] = true;
		
		while(!q.isEmpty()) {
			Monkey m = q.poll();
			// 도착점에 도달했을 경우
			if(m.r == R-1 && m.c == C-1) {
				min = Math.min(min, m.movement);
				check = true;
				continue;
			}
			// 기본 4가지 방향으로 확인한다.
			for (int i = 0; i < 4; i++) {
				int nr = m.r + dirR[i];
				int nc = m.c + dirC[i];
				
				if(nr<0 || nc<0 || nr>=R || nc>=C 
						|| isVisited[nr][nc][m.horseCount] || map[nr][nc] == 1) continue;
				
				q.offer(new Monkey(nr, nc, m.horseCount, m.movement+1));
				isVisited[nr][nc][m.horseCount] = true;
			}
			// 말처럼 이동할 수 있는 경우를 확인
			if(m.horseCount > 0) {
				for (int i = 0; i < 8; i++) {
					int nr = m.r + HorseR[i];
					int nc = m.c + HorseC[i];
					
					if(nr<0 || nc<0 || nr>=R || nc>=C 
							|| isVisited[nr][nc][m.horseCount-1] || map[nr][nc] == 1) continue;
					
					q.offer(new Monkey(nr, nc, m.horseCount-1, m.movement+1));
					isVisited[nr][nc][m.horseCount-1] = true;
				}
			}
		}
		
		if(check) System.out.println(min);
		else System.out.println(-1);
	}

}
