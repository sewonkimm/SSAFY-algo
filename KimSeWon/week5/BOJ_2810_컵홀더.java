package com.week5;

import java.util.Scanner;

public class BOJ2810_컵홀더 {

	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = sc.next();
		int cnt = 0;
		
		boolean flag = false;	// 커플석이 있는지 확인
		for(int i=0; i<N; i++) {
			if(str.charAt(i) == 'S')	cnt++;
			else {
				flag = true;
				cnt++;
				i++;
			}
		}
		
		if(flag)	cnt++;	// 커플석이 있으면 +1
		
		// output
		System.out.println(cnt);
		sc.close();
	}

}
