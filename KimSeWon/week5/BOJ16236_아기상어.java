package com.week5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ16236_아기상어 {

	static int N, time, size, left;
	static int minX, minY, minDist;
	static int[][] map, dist;
	static int[][] dir = { {-1, 0}, {0, -1}, {0, 1}, {1, 0} };
	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		dist = new int[N][N];
		int sx=0, sy=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();

				if(map[i][j] == 9) {	// 물고기 시작 위치
					sx = i;
					sy = j;
				}
			}
		}
		time = 0;		// 시간
		size = 2;		// 상어의 크기
		left = size;	// 먹어야할 물고기의 갯수


		while(true) {
			init();

			bfs(sx, sy);	// 물고기 찾기

			if(minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {		// 먹을 수 있는 물고기가 있는 경우

				time += dist[minX][minY];
				left--;

				// 물고기 크기 키우기
				if(left == 0) {
					size++;
					left = size;
				}

				map[sx][sy] = 0;
				map[minX][minY] = 0;	// 물고기 잡아먹기
				// 상어의 위치 갱신
				sx = minX;
				sy = minY;
			}
			else break;		// 더이상 물고기를 먹을 수 없는 경우 종료
		}

		// output
		System.out.println(time);
		sc.close();
	}

	private static void init() {	// bfs를 위한 변수 초기화
		for(int i=0; i<N; i++) {
			Arrays.fill(dist[i], -1);
		}

		minX = Integer.MAX_VALUE;
		minY = Integer.MAX_VALUE;
		minDist = Integer.MAX_VALUE;
	}

	private static void bfs(int x, int y) {

		Queue<int[]> q = new LinkedList<int[]>();
		int[] p = { x, y };
		q.offer(p);
		dist[x][y] = 0;

		while(!q.isEmpty()) {
			int[] n = q.poll();

			for(int i=0; i<4; i++) {
				int nx = n[0] + dir[i][0];
				int ny = n[1] + dir[i][1];
				if(nx>=0 && nx<N && ny>=0 && ny<N && dist[nx][ny] == -1 && map[nx][ny] <= size) {
					dist[nx][ny] = dist[n[0]][n[1]] + 1;

					// 먹을 물고기 위치 찾기
					if(map[nx][ny] != 0 && map[nx][ny] < size) {	// 먹을 수 있는 물고기를 발견
						if(minDist > dist[nx][ny]) {
							minDist = dist[nx][ny];
							minX = nx;
							minY = ny;
						}
						else if(minDist == dist[nx][ny]) {		// 물고기를 한마리 이상 발견한 경우
							if(minX == nx) {
								if(minY > ny) {		// 위쪽에 있을 경우 좌측에 있는 것을 선택
									minY = ny;
								}
							}
							else if(minX > nx) {	// 맨 위쪽에 있는 것을 선택
								minX = nx;
								minY = ny;
							}
						}
					}

					int[] next = { nx, ny };
					q.add(next);
				}
			}
		}
	}
}
