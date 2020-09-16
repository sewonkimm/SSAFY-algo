package com.week4;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1342_행운의문자열 {

	static char[] input;
	static int cnt;
	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		input = new char[str.length()];
		for(int i=0; i<str.length(); i++) {
			input[i] = str.charAt(i);
		}
		
		Arrays.sort(input);
		
		do {
			// 행운의 문자열인지 검사
			boolean flag = true;
			for(int i=0; i<input.length-1; i++) {
				if(input[i] == input[i+1]) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				cnt++;
			}
		}while(nextPermutation());
		
		//output
		System.out.println(cnt);
	}

	private static boolean nextPermutation() {
		int i = input.length-1;
		while(i>0 && input[i-1] >= input[i]) {
			--i;
		}
		if(i == 0)	return false;
		
		int j = input.length-1;
		while(input[i-1] >= input[j]) {
			--j;
		}
		
		swap(i-1, j);
		
		int k = input.length-1;
		while(i < k) {
			swap(i++, k--);
		}
		
		return true;
	}
	private static void swap(int i, int j) {
		char tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}
}
