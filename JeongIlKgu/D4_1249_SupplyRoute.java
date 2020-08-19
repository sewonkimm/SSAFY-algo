/*
 * SWEA D4 1249 보급로
 * BFS를 통해 각 위치에서의 최소값으로 진행
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Position{
	int x, y;
	
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class D4_1249_SupplyRoute {
	
	static int[][] direction = {
			{-1,0}, {1,0}, {0,-1}, {0,1}
	}; // delta
	static int n, min;
	static int[][] map;
	static int[][] ans; // 값들을 더하면서 확인해 갈 배열
	static boolean[][] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for (int t = 1; t <= T; t++) {
			// 입력
			n = Integer.parseInt(in.readLine());
			map = new int[n][n];
			isVisited = new boolean[n][n];
			ans = new int[n][n];
			for (int i = 0; i < n; i++) {
				String s = in.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = s.charAt(j) - '0'; // char to int
					ans[i][j] = Integer.MAX_VALUE;
				}
			}
			min = Integer.MAX_VALUE;
			ans[0][0] = 0; // 시작은 0으로 초기화
			BFS(0,0);
			System.out.println("#"+t+" "+min);
		}
	}
	
	private static void BFS(int x, int y) {
		Queue<Position> q = new LinkedList<>();
        q.offer(new Position(x,y));
        isVisited[x][y] = true;
        while(!q.isEmpty()){
            Position p = q.poll();
            int a = p.x;
            int b = p.y;
 
            // 도착지에 도착한 경우, 최소값과 비교하여 더 작다면 갱신한다.
            if(a == n-1 && b == n-1) min = min > ans[n-1][n-1] ? ans[n-1][n-1] : min;
            if(min <= ans[a][b]) continue;
            for(int i=0; i<4; i++){
                int dx = a + direction[i][0];
                int dy = b + direction[i][1];
                if(isValidPosition(dx, dy)){
                    if(!isVisited[dx][dy] || ans[dx][dy] > ans[a][b] + map[dx][dy]){
                        isVisited[dx][dy] = true;
                        ans[dx][dy] = ans[a][b] + map[dx][dy];
                        q.offer(new Position(dx, dy));
                    }
                }
            }
        }
	}
	
	// 범위 확인
	private static boolean isValidPosition(int x, int y){
	        if(x < 0 || x >= n || y < 0 || y >= n)
	            return false;
	        return true;
	    }
}
