/*
 * BJ 3184 양
 * BFS
 * 양이나 늑대인 경우 BFS를 활용해서 그 주위를 탐색하고
 * 양과 늑대의 수를 세고 어느 쪽이 더 많은지 확인한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3184_Sheep {
	
	// 위치를 담을 정보
	static class Pos{
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	// delta
	static int[] dirR = {-1,0,1,0};
	static int[] dirC = {0,1,0,-1};
	static Queue<Pos> q; // BFS에서 사용할 큐
	static int R, C, sheep, wolf, answerSheep, answerWolf; // 행, 열, 양의 수, 늑대의 수
	static char[][] field;
	static boolean[][] isVisited;

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		field = new char[R][C];
		isVisited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String s = in.readLine();
			for (int j = 0; j < C; j++) {
				field[i][j] = s.charAt(j);
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(!isVisited[i][j] 
						&& (field[i][j] == 'o' 
						|| field[i][j] == 'v')) {
					BFS(new Pos(i, j));
					
					// 양과 늑대 처리
					if(sheep > wolf) answerSheep += sheep;
					else answerWolf += wolf;
				}
			}
		}
		
		System.out.println(answerSheep + " " + answerWolf);
	}

	private static void BFS(Pos p) {
		sheep = 0;
		wolf = 0;
		q = new LinkedList<Pos>();
		q.offer(p);
		isVisited[p.r][p.c] = true;
		
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			// 양이거나 늑대면 확인
			if(field[temp.r][temp.c] == 'o') sheep++;
			else if(field[temp.r][temp.c] == 'v') wolf++;
			
			for (int i = 0; i < 4; i++) {
				int nr = temp.r + dirR[i];
				int nc = temp.c + dirC[i];
				
				if(nr<0 || nc<0 || nr>=R || nc>=C 
						|| isVisited[nr][nc] || field[nr][nc] == '#') continue;
				
				q.offer(new Pos(nr,nc));
				isVisited[nr][nc] = true;
			}
		}
	}
}
