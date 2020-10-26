/*
 * BJ 4485 녹색 옷 입은 애가 젤다지?
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_4485_IsThatZeldaInTheGreenSuit {
	
	static int N, testCase;
	static int[][] map, min;
	static int[] dirR = {-1,1,0,0};
	static int[] dirC = {0,0,-1,1};
	static class Pos{
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while((N = Integer.parseInt(br.readLine())) != 0) {
			testCase++;
			map = new int[N][N];
			min = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			Queue<Pos> q = new LinkedList<Pos>();
			boolean[][] isVisited = new boolean[N][N];
			q.offer(new Pos(0, 0));
			min[0][0] = map[0][0];
			isVisited[0][0] = true;
			
			while(!q.isEmpty()) {
				Pos p = q.poll();
				
				for (int i = 0; i < 4; i++) {
					int nr = p.r + dirR[i];
					int nc = p.c + dirC[i];
					
					if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
					
					if(min[nr][nc] == 0 && !isVisited[nr][nc]) {
						q.offer(new Pos(nr, nc));
						isVisited[nr][nc] = true;
						min[nr][nc] = min[p.r][p.c] + map[nr][nc];
					}else {
						if(min[nr][nc] > min[p.r][p.c] + map[nr][nc]) {
							q.offer(new Pos(nr, nc));
							min[nr][nc] = min[p.r][p.c] + map[nr][nc];
							
						}
					}
				}
			}
			
			System.out.println("Problem " + testCase + ": " + min[N-1][N-1]);
		}

	}

}
