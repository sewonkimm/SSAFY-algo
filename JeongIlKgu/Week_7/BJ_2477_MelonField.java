/*
 * BJ 2477 참외밭
 * 가로의 최대 최소, 세로의 최대 최소를 구한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2477_MelonField {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(in.readLine()); // 1m^2당 참외 수
		StringTokenizer st;
		int[] length = new int[6];
		int dir = 0, len = 0;
		int startDir = 0;
		int weightMax = Integer.MIN_VALUE, weightMin = 0;
		int heightMax = Integer.MIN_VALUE, heightMin = 0;
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			dir = Integer.parseInt(st.nextToken());
			len = Integer.parseInt(st.nextToken());
			length[i] = len;
			if(i == 0) startDir = dir;
			// 가로 길이 계산 weight
			if(dir == 1 || dir == 2) weightMax = Math.max(weightMax, len);
			// 세로 길이 계산 height
			if(dir == 3 || dir == 4) heightMax = Math.max(heightMax, len);
		}
		// 최소값 구하기 => 시작이 가로
		if(startDir == 1 || startDir == 2) {
			for (int i = 0; i < 6; i++) {
				int prev = i - 1;
				if(prev < 0) prev = 5;
				int next = (i+1) % 6;
				// 가로
				if(i % 2 == 0) {
					if(length[i] == weightMax) continue;
					if(length[prev] == heightMax || length[next] == heightMax) {
						weightMin = weightMax - length[i];
					}
				}
				// 세로
				if(i % 2 == 1) {
					if(length[i] == heightMax) continue;
					if(length[prev] == weightMax || length[next] == weightMax) {
						heightMin = heightMax - length[i];
					}
				}
			}
		}
		// 최소값 구하기 => 시작이 세로
		if(startDir == 3 || startDir == 4) {
			for (int i = 0; i < 6; i++) {
				int prev = i-1;
				if(prev < 0) prev = 5;
				int next = (i+1)%6;
				// 세로
				if(i % 2 == 0) {
					if(length[i] == heightMax) continue;
					if(length[prev] == weightMax || length[next] == weightMax) {
						heightMin = heightMax - length[i];
					}
				}
				// 가로
				if(i % 2 == 1) {
					if(length[i] == weightMax) continue;
					if(length[prev] == heightMax || length[next] == heightMax) {
						weightMin = weightMax - length[i];
					}
				}
			}
		}
		System.out.println(K * (weightMax * heightMax - weightMin * heightMin));
	}
}