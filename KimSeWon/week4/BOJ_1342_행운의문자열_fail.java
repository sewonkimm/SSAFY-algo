package com.week4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * @author sewonkimm 
 * 1. 문자열 S의 순열을 구함 
 * 2. 매 순열이 행운의 문자열인지 검사 
 * 		- 완전탐색을 하면서 인접한 문자가 같은 문자열이면 return false
 * 
 * 메모리초과!
 * 서로다른 10개의 알파벳의 행운의 문자열 순열은 362만개이기 때문...
 * => 이것을 어떻게 해결할 수 있을까...?        
 *
 */

public class BOJ1342 {

	static int[] input;

	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		// 순열을 위한 배열
		input = new int[str.length()];
		for (int i = 0; i < input.length; i++) {
			input[i] = i;
		}

		Set<String> cnt = new HashSet<String>();
		do {
			// 행운의 문자열인지 검사
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < input.length; i++) {
				sb.append(str.charAt(input[i]));
			}
			if (isLucky(sb.toString())) {
				// 중복 제거를 위해 Set에 넣음
				cnt.add(sb.toString());
			}
		} while (nextPermutation(input.length));

		// output
		System.out.println(cnt.size());
		sc.close();
	}

	public static boolean isLucky(String str) {

		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1))
				return false;
		}
		return true;
	}

	public static boolean nextPermutation(int n) {
		int i = n - 1;
		while (i > 0 && input[i - 1] > input[i]) {
			--i;
		}

		if (i == 0)
			return false;

		int j = n - 1;
		while (input[i - 1] > input[j]) {
			--j;
		}

		swap(i - 1, j);

		int k = n - 1;
		while (i < k) {
			swap(i++, k--);
		}

		return true;
	}

	public static void swap(int i, int j) {
		int tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}

}
