package com.week3;

import java.util.Scanner;

/**
 * 
 * @author sewonkimm
 * - 두 사람이 대결하는지 판단 (둘의 번호가 같을 때 대결)
 * - 대결하면 라운드 번호 출력
 * - 대결하지 않으면
 * 		- 짝수일 때 다음 번호는 n/2
 * 		- 홀수일 때 다음 번호는 (n/2)+1
 *
 */
public class Q1057 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int round = 0;
		
		while(a != b) {
			round++;
			
			a = next(a);
			b = next(b);
		}
		
		System.out.println(round);
	}
	
	public static int next(int x) {
		return (x%2 == 0) ? x/2 : (x/2) + 1; 
	}

}
