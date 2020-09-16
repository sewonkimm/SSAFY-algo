/*
 * BJ 1976 여행 가자
 * BFS 이용
 * 다른 풀이 확인하니 make, find, union 이용!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1976_GoTravel {
	
	// 도시의 수, 여행 계획에 속한 도시들의 수, 현재 도시
	static int N, M, cur;
	static int[][] map; // 도시 연결 정보
	static int[] route; // 가는 길 정보
	static boolean[] isVisited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		map = new int[N+1][N+1];
		route = new int[M];
		// 도시 연결 정보 입력
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 가는 길 정보 입력
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < M; i++) {
			route[i] = Integer.parseInt(st.nextToken());
		}
		// 탐색 시작
		for (int i = 1; i < M; i++) {
			if(!BFS(route[i-1], route[i])) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	private static boolean BFS(int start, int dest) {
		Queue<Integer> q = new LinkedList<Integer>();
		isVisited = new boolean[N+1];
		// 출발점과 도착점이 같은 경우
		if(start == dest) return true;
		q.offer(start);
		isVisited[start] = true;
		
		while(!q.isEmpty()) {
			int v = q.poll();
			
			for (int i = 1; i <= N; i++) {
				// 만약 원하는 목적지에 도달할 수 있다면!
				if(i == dest && map[v][i] == 1) return true;
				
				if(map[v][i] == 1 && !isVisited[i]) {
					q.offer(i);
					isVisited[i] = true;
				}
			}
		}
		return false;
	}
}

/*
5
5
0 1 0 1 1
1 0 1 1 0
0 1 0 0 0
1 1 0 0 0
1 0 0 0 0 
5 3 2 3 4
*/