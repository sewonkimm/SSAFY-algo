package com.week7;

import java.util.Scanner;

public class BOJ13300_방배정 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int[][] school = new int[7][2];	// [i][0]: i학년의 여학생 수, [i][1]: i학년의 남학생 수 
		for (int i = 0; i < N; i++) {
			int gender = sc.nextInt();
			int grade = sc.nextInt();
			school[grade][gender]++;
		}

		int cnt = 0;
		for (int i = 1; i <= 6; i++) {	
			for(int j=0; j <2; j++) {
				
				if(school[i][j] == 0) 	continue;	// 학생이 없으면 방배정하지 않음
				
				if (school[i][j] < K) {
					cnt++;	// 최대 인원보다 학생 수가 적으면 1개 배정 
				} else {	// 최대 인원보다 학생 수가 많은 경우
					if(school[i][j] % K == 0)	cnt += school[i][j] / K;
					else 						cnt += school[i][j] / K + 1;	// 남은학생이 있으므로 방 1개 더 배정
				}
			}
		}

		System.out.println(cnt);
		sc.close();
	}

}
