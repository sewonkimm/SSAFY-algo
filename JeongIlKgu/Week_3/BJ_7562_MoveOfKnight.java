/*
 * BJ 7562 나이트의 이동
 * 그래프를 표현한 Array와 BFS를 통해 해결
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_7562_MoveOfKnight {
	
	// delta
	static int[] dir_r = {-2,-2,-1,-1,1,1,2,2};
	static int[] dir_c = {-1,1,-2,2,-2,2,-1,1};
	static int[][] chessBoard; // 이동하는 값이 들어갈 배열
	static boolean[][] isVisited;
	static int N, knightR, knightC, destR, destC;
	static class pos{
		int r,c;
		public pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static Queue<pos> q = new LinkedList<pos>();

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			N = sc.nextInt();
			chessBoard = new int[N][N];
			isVisited = new boolean[N][N];
			knightR = sc.nextInt();
			knightC = sc.nextInt();
			destR = sc.nextInt();
			destC = sc.nextInt();

			q.clear();
			BFS(new pos(knightR, knightC));
			System.out.println(chessBoard[destR][destC]);
		}
		sc.close();
	}
	
	public static void BFS(pos p) {
		isVisited[p.r][p.c] = true;
		q.add(p);
		while(!q.isEmpty()) {
			pos temp = q.poll();
			int r = temp.r;
			int c = temp.c;
			// 목적지에 도달하면 끝
			if(r == destR && c == destC) {
				break;
			}
			
			for (int i = 0; i < 8; i++) {
				int nr = r + dir_r[i];
				int nc = c + dir_c[i];
				
				if(isValidPosition(nr, nc) && !isVisited[nr][nc]) {
					q.add(new pos(nr, nc));
					isVisited[nr][nc] = true;
					chessBoard[nr][nc] = chessBoard[r][c] + 1;
				}
			}
		}
	}
	// 배열 범위 밖으로 넘어가는지 확인하는 Method
	private static boolean isValidPosition(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= N)
            return false;
        return true;
    }
}
