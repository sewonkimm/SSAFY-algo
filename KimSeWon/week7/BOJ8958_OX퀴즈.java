package com.week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ8958_OX퀴즈 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		while(testCase-- > 0) {
			String quizResult = br.readLine();
			
			int score = 1;
			int sum = 0;
			for(int i=0; i<quizResult.length(); i++) {
				if(quizResult.charAt(i) == 'X') {
					score = 1;
				}
				else {
					sum += score++;
				}		
			}
			
			System.out.println(sum);
		}

	}

}
