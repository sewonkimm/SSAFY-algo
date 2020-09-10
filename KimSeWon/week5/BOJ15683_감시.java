package com.week5;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

// dfs

public class BOJ15683_감시 {

	static int N, M, answer;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } }; // 우 좌 상 하
	static int[][] dir2 = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 상 우 하 좌
	static ArrayList<Point> cctvList;

	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		answer = Integer.MAX_VALUE;
		map = new int[N][M];
		visited = new boolean[N][M];
		cctvList = new ArrayList<Point>(); // cctv 위치 저장
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();

				if (map[i][j] != 0 && map[i][j] != 6) { // cctv 발견
					cctvList.add(new Point(i, j));
				}
			}
		}

		dfs(0, visited);

		// output
		System.out.println(answer);
		sc.close();
	}

	private static void dfs(int cnt, boolean[][] visit) {
		// 기저조건
		if (cnt == cctvList.size()) {
			answer = Math.min(answer, getBlindspot(visit));
		}

		if (cnt == cctvList.size())
			return;

		// 유도조건
		Point now = cctvList.get(cnt);
		int type = map[now.x][now.y];

		boolean[][] tmpVisit = new boolean[N][M];
		tmpVisit = initVisit(visit, tmpVisit);
		
		if (type == 1) {
			for (int k = 0; k < 4; k++) {
				int nx = now.x + dir[k][0];
				int ny = now.y + dir[k][1];
				while (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 6) {
					tmpVisit[nx][ny] = true;
					nx += dir[k][0];
					ny += dir[k][1];
				}
				dfs(cnt + 1, tmpVisit);
				tmpVisit = initVisit(visit, tmpVisit);
			}
		} else if (type == 2) {
			for (int k = 0; k < 2; k++) {
				int nx1 = now.x + dir[2 * k][0];
				int ny1 = now.y + dir[2 * k][1];
				while (nx1 >= 0 && nx1 < N && ny1 >= 0 && ny1 < M && map[nx1][ny1] != 6) {
					tmpVisit[nx1][ny1] = true;
					nx1 += dir[2 * k][0];
					ny1 += dir[2 * k][1];
				}

				int nx2 = now.x + dir[2 * k + 1][0];
				int ny2 = now.y + dir[2 * k + 1][1];
				while (nx2 >= 0 && nx2 < N && ny2 >= 0 && ny2 < M && map[nx2][ny2] != 6) {
					tmpVisit[nx2][ny2] = true;
					nx2 += dir[2 * k + 1][0];
					ny2 += dir[2 * k + 1][1];
				}
				dfs(cnt + 1, tmpVisit);
				tmpVisit = initVisit(visit, tmpVisit);
			}
		} else if (type == 3) {
			for (int k = 0; k < 4; k++) {
				int nx1 = now.x + dir2[k][0];
				int ny1 = now.y + dir2[k][1];
				while (nx1 >= 0 && nx1 < N && ny1 >= 0 && ny1 < M && map[nx1][ny1] != 6) {
					tmpVisit[nx1][ny1] = true;
					nx1 += dir2[k][0];
					ny1 += dir2[k][1];
				}

				int nx2 = now.x + dir2[(k + 1) % 4][0];
				int ny2 = now.y + dir2[(k + 1) % 4][1];
				while (nx2 >= 0 && nx2 < N && ny2 >= 0 && ny2 < M && map[nx2][ny2] != 6) {
					tmpVisit[nx2][ny2] = true;
					nx2 += dir2[(k + 1) % 4][0];
					ny2 += dir2[(k + 1) % 4][1];
				}
				dfs(cnt + 1, tmpVisit);
				tmpVisit = initVisit(visit, tmpVisit);
			}
		} else if (type == 4) {
			for (int k = 0; k < 4; k++) {
				int nx1 = now.x + dir2[(k+3)%4][0];
				int ny1 = now.y + dir2[(k+3)%4][1];
				while (nx1 >= 0 && nx1 < N && ny1 >= 0 && ny1 < M && map[nx1][ny1] != 6) {
					tmpVisit[nx1][ny1] = true;
					nx1 += dir2[(k+3)%4][0];
					ny1 += dir2[(k+3)%4][1];
				}

				int nx2 = now.x + dir2[k][0];
				int ny2 = now.y + dir2[k][1];
				while (nx2 >= 0 && nx2 < N && ny2 >= 0 && ny2 < M && map[nx2][ny2] != 6) {
					tmpVisit[nx2][ny2] = true;
					nx2 += dir2[k][0];
					ny2 += dir2[k][1];
				}
				
				int nx3 = now.x + dir2[(k + 1) % 4][0];
				int ny3 = now.y + dir2[(k + 1) % 4][1];
				while (nx3 >= 0 && nx3 < N && ny3 >= 0 && ny3 < M && map[nx3][ny3] != 6) {
					tmpVisit[nx3][ny3] = true;
					nx3 += dir2[(k + 1) % 4][0];
					ny3 += dir2[(k + 1) % 4][1];
				}
				dfs(cnt + 1, tmpVisit);
				tmpVisit = initVisit(visit, tmpVisit);
			}

		} else if (type == 5) {
			for (int t = 0; t < 4; t++) {
				int nx = now.x + dir[t][0];
				int ny = now.y + dir[t][1];
				while (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 6) {
					tmpVisit[nx][ny] = true;
					nx += dir[t][0];
					ny += dir[t][1];
				}
			}
			dfs(cnt + 1, tmpVisit);
			tmpVisit = initVisit(visit, tmpVisit);
		}

	}

	private static boolean[][] initVisit(boolean[][] visit, boolean[][] tmpVisit){
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmpVisit[i][j] = visit[i][j];
			}
		}
		return tmpVisit;
	}
	
	private static int getBlindspot(boolean[][] visit) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j] && map[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}
}
