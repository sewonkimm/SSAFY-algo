/*
 * BJ 7569 토마토
 * 완탐으로 풀면 시간초과.. 무리한 시도! 
 * BFS로 풀어야함
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7569_Tomato {
	
	// delta
	static int[] dirX = {1,-1,0,0,0,0};
	static int[] dirY = {0,0,1,-1,0,0};
	static int[] dirZ = {0,0,0,0,1,-1};
	static int X, Y, Z; // 상자의 크기
	static int[][][] box; // 상자
	static int[][][] day; // 날짜 계산할 배열
	static class pos{
		int x, y, z;

		public pos(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	static Queue<pos> q = new LinkedList<pos>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Z = Integer.parseInt(st.nextToken());
		// box 입력 => H가 가장 큰 범위로 입력 
		box = new int[Z][X][Y];
		day = new int[Z][X][Y];
		
		for (int z = 0; z < Z; z++) {
			for (int x = 0; x < X; x++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int y = 0; y < Y; y++) {
					box[z][x][y] = Integer.parseInt(st.nextToken());
					if(box[z][x][y] == 1) { // 익은 토마토가 있는 경우, 큐에 푸시
						q.offer(new pos(x, y, z));
					}
				}
			}
		}
		
		while(!q.isEmpty()) {
			pos p = q.poll();
			int x = p.x;
			int y = p.y;
			int z = p.z;
			
			for (int i = 0; i < 6; i++) {
				int nx = x + dirX[i];
				int ny = y + dirY[i];
				int nz = z + dirZ[i];
				// 범위에서 벗어난 경우 처리
				if(nx<0 || ny<0 || nz<0 || nx>=X || ny>=Y || nz>=Z) continue;
				// 익지 않은 토마토이고 방문한 적이 없을 때
				if(box[nz][nx][ny] == 0 && day[nz][nx][ny] == 0) {
					q.offer(new pos(nx, ny, nz));
					day[nz][nx][ny] = day[z][x][y] + 1; // 하루가 더 걸린 것 
				}
			}
		}
		
		// 최대 날짜
		int answer = 0;
		for (int z = 0; z < Z; z++) {
			for (int x = 0; x < X; x++) {
				for (int y = 0; y < Y; y++) {
					if(answer < day[z][x][y]) answer = day[z][x][y];
				}
			}
		}
		// 익지 않은 토마토가 있는지 확인
		for (int z = 0; z < Z; z++) {
			for (int x = 0; x < X; x++) {
				for (int y = 0; y < Y; y++) {
					if(box[z][x][y] == 0 && day[z][x][y] == 0) answer = -1;
				}
			}
		}
		System.out.println(answer);
	}
}