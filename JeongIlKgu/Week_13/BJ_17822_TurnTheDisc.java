/*
 * BJ 17822 원판 돌리기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17822_TurnTheDisc {

	// 가장 큰 원판의 반지름, 정수의 개수, 돌리는 횟수
	static int N, M, T;
	// 배수를 결정할 수, 방향(0:시계, 1:반시계), 몇 칸 회전할지
	static int x, d, k;
	// 원판
	static int[][] disc;
	static boolean[][] isNear; // 인접하는 것 체크
	static boolean check; // 인접한 것이 있다면 true
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		disc = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				disc[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// T번만큼 회전
		for (int i = 0; i < T; i++) {
			isNear = new boolean[N][M];
			check = false;
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			// 회전
			turn(x,d,k);
			// 수가 남아있다면 
			if(isExist()) {
				// 각각 확인하면서 인접하는지 체크 후 한번에 지우기
				// 원끼리 확인
				for (int r = 0; r < N; r++) {
					if(disc[r][0] != 0 && disc[r][M-1] != 0 && disc[r][0] == disc[r][M-1]) {
						isNear[r][0] = true;
						isNear[r][M-1] = true;
					}
					for (int c = 0; c < M-1; c++) {
						if(disc[r][c] != 0 && disc[r][c+1] != 0 && disc[r][c] == disc[r][c+1]) {
							isNear[r][c] = true;
							isNear[r][c+1] = true;
						}
					}
				}
				// 판끼리 확인
				for (int c = 0; c < M; c++) {
					if(disc[0][c] != 0 && disc[1][c] != 0 && disc[0][c] == disc[1][c]) {
						isNear[0][c] = true;
						isNear[1][c] = true;
					}
					if(disc[N-1][c] != 0 && disc[N-2][c] != 0 && disc[N-1][c] == disc[N-2][c]) {
						isNear[N-1][c] = true;
						isNear[N-2][c] = true;
					}
					for (int r = 1; r < N-1; r++) {
						if(disc[r][c] != 0 && disc[r-1][c] != 0 && disc[r][c] == disc[r-1][c]) {
							isNear[r][c] = true;
							isNear[r-1][c] = true;
						}
						if(disc[r][c] != 0 && disc[r+1][c] != 0 && disc[r][c] == disc[r+1][c]) {
							isNear[r][c] = true;
							isNear[r+1][c] = true;
						}
					}
				}
				// 인접한 수 모두 지우기 
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < M; k++) {
						if(isNear[j][k]) {
							disc[j][k] = 0;
							check = true;
						}
					}
				}
				// 인접한 수가 없는 경우
				if(!check) {
					// 평균 계산
					double sum = 0;
					int count = 0;
					for (int j = 0; j < N; j++) {
						for (int k = 0; k < M; k++) {
							if(disc[j][k] > 0) {
								sum += disc[j][k];
								count++;
							}
						}
					}
					double avg = sum/count;
					// 평균보다 큰 수: -1, 작은 수: +1
					for (int j = 0; j < N; j++) {
						for (int k = 0; k < M; k++) {
							if(disc[j][k] == 0) continue;
							
							if(disc[j][k] > avg) {
								disc[j][k]--;
							}else if(disc[j][k] < avg) {
								disc[j][k]++;
							}
						}
					}
				}
			}
		}
		
		int answer = 0;
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				answer += disc[j][k];
			}
		}
		System.out.println(answer);
	}

	public static void turn(int div, int dir, int cnt) {
		for (int i = div; i <= N; i += div) {
			if (dir == 0) { // 시계 방향 -> 뒤로
				for (int j = 0; j < cnt; j++) {
					int temp = disc[i - 1][M - 1];
					for (int k = M - 1; k >= 1; k--) {
						disc[i - 1][k] = disc[i - 1][k - 1];
					}
					disc[i - 1][0] = temp;
				}
			}

			if (dir == 1) { // 반시계 방향 -> 앞으로
				for (int j = 0; j < cnt; j++) {
					int temp = disc[i - 1][0];
					for (int k = 0; k < M - 1; k++) {
						disc[i - 1][k] = disc[i - 1][k + 1];
					}
					disc[i - 1][M - 1] = temp;
				}
			}
		}
	}
	
	public static boolean isExist() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(disc[i][j] > 0) return true;
			}
		}
		return false;
	} 
}

/*
2 2 1
2 1
1 3
2 0 1
 */
