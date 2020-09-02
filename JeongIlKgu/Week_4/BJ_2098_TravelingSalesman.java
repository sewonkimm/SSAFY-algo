/*
 * BJ 2098 외판원 순회 => 실패(아이디어?)
 * DP
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2098_TravelingSalesman {
	
	// 도시 수, 최소 비용, 임시 최소 비용, 각 탐색마다 마지막 도시
	static int N, answer, min, ver;
	static int[][] map; // 도시 상황
	static boolean[] isVisited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		map = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = Integer.MAX_VALUE;
		// 각 도시를 시작으로 한번씩 확인
		for (int i = 1; i <= N; i++) {
			min = 0;
			ver = 0;
			isVisited = new boolean[N+1];
			findRoad(i);
			// 마지막 도시에서 처음 도시로 돌아오기 때문에 더해준다.
			min += map[ver][i];
			if(answer > min) answer = min;
		}
		System.out.println(answer);
	}
	
	// 이동하는 상황에 대한 비용
	private static void findRoad(int v) {
		int vertex = 0;
		boolean check = false;
		int tempMin = Integer.MAX_VALUE;
		isVisited[v] = true;
		// 모든 도시를 방문했는지 확인
		for (int i = 1; i <= N; i++) {
			if(!isVisited[i]) {
				check = true;
				break;
			}
		}
		// 방문하지 않은 도시가 있다면
		if(check) {
			// 이동 비용이 가장 적은 도시를 찾아 이동
			for (int i = 1; i <= N; i++) {
				if(!isVisited[i] 
						&& map[v][i] != 0 
						&& tempMin > map[v][i]) {
					tempMin = map[v][i];
					vertex = i;
				}
			}
			min += tempMin;
			findRoad(vertex);
		}else ver = v;
	}
}
