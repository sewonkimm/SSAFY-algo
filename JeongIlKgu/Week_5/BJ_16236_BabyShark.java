/*
 * BJ 16236 아기 상어
 * 시뮬레이션 + BFS
 * 1. BFS로 먹을 수 있는 자리를 모두 탐색한다.
 * 1) delta를 이용해 사방을 탐색
 * => 범위를 벗어남 or 물고기의 크기 > 상어의 크기 or 이미 지나쳤던 곳 => 확인 X
 * 2) 탐색하면서 현재 먹을 수 있는 범위의 물고기를 모두 확인하였다면
 * => 물고리가 존재하는 최소 거리를 확인하여 그 위치부터 재시작
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16236_BabyShark {

	// delta
	static int[] dirR = {-1,0,1,0};
	static int[] dirC = {0,1,0,-1};
	static int[][] map, distance;
	static int N, time, count; // 공간의 크기, 걸린 시간, 상어가 먹은 물고기 수
	// 상어의 정보를 담고 있는 class
	static class Shark{
		int r, c, dis;

		public Shark(int r, int c, int dis) {
			super();
			this.r = r;
			this.c = c;
			this.dis = dis;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int sharkR = 0, sharkC = 0;
		N = Integer.parseInt(in.readLine().trim());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 상어 위치 처리
				if(map[i][j] == 9) {
					sharkR = i;
					sharkC = j;
					map[i][j] = 0;
				}
			}
		}
		checkEat(new Shark(sharkR, sharkC, 0), 2);
		System.out.println(time);
	}
	// 물고기를 모두 먹은 경우가 아니면 계속 반복
	private static void checkEat(Shark s, int sharkWeight) {
		// 모든 물고기를 먹었을 경우, 종료
		if(check(map)) return;
		// 먹을 수 있는 물고기가 있는 위치를 찾는다.
		BFS(s, sharkWeight);
		// 거리가 가장 가까운 물고리를 찾는다.
		findMinDistance(sharkWeight);
	}
	// 먹을 수 있는 물고기가 있는 위치를 모두 확인하여 거리를 저장한다.
	private static void BFS(Shark s, int sharkWeight) {
		boolean[][] isVisited = new boolean[N][N]; // 방문 확인
		distance = new int[N][N]; // 거리를 저장할 배열
		Queue<Shark> q = new LinkedList<Shark>();
		q.offer(s);
		isVisited[s.r][s.c] = true;
		
		while(!q.isEmpty()){
			Shark tempS = q.poll();
			// 거리 저장 => 먹을 수 있는 경우
			if((map[tempS.r][tempS.c] != 0) && (sharkWeight > map[tempS.r][tempS.c])) {
				distance[tempS.r][tempS.c] = tempS.dis;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = tempS.r + dirR[i];
				int nc = tempS.c + dirC[i];
				
				if(!Pass(nr, nc) || (sharkWeight < map[nr][nc]) || isVisited[nr][nc]) continue;
				// dis+1를 하여 한번 이동하는 것을 표현
				q.offer(new Shark(nr,nc,tempS.dis+1));
				isVisited[nr][nc] = true;
			}
		}
	}
	
	private static void findMinDistance(int w) {
		boolean check = false;
		int r = 0;
		int c = 0;
		// 모든 장소를 갈 수 없다면 종료
		if(check(distance)) return;
		// distance 배열에서 가장 가까운 수를 찾는다. 우선순위 : 위->왼
		int min = find();
		time += min; // 거리가 곧 시간이기 때문에
		count++; // 이  Method가 한번 실행되면 1마리의 물고기를 먹은 것
		// 물고기를 먹은 수가 현재 아기 상어의 크기라면
		if(count == w) {
			count = 0;
			w++;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(distance[i][j] == min) {
					r = i;
					c = j;
					check = true;
					break;
				}
			}
			if(check) break;
		}
		// 그 위치를 0으로 만든다.
		map[r][c] = 0;
		// 다시 checkEat
		checkEat(new Shark(r, c, 0), w);
	}
	// 거리의 최소값을 찾아주는 Method
	private static int find() {
		int m = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				 if(distance[i][j] != 0 && m > distance[i][j]) {
					 m = distance[i][j];
				 }
			}
		}
		return m;
	}
	// 갈 수 있는 곳이 있는지 없는지 확인해주는 Method
	private static boolean check(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j] != 0) return false;
			}
		}
		return true;
	}
	// 범위 밖으로 벗어나는지 확인해주는 Method
	private static boolean Pass(int a, int b) {
		if(a<0 || b<0 || a>=N || b>=N) return false;
		return true;
	}
}
