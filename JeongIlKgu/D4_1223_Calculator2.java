package com.ssafy.algo;

import java.util.Scanner;
import java.util.Stack;

public class D4_1223_Calculator2{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(sc.nextLine());
			Stack<Integer> s_int = new Stack<Integer>();
			String str = sc.nextLine();
			int plus = 0;
			int result = 0;
			
			for (int i = 0; i < N; i++) {
				if(str.charAt(i) == '+') {
					plus++;
				}
				else if(str.charAt(i) == '*') {
					s_int.push(s_int.pop() * (str.charAt(i+1)-48));
					i++;
				}else {
					s_int.push(str.charAt(i) - 48);
				}
			}
			
			for (int i = 0; i < plus+1; i++) {
				result += s_int.pop();
			}
			System.out.println("#"+t+" "+result);
		}
		sc.close();
	}

}
