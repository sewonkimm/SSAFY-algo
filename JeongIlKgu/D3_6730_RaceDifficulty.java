/*
 * D3 6730 장애물 경주 난이도
 * 각 테스트 케이스마다 입력을 받으면서
 * 1) i > i+1 이면 내리막 난이도 비교
 * 2) i < i+1 이면 오르막 난이도 비교
 * 1)과 2)의 최대값 찾기
 */

package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_6730_RaceDifficulty {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(in.readLine()," ");
			int N = Integer.parseInt(st.nextToken()); // 계단 갯수
			int UpMax = 0; // 오르막 최대
			int DownMax = 0; // 내리막 최대
			st = new StringTokenizer(in.readLine()," ");
			int num = Integer.parseInt(st.nextToken()); // 앞
			for (int i = 0; i < N-1; i++) {
				int temp = Integer.parseInt(st.nextToken()); // 뒤 
				if(num > temp) { // 내리막
					if(DownMax < (num - temp)) DownMax = num - temp;
				}else if(num < temp) { // 오르막
					if(UpMax < (temp - num)) UpMax = temp - num;
				}
				// 앞의 장애물을 뒤의 장애물로 바꿔주기
				num = temp;
			}
			System.out.println("#"+t+" "+UpMax+" "+DownMax);
		}	
	}

}
