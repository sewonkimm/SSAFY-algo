package com.week7;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2309_일곱난쟁이 {

	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		int[] input = new int[9];
		int sum = 0;
		for(int i=0; i<9; i++) {
			input[i] = sc.nextInt();
			sum += input[i];
		}
		
		Arrays.sort(input);
		
		// 전체에서 2명의 키를 뺐을 때 100이 나오면 출력 
		for(int i=0; i<9; i++) {
			for(int j=i+1; j<9; j++) {
				if(sum - input[i] - input[j] == 100) {
					
					// output
					for(int k=0; k<9; k++) {
						if(k!=i && k!=j)	System.out.println(input[k]);
					}
					sc.close();
					return;
				}
			}
		}
	}

}
