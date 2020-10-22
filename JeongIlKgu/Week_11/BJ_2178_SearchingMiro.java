/*
 * BJ 2178 미로 탐색
 * => BFS
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2178_SearchingMiro {
	
	static int[] dirR = {-1,1,0,0};
	static int[] dirC = {0,0,-1,1};
	static class pos{
		int r, c, n;

		public pos(int r, int c, int n) {
			this.r = r;
			this.c = c;
			this.n = n;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		sc.nextLine();
		
		char[][] miro = new char[R][C];
		boolean[][] isVisited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			miro[i] = sc.nextLine().toCharArray();
		}
		
		Queue<pos> q = new LinkedList<pos>();
		q.offer(new pos(0, 0, 1));
		isVisited[0][0] = true;
		int min = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			pos p = q.poll();
			
			if(p.r == R-1 && p.c == C-1) {
				min = Math.min(min, p.n);
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dirR[i];
				int nc = p.c + dirC[i];
				
				if(nr<0 || nc<0 || nr>=R || nc>=C 
						|| isVisited[nr][nc] 
						|| miro[nr][nc] == '0') continue;
				
				q.offer(new pos(nr, nc, p.n+1));
				isVisited[nr][nc] = true;
			}
		}
		
		System.out.println(min);
		sc.close();
	}

}
