/*
 * BJ 15683 감시 => 실패
 * 시뮬레이션
 * 감시할 수 있는 영역의 최대를 구하면 사각지대의 최소값을 구하는 것이 된다.
 * 따라서, 5 -> 4 -> 3 -> 2 -> 1 의 순서로 CCTV가 확인할 수 있는 영역을 확인
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_15683_watch {

	// 세로, 가로
	static int N, M, answer;
	// 사무실 정보
	static int[][] officer;
	// delta
	static int[] dirR = { -1, 0, 1, 0 };
	static int[] dirC = { 0, 1, 0, -1 };

	static class CCTV implements Comparable<CCTV> {
		int r, c, count;
		int[] dir;

		public CCTV(int r, int c, int count, int[] dir) {
			super();
			this.r = r;
			this.c = c;
			this.count = count;
			this.dir = dir;
		}

		@Override
		public int compareTo(CCTV o) {
			return o.count - this.count;
		}
	}

	static ArrayList<CCTV> arr = new ArrayList<CCTV>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		officer = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				officer[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 각 CCTV를 확인하고 최대가 될 수 있는 방향과 값을 저장해둔다.
		for (int n = 5; n >= 1; n--) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (officer[i][j] == n) {
						check(i, j, officer[i][j]);
						
						CCTV c = arr.get(0);
						for (int K = 0; K < c.dir.length; K++) {
							int nr = c.r;
							int nc = c.c;
							while(true) {
								nr += dirR[c.dir[K]];
								nc += dirC[c.dir[K]];
								
								if (nr < 0 || nc < 0 || nr >= N || nc >= M || officer[nr][nc] == 6) break;
								
								if(officer[nr][nc] == 0 ) officer[nr][nc] = 9;
							}
						}	
						arr.clear();
					}
				}
			}
		}
		// 사각 지대 확인
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (officer[i][j] == 0) answer++;
			}
		}
		System.out.println(answer);
	}

	private static void check(int r, int c, int no) {
		int max = Integer.MIN_VALUE;
		int[] dir;
		int cnt = 0;
		switch (no) {
		case 1: // 1번
			dir = new int[1];
			for (int i = 0; i < 4; i++) {
				cnt = 0;
				int nr = r;
				int nc = c;
				while (true) {
					nr += dirR[i];
					nc += dirC[i];
					// 범위를 벗어나거나 벽을 만나게 되면 그만
					if (nr < 0 || nc < 0 || nr >= N || nc >= M || officer[nr][nc] == 6) break;
					// 다른 CCTV를 만난 경우
					if (officer[nr][nc] == 0) cnt++;
				}
				if (cnt > max) {
					max = cnt;
					dir[0] = i;
				}
			}
			arr.add(new CCTV(r, c, max, dir));
			break;
		case 2: // 2번 -> 직선 (0,2) (1,3)
			dir = new int[2];
			cnt = 0;
			for (int i = 0; i < 2; i++) {
				int plusR = r;
				int plusC = c;
				int minusR = r;
				int minusC = c;
				while (true) {
					plusR += dirR[i];
					plusC += dirC[i];

					if (plusR < 0 || plusC < 0 || plusR >= N || plusC >= M || officer[plusR][plusC] == 6) break;

					if (officer[plusR][plusC] == 0) cnt++;
				}
				while (true) {
					minusR += dirR[i+2];
					minusC += dirC[i+2];

					if (minusR < 0 || minusC < 0 || minusR >= N || minusC >= M || officer[minusR][minusC] == 6) break;

					if (officer[minusR][minusC] == 0) cnt++;
				}
				if (cnt > max) {
					max = cnt;
					dir[0] = i;
					dir[1] = i + 2;
				}
			}
			arr.add(new CCTV(r, c, cnt, dir));
			break;
		case 3: // 3번 -> 수직 (0,1) (1,2) (2,3) (3,0)
			dir = new int[2];
			cnt = 0;
			for (int i = 0; i < 4; i++) {
				int nr = r;
				int nc = c;
				int mr = r;
				int mc = c;
				while (true) {
					nr += dirR[i];
					nc += dirC[i];

					if (nr < 0 || nc < 0 || nr >= N || nc >= M || officer[nr][nc] == 6) break;

					if (officer[nr][nc] == 0) cnt++;
				}
				while (true) {
					mr += dirR[(i+1) % 4];
					mc += dirC[(i+1) % 4];

					if (mr < 0 || mc < 0 || mr >= N || mc >= M || officer[mr][mc] == 6) break;

					if (officer[mr][mc] == 0) cnt++;
				}
				if (cnt > max) {
					max = cnt;
					dir[0] = i;
					dir[1] = (i + 1) % 4;
				}
			}
			arr.add(new CCTV(r, c, cnt, dir));
			break;
		case 4: // 4번 -> ㅗ, ㅏ, ㅜ, ㅓ
			dir = new int[3];
			cnt = 0;
			for (int i = 0; i < 4; i++) {
				int nr = r;
				int nc = c;
				int mr = r;
				int mc = c;
				int or = r;
				int oc = c;
				while (true) {
					nr += dirR[i];
					nc += dirC[i];

					if (nr < 0 || nc < 0 || nr >= N || nc >= M || officer[nr][nc] == 6) break;

					if (officer[nr][nc] == 0) cnt++;
				}
				while (true) {
					mr += dirR[(i+1) % 4];
					mc += dirC[(i+1) % 4];

					if (mr < 0 || mc < 0 || mr >= N || mc >= M || officer[mr][mc] == 6) break;

					if (officer[mr][mc] == 0) cnt++;
				}
				while (true) {
					or += dirR[(i+2) % 4];
					oc += dirC[(i+2) % 4];

					if (or < 0 || oc < 0 || or >= N || oc >= M || officer[or][oc] == 6) break;

					if (officer[or][oc] == 0) cnt++;
				}
				if (cnt > max) {
					max = cnt;
					dir[0] = i;
					dir[1] = (i + 1) % 4;
					dir[2] = (i + 2) % 4;
				}
			}
			arr.add(new CCTV(r, c, cnt, dir));
			break;
		case 5: // 5번
			dir = new int[] { 0, 1, 2, 3 };
			cnt = 0;
			for (int i = 0; i < 4; i++) {
				int nr = r;
				int nc = c;
				while (true) {
					nr += dirR[i];
					nc += dirC[i];
					// 범위를 벗어나거나 벽을 만나게 되면 그만
					if (nr < 0 || nc < 0 || nr >= N || nc >= M || officer[nr][nc] == 6) break;
					// 다른 CCTV를 만난 경우
					if (officer[nr][nc] == 0) cnt++;
				}
			}
			arr.add(new CCTV(r, c, cnt, dir));
			break;
		}
	}

}
