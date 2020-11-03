import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_Arrest {
	
	// 지하 터널 지도의 세로, 가로 크기, 멘홀 뚜껑의 위치, 탈출 시간
	static int N, M, R, C, L;
	static int[][] map; // 지하 터널 지도
	static boolean[][] isVisited;
	static class pos{
		int r, c, t;

		public pos(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}
	// delta -> 상, 하, 좌, 우
	static int[] dirR = {-1,1,0,0};
	static int[] dirC = {0,0,-1,1};
	static Queue<pos> q = new LinkedList<pos>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int TestCaseNum = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TestCaseNum; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			isVisited = new boolean[N][M];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs(R, C, 1);
			
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(isVisited[i][j]) count++;
				}
			}
			System.out.println("#" + t + " " + count);
		}
	}
	
	private static void bfs(int row, int col, int time) {
		q.offer(new pos(row, col, time));
		isVisited[row][col] = true;
		
		while(!q.isEmpty()) {
			pos p = q.poll();
			// 탈출에 소요된 시간 확인 
			if(p.t == L) continue;
			// 각 위치에 따라 진행되는 경로 확인
			switch (map[p.r][p.c]) {
			case 1: // 상하좌우
				for (int i = 0; i < 4; i++) {
					int nr = p.r + dirR[i];
					int nc = p.c + dirC[i];
					
					if(nr<0 || nc<0 || nr>=N || nc>= M 
							|| isVisited[nr][nc] 
							|| map[nr][nc] == 0) continue;
					// 상인 경우 조건
					if(i == 0 && (map[nr][nc] == 3 
							|| map[nr][nc] == 4 
							|| map[nr][nc] == 7)) continue;
					// 하인 경우 조건
					if(i == 1 && (map[nr][nc] == 3 
							|| map[nr][nc] == 5 
							|| map[nr][nc] == 6)) continue;
					// 좌인 경우 조건
					if(i == 2 && (map[nr][nc] == 2 
							|| map[nr][nc] == 6 
							|| map[nr][nc] == 7)) continue;
					// 우인 경우 조건
					if(i == 3 && (map[nr][nc] == 2 
							|| map[nr][nc] == 4 
							|| map[nr][nc] == 5)) continue;
					
					q.offer(new pos(nr, nc, p.t+1));
					isVisited[nr][nc] = true;
				}
				break;
			case 2: // 상하
				for (int i = 0; i < 2; i++) {
					int nr = p.r + dirR[i];
					int nc = p.c + dirC[i];
					
					if(nr<0 || nc<0 || nr>=N || nc>= M 
							|| isVisited[nr][nc] 
							|| map[nr][nc] == 0) continue;
					// 상인 경우 조건
					if(i == 0 && (map[nr][nc] == 3 
							|| map[nr][nc] == 4 
							|| map[nr][nc] == 7)) continue;
					// 하인 경우 조건
					if(i == 1 && (map[nr][nc] == 3 
							|| map[nr][nc] == 5 
							|| map[nr][nc] == 6)) continue;
					
					q.offer(new pos(nr, nc, p.t+1));
					isVisited[nr][nc] = true;
				}
				break;
			case 3: // 좌우
				for (int i = 2; i < 4; i++) {
					int nr = p.r + dirR[i];
					int nc = p.c + dirC[i];
					
					if(nr<0 || nc<0 || nr>=N || nc>= M 
							|| isVisited[nr][nc] 
							|| map[nr][nc] == 0) continue;
					// 좌인 경우 조건
					if(i == 2 && (map[nr][nc] == 2 
							|| map[nr][nc] == 6 
							|| map[nr][nc] == 7)) continue;
					// 우인 경우 조건
					if(i == 3 && (map[nr][nc] == 2 
							|| map[nr][nc] == 4 
							|| map[nr][nc] == 5)) continue;
					
					q.offer(new pos(nr, nc, p.t+1));
					isVisited[nr][nc] = true;
				}	
				break;
			case 4: // 상우
				for (int i = 0; i < 4; i+=3) {
					int nr = p.r + dirR[i];
					int nc = p.c + dirC[i];
					
					if(nr<0 || nc<0 || nr>=N || nc>= M 
							|| isVisited[nr][nc] 
							|| map[nr][nc] == 0) continue;
					// 상인 경우 조건
					if(i == 0 && (map[nr][nc] == 3 
							|| map[nr][nc] == 4 
							|| map[nr][nc] == 7)) continue;
					// 우인 경우 조건
					if(i == 3 && (map[nr][nc] == 2 
							|| map[nr][nc] == 4 
							|| map[nr][nc] == 5)) continue;
					
					q.offer(new pos(nr, nc, p.t+1));
					isVisited[nr][nc] = true;
				}	
				break;
			case 5: // 하우
				for (int i = 1; i < 4; i+=2) {
					int nr = p.r + dirR[i];
					int nc = p.c + dirC[i];
					
					if(nr<0 || nc<0 || nr>=N || nc>= M 
							|| isVisited[nr][nc] 
							|| map[nr][nc] == 0) continue;
					// 하인 경우 조건
					if(i == 1 && (map[nr][nc] == 3 
							|| map[nr][nc] == 5 
							|| map[nr][nc] == 6)) continue;
					// 우인 경우 조건
					if(i == 3 && (map[nr][nc] == 2 
							|| map[nr][nc] == 4 
							|| map[nr][nc] == 5)) continue;
					
					q.offer(new pos(nr, nc, p.t+1));
					isVisited[nr][nc] = true;
				}
				break;
			case 6: // 하좌
				for (int i = 1; i < 3; i++) {
					int nr = p.r + dirR[i];
					int nc = p.c + dirC[i];
					
					if(nr<0 || nc<0 || nr>=N || nc>= M 
							|| isVisited[nr][nc] 
							|| map[nr][nc] == 0) continue;
					// 하인 경우 조건
					if(i == 1 && (map[nr][nc] == 3 
							|| map[nr][nc] == 5 
							|| map[nr][nc] == 6)) continue;
					// 좌인 경우 조건
					if(i == 2 && (map[nr][nc] == 2 
							|| map[nr][nc] == 6 
							|| map[nr][nc] == 7)) continue;
					
					q.offer(new pos(nr, nc, p.t+1));
					isVisited[nr][nc] = true;
				}
				break;
			case 7: // 상좌
				for (int i = 0; i < 4; i+=2) {
					int nr = p.r + dirR[i];
					int nc = p.c + dirC[i];
					
					if(nr<0 || nc<0 || nr>=N || nc>= M 
							|| isVisited[nr][nc] 
							|| map[nr][nc] == 0) continue;
					// 상인 경우 조건
					if(i == 0 && (map[nr][nc] == 3 
							|| map[nr][nc] == 4 
							|| map[nr][nc] == 7)) continue;
					// 좌인 경우 조건
					if(i == 2 && (map[nr][nc] == 2 
							|| map[nr][nc] == 6 
							|| map[nr][nc] == 7)) continue;
					
					q.offer(new pos(nr, nc, p.t+1));
					isVisited[nr][nc] = true;
				} 
				break;
			}
		}
	}

}
