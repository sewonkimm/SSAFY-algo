/*
 * BJ 16236 아기상어
 * BFS와 우선 순위 큐를 사용해 풀이
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16236_BabyShark {
	
	// delta
	static int[] dirR = {-1,1,0,0};
	static int[] dirC = {0,0,-1,1};
	static int[][] map; // 공간
	// 엄마 상어에게 도움을 요청하기까지의 시간, 상어의 위치와 크기, 공간의 크기
	static int resultTime, sharkR, sharkC, sharkSize, N;
	static class pos implements Comparable<pos>{ // 위치
		int r, c, dis;

		public pos(int r, int c, int dis) {
			this.r = r;
			this.c = c;
			this.dis = dis;
		}

		// 우선 순위 큐에서 사용하기 위해 거리가 가장 가깝고, 가장 위에 있고, 가장 왼쪽에 있는 것 찾기
		@Override
		public int compareTo(pos o) {
			if(this.dis > o.dis) {
				return 1;
			}else if(this.dis == o.dis) {
				if(this.r > o.r) {
					return 1;
				}else if(this.r == o.r) {
					return this.c - o.c;
				}
			}
			return -1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n == 9) {
					map[i][j] = 0;
					sharkR = i;
					sharkC = j;
				}else {
					map[i][j] = n;
				}
			}
		}
		sharkSize = 2;
		BFS(sharkR, sharkC, 0);
		System.out.println(resultTime);
	}

	private static void BFS(int r, int c, int eatingCount) {
		// 먹은 물고리의 수가 상어의 크기와 같다면
		if(eatingCount == sharkSize) {
			sharkSize++;
			eatingCount = 0;
		}
		// 더 이상 먹을 고기가 없는 경우
		if(checkFish(sharkSize)) return;
		
		boolean[][] isVisited = new boolean[N][N];
		Queue<pos> q = new LinkedList<pos>();
		PriorityQueue<pos> pq = new PriorityQueue<pos>();
		
		q.offer(new pos(r, c, 0));
		isVisited[r][c] = true;
		
		while(!q.isEmpty()) {
			pos p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dirR[i];
				int nc = p.c + dirC[i];
				
				if(nr<0 || nc<0 || nr>=N || nc>=N 
						|| isVisited[nr][nc] 
						|| sharkSize < map[nr][nc]) continue;
				// 먹을 수 있는 물고기가 있는 경우, 우선 순위 큐에 넣는다.
				if(sharkSize > map[nr][nc] && map[nr][nc] != 0) pq.add(new pos(nr, nc, p.dis+1));
				q.offer(new pos(nr, nc, p.dis+1));
				isVisited[nr][nc] = true;
			}
		}
		// 우선 순위 큐에서 먹을 수 있는 물고기 중 가장 앞 물고기만 뺀다.
		if(!pq.isEmpty()) {
			pos position = pq.poll();
			map[position.r][position.c] = 0;
			resultTime += position.dis;
			BFS(position.r, position.c, ++eatingCount);
			return;
		}
	}
	
	private static boolean checkFish(int size) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 0 && map[i][j] < size) return false;
			}
		}
		return true;
	}
}
