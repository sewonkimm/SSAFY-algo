/*
 * D3 1206 View
 * 각 테스트 케이스별로 건물의 높이를 저장하고
 * 반복문을 통해 양옆 2칸과의 건물 높이를 비교한다.
 */

package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_1206_View {
	
	static int N; // 강변을 따라 이어지는 건물의 수 
	static int[] building; // 건물들의 높이를 저장할 배열
	static int result; // 조망권이 확보된 세대 수

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			// 각 건물의 높이 입력
			building = new int[N];
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++) {
				building[i] = Integer.parseInt(st.nextToken());
			}
			result = 0;
			// 각 건물 얖 옆 2칸 비교 -> 앞 2칸과 뒤 2칸은 0이므로 확인 X
			for (int i = 2; i < N-2; i++) {
				result += compare(i);
			}
			System.out.println("#"+t+" "+result);
		}
	}

	private static int compare(int b) {
		int a = 256;
		for (int i = 1; i <= 2; i++) {
			// 앞 비교
			if(building[b] > building[b-i]) {
				a = Math.min(a, building[b] - building[b-i]);
			}else {
				a = 0;
				break;
			}
			// 뒤 비교
			if(building[b] > building[b+i]) {
				a = Math.min(a, building[b] - building[b+i]);
			}else {
				a = 0;
				break;
			}
		}
		return a;
	}
}
