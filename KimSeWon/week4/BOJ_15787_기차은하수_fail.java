// 런타임 에러

package com.week4;

import java.util.Scanner;

public class BOJ15787 {

	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 기차의 갯수
		int M = sc.nextInt(); // 명령어의 갯수

		int[] trains = new int[N+1];
		
		for (int i = 0; i < M; i++) {
			int cmd = sc.nextInt();

			int t, x;
			switch (cmd) {
			case 1:
				t = sc.nextInt();
				x = sc.nextInt();
				trains[t] |= (1<<x);	// 승객 승차
				break;

			case 2:
				t = sc.nextInt();
				x = sc.nextInt();
				trains[t] ^= (1<<x);	// 승객 하차
				break;
				
			case 3:
				t = sc.nextInt();
				trains[t] = trains[t] >> 1;	// 뒤로 미루기
				break;
				
			case 4:
				t = sc.nextInt();
				trains[t] = trains[t] << 1;	// 앞으로 당기기
				break;
			}
		}
		
		// 상태 기록
		int cnt = 0;
		boolean[] check = new boolean[(1<<N)+1];
		for(int i=1; i<=N; i++) {
			if(trains[i] != 0 && check[trains[i]] == false) {
				check[trains[i]] = true;
				cnt++;
			}
		}
		
		// output
		System.out.println(cnt);
		sc.close();
	}

}
