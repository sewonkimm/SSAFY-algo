/*
 * SWEA 4014 활주로 건설
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4014_RunwayConstruction {
	
	static int N, X, result;
	static int[][] map;
	static boolean[][] isUsed;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCaseNum = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		for (int t = 1; t <= testCaseNum; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // Map의 크기 
			X = Integer.parseInt(st.nextToken()); // 경사로의 길이
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			isUsed = new boolean[N][N];
			result = 0;
			
			// 상, 하 확인
			for (int c = 0; c < N; c++) {
				boolean check = false;
				for (int r = 0; r < N-1; r++) {
					if(Math.abs(map[r][c] - map[r+1][c]) == 1) {
						if(map[r][c] > map[r+1][c]) {
							for (int i = 0; i < X; i++) {
								int nr = r+1+i;
								if(nr >= N || map[nr][c] != map[r+1][c] || isUsed[nr][c]) {
									check = true;
									break;
								}
								isUsed[nr][c] = true;
							}
						}else if(map[r][c] < map[r+1][c]) {
							for (int i = 0; i < X; i++) {
								int nr = r-i;
								if(nr < 0 || map[nr][c] != map[r][c] || isUsed[nr][c]) {
									check = true;
									break;
								}
								isUsed[nr][c] = true;
							}
						}
					}else if(Math.abs(map[r][c] - map[r+1][c]) > 1) {
						check = true;
						break;
					}
				}
				if(!check) result++;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					isUsed[i][j] = false;
				}
			}
			
			// 좌, 우 확인
			for (int r = 0; r < N; r++) {
				boolean check = false;
				for (int c = 0; c < N-1; c++) {
					if(Math.abs(map[r][c] - map[r][c+1]) == 1) {
						if(map[r][c] > map[r][c+1]) {
							for (int i = 0; i < X; i++) {
								int nc = c+1+i;
								if(nc>=N || map[r][nc] != map[r][c+1] || isUsed[r][nc]) {
									check = true;
									break;
								}
								isUsed[r][nc] = true;
							}
						}else if(map[r][c] < map[r][c+1]) {
							for (int i = 0; i < X; i++) {
								int nc = c-i;
								if(nc<0 || map[r][nc] != map[r][c] || isUsed[r][nc]) {
									check = true;
									break;
								}
								isUsed[r][nc] = true;
							}
						}
					}else if(Math.abs(map[r][c] - map[r][c+1]) > 1) {
						check = true;
						break;
					}
				}
				if(!check) result++;
			}
			
			System.out.println("#" + t + " " + result);
		}
	}

}
