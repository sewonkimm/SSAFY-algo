package com.week7;

import java.util.Scanner;

public class BOJ2564_경비원 {

	public static class Store {
		int dir, loc;

		public Store(int dir, int loc) {
			this.dir = dir;
			this.loc = loc;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt(); // 가로
		int y = sc.nextInt(); // 세로

		// 상점들의 위치
		int n = sc.nextInt();
		Store[] store = new Store[n];
		for (int i = 0; i < n; i++) {
			int dir = sc.nextInt();
			int loc = sc.nextInt();
			store[i] = new Store(dir, loc);
		}

		// 동근이의 위치
		int dir = sc.nextInt();
		int loc = sc.nextInt();
		Store start = new Store(dir, loc);

		int sum = 0;
		for (int i = 0; i < n; i++) {
			Store s = store[i];

			if (start.dir == s.dir) { // 같은 라인에 있는 경우
				if (s.loc - start.loc > 0) {
					sum += s.loc - start.loc;
				} else {
					sum += start.loc - s.loc;
				}
			} else { // 같은 라인에 없는 경우
				int diff = Math.abs(start.loc - s.loc);
				if (start.dir + s.dir == 3) { // 남북
					if (s.loc - start.loc > 0) {
						int clockwise = diff + (start.loc * 2) + y; // 시계방향
						int counterClockwise = diff + ((x - s.loc) * 2) + y; // 반시계방향
						sum += Math.min(clockwise, counterClockwise);
					} else {
						int clockwise = diff + (s.loc * 2) + y; // 시계방향
						int counterClockwise = diff + ((x - start.loc) * 2) + y; // 반시계방향
						sum += Math.min(clockwise, counterClockwise);
					}
				} else if (start.dir + s.dir == 7) { // 동서
					if (s.loc - start.loc > 0) {
						int clockwise = diff + (start.loc * 2) + x; // 시계방향
						int counterClockwise = diff + ((y - s.loc) * 2) + x; // 반시계방향
						sum += Math.min(clockwise, counterClockwise);
					} else {
						int clockwise = diff + ((y - start.loc) * 2) + x; // 시계방향
						int counterClockwise = diff + (s.loc * 2) + x; // 반시계방향
						sum += Math.min(clockwise, counterClockwise);
					}
				}
				else if (start.dir + s.dir == 4) { // 2사분면 -> 무조건 시계방향
					sum += start.loc + s.loc;
				}
				else if (start.dir + s.dir == 6) { // 4사분면 -> 무조건 반시계방향
					if(start.dir == 2 && s.dir == 4) {
						sum += x-start.loc + y-s.loc;
					}
					else {
						sum += y-start.loc + x-s.loc;
					}
				}
				else if (start.dir + s.dir == 5) {
					// 1사분면 -> 시계방향
					if(start.dir == 1 && s.dir == 4) {
						sum += x-start.loc + s.loc;
					}
					else if(start.dir == 4 && s.dir == 1){
						sum += start.loc + x-s.loc;
					}
					
					// 3사분면 -> 반시계방향
					else if(start.dir == 2 && s.dir == 3){
						sum += start.loc + y-s.loc;
					}
					else if(start.dir == 3 && s.dir == 2){
						sum += y-start.loc + s.loc;
					}
				}

			}
		}

		System.out.println(sum);
		sc.close();
	}

}
