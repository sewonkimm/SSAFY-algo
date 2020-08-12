package com.study;

import java.util.*;
import java.io.*;

/**
 * 
 * @author Sewon Kim
 * f(n) 구현
 * 1. sum += n%10
 * 2. 다음 자릿수로 넘어갈 때 n/10 으로 만든 후 1번 반복
 * 3. sum이 한 자리수이면 종료, 두 자리수이면 f(n) 시작 
 * 
 * n범위 1~10^18에 의한 런타임 에러 주의!
 */

public class DigitSumTest {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int TC=1; TC<=T; TC++){
			long n = sc.nextLong(); // 입력값 nextLong() 주의!
			
			while(n / 10 != 0){
				n = f(n);
			}
			
			System.out.println("#"+TC+" "+n);
		} // end of TC

	}
	
	static long f(long n){
		int sum = 0;
		while(n/10 != 0){
			sum += n%10;
			n/=10;
		}
		sum+=n;
		return sum;
	}
}
