package com.week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BOJ1874 {

	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}

		Stack<Integer> stack = new Stack<Integer>();
		List<Character> answer = new ArrayList<Character>();

		int idx = 0;
		for (int i = 1; i <= n; i++) {

			stack.add(i);
			answer.add('+');

			while (!stack.isEmpty() && input[idx] == stack.peek()) {
				stack.pop();
				answer.add('-');
				idx++;
			}
		}

		// output
		if (!stack.isEmpty()) {
			System.out.println("NO");
		} else {
			for (char ch : answer) {
				System.out.println(ch);
			}
		}
		sc.close();
	}

}
