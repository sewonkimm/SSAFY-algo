/*
 * BJ 17144 미세먼지 안녕
 * 1) 방 정보를 담을 배열과 T초에 활용할 임시 배열 생성
 * 2) 인접한 4방향으로 확산을 하기 위해서는 delta를 활용
 * 2-1) 단, 공기청정기가 있거나 칸이 없다면 확산이 불가능
 * 2-2) 이때, 확산은 각각 일어나는 현상이므로 확산되어진 먼지를 생각하지 않는다. => 임시 배열에 저장
 * 3) 순환을 하는 경우, 공기청정기의 행 정보를 각각 활용한다.
 * 4) T초가 지났을 때, 방에 남은 미세먼지 양 확인
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17144_DustBye {

	static int R, C, T, answer; // 행, 열, 시간정보, 마지막으로 남은 미세먼지 양
	static int[][] room, copyRoom; // 방 정보, 임시방 정보
	static int[] machine = new int[2]; // 공기청정기의 행 정보 저장
	static int index; // 공기청정기 위치번호
	// delta
	static int[] dirR = {-1,0,1,0};
	static int[] dirC = {0,1,0,-1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		room = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if(room[i][j] == -1) machine[index++] = i;
			}
		}
		// 주어진 시간만큼 돌도록 처리
		while(T != 0) {
			// 실시간으로 변하는 방의 정보를 저장할 임시 배열
			copyRoom = new int[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					copyRoom[i][j] = 0;
				}
			}
			// 미세먼지의 확산
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					int cnt = spread(i,j);
					if(cnt != -1) copyRoom[i][j] += (room[i][j] - (room[i][j]/5)*cnt);
				}
			}
			// 미세먼지의 순환
			circle();
			// 기존 방 정보에 바뀐 방의 미세먼지 상황을 덮어씌움
			room = Arrays.copyOf(copyRoom, copyRoom.length);
			T--;
		}
		// 미세먼지 양 계산
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(room[i][j] != -1) answer += room[i][j];
			}
		}
		System.out.println(answer);
	}
	
	// 미세먼지의 확산을 담당하는 Method
	private static int spread(int r, int c) {
		int count = 0; // 몇 가지 방향으로 확산이 일어났는지
		if(room[r][c] == -1) {
			copyRoom[r][c] = -1;
			return -1;
		}
		// 4방향으로 확인하면서 확산되는 미세먼지양 계산
		for (int i = 0; i < 4; i++) {
			int nr = r + dirR[i];
			int nc = c + dirC[i];
			
			if(nr<0 || nc<0 || nr>=R || nc>=C || room[nr][nc] == -1) continue;
			
			copyRoom[nr][nc] += room[r][c]/5;
			count++;
		}
		// 몇가지 방향으로 움직였는지 return
		return count;
	}
	
	// 미세먼지의 순환을 담당하는 Method
	private static void circle() {
		// 1. 미세먼지 위 => 반시계
		for (int r = machine[0]-1; r > 0; r--) {
			copyRoom[r][0] = copyRoom[r-1][0];
		}
		for (int c = 0; c < C-1; c++) {
			copyRoom[0][c] = copyRoom[0][c+1];
		}
		for (int r = 0; r < machine[0]; r++) {
			copyRoom[r][C-1] = copyRoom[r+1][C-1];
		}
		for (int c = C-1; c > 1; c--) {
			copyRoom[machine[0]][c] = copyRoom[machine[0]][c-1];
		}
		copyRoom[machine[0]][1] = 0;
		// 2. 미세먼지 아래 => 시계
		for (int r = machine[1]+1; r < R-1; r++) {
			copyRoom[r][0] = copyRoom[r+1][0];
		}
		for (int c = 0; c < C-1; c++) {
			copyRoom[R-1][c] = copyRoom[R-1][c+1];
		}
		for (int r = R-1; r > machine[1]; r--) {
			copyRoom[r][C-1] = copyRoom[r-1][C-1];
		}
		for (int c = C-1; c > 1; c--) {
			copyRoom[machine[1]][c] = copyRoom[machine[1]][c-1];
		}
		copyRoom[machine[1]][1] = 0;
	}
}
