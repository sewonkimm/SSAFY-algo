/*
 * SWEA D2 1940 가랏! RC카!
 * 0: 속도를 유지하는 경우 => 이전 속도 거리에 추가
 * 1: 가속하는 경우 => 가속도만큼 속도에 +하고 거리에 추가
 * 2: 감속하는 경우 => 가속도만큼 속도에 -하고 거리에 추가
 * 단, 0보다 작아지는 경우에는 0이 된다.
 */

import java.util.Scanner;

public class D2_1940_GoRCCar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		
		for (int t = 1; t <= T; t++) {
			int sec = Integer.parseInt(sc.nextLine());
			int answer = 0; // 총 이동 거리
			int v = 0; // 현재 속도
			int acc = 0; // 가속도
			for (int i = 0; i < sec; i++) {
				int mode = sc.nextInt(); // 모드
				switch (mode) {
				case 0: // 유지
					answer += v;
					break;
				case 1: // 가속
					v += (acc = sc.nextInt());
					answer += v;
					break;
				case 2: // 감속
					v -= (acc = sc.nextInt());
					if(v < 0) v = 0;
					answer += v;
					break;
				}
				sc.nextLine();
			}
			System.out.println("#"+t+" "+answer);
		}
		sc.close();
	}

}
