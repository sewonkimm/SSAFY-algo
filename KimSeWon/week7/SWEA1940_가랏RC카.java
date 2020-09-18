package com.week7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1940_RC카 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/1940_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int TC=1; TC<=T; TC++) {
			// input
			int N = Integer.parseInt(br.readLine());
			int distance = 0;	// RC카 이동거리
			int speed = 0;		// 이동 속도
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int cmd = Integer.parseInt(st.nextToken());
				if(cmd == 0) {	// 속도 유지
					distance += speed;
				}
				else {
					int spd = Integer.parseInt(st.nextToken());
					
					if(cmd == 1) {	// 가속
						speed += spd;
						distance += speed;
					}
					else if(cmd == 2) {	// 감속
						
						speed -= spd;
						if(speed < 0)	speed = 0; // 현재 속도보다 감속할 속도가 더 클 경우, 속도는 0 m/s 가 된다.
						distance += speed;
					}
				}
			}
			
			// output
			System.out.println("#"+TC+" "+distance);
		}

	}

}
