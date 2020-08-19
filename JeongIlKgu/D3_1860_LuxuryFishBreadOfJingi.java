/*
 * SWEA D3 1860 진기의 최고급 붕어빵
 * 사람이 도착하는 시간을 배열로 만들어 정렬한다.
 * 시간을 기준으로 반복을 돌린다.
 * 사람이 도착할 때, 붕어빵이 없으면 Impossible을 출력하고 종료!
 * 모든 사람이 붕어빵을 받았다면 Possible
 * 주의! => 문제는 사람이 도착하는 시간을 0초 이후라고 말하고 있지만, 0초에도 도착한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_1860_LuxuryFishBreadOfJingi {
	
	static int N, M, K, time, fishBread, n; // 사람수, 붕어빵 제조 시간, M시간에 만들어지는 붕어빵 수, 시간, 붕어빵 총 개수, 사람 Index
	static int[] persons; // 사람의 도착시간을 담는 배열

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			// 입력
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			persons = new int[N];
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++) {
				persons[i] = Integer.parseInt(st.nextToken());
			}
			// 사람의 도착 시간 정렬
			Arrays.sort(persons);
			// 초기화
			fishBread = 0;
			n = 0;
			time = 0;
			while(true) { 
				// 0은 아니고 M시간이 지나면 붕어빵 갯수 + K개
				if((time%M) == 0 && time != 0) fishBread += K;
				// 시간이 현재 기다리는 사람보다 더 지나갔을때!
				if(time >= persons[n]) {
					// 붕어빵이 모두 소진된 경우
					if(fishBread == 0) {
						System.out.println("#"+t+" Impossible");
						break;
					}
					n++;
					fishBread--;
				}
				// 사람을 모두 확인한 경우
				if(n == N) {
					System.out.println("#"+t+" Possible");
					break;
				}
				time++;
			}
		}
	}
}
