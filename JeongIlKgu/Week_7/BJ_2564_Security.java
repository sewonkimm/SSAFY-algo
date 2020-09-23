/*
 * BJ 2564 경비원
 * 0,0을 시작으로 시계방향으로 각 상점과 동근이의 거리를 계산하고
 * 각 상점과 동근이의 위치를 비교 -> 만약 가로 + 세로 보다 크다면 더 짧은 경로가 존재한다는 것
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2564_Security {
	
	static int[] position; // 가게랑 동근이 위치 거리
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int width = Integer.parseInt(st.nextToken()); // 가로
		int height = Integer.parseInt(st.nextToken()); // 세로
		int N = Integer.parseInt(in.readLine()); // 가게의 수
		position = new int[N+1];
		for (int i = 0; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int dir = Integer.parseInt(st.nextToken());
			int pos = Integer.parseInt(st.nextToken());
			switch (dir) {
			case 1: // 북
				position[i] = pos;
				break;
			case 2: // 남
				position[i] = 2 * width + height - pos;
				break;
			case 3: // 서
				position[i] = 2 * (width + height) - pos;
				break;
			case 4: // 동
				position[i] = width + pos;
				break;
			}
		}
		int sum = 0; // 총 거리
		// 각 상점 거리와 비교
		for (int i = 0; i < N; i++) {
			int dis = Math.abs(position[N] - position[i]);
			// 더 짧은 경로가 있는지 확인
			sum += (dis > (width + height))? 2 * (width + height) - dis : dis;
		}
		System.out.println(sum);
	}

}
