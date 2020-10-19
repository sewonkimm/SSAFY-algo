package com.week10;

import java.util.Scanner;

public class BOJ1475_방번호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine();	// 방번호
		int[] numArr = new int[10];
		
		for(int i=0; i<num.length(); i++) {
			if(num.charAt(i) == '6' || num.charAt(i) == '9') {
				if(numArr[6] < numArr[9])	numArr[6]++;
				else numArr[9]++;
			}
			else {
				numArr[num.charAt(i)-'0']++;
			}
		}
		
		int cnt = 0;	// 필요한 세트의 갯수
		for(int i=0; i<10; i++) {
			cnt = Math.max(cnt, numArr[i]);
		}
		
		System.out.println(cnt);
		sc.close();
	}

}
