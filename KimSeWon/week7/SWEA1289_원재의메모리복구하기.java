package com.week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA1289_원제의메모리복구하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int TC=1; TC<=T; TC++) {
			// input
			String str = br.readLine();
			int cnt = 0;
			
			boolean isOne = false;
			for(int i=0; i<str.length(); i++) {
				if(!isOne && str.charAt(i) == '1') {
					cnt++;
					isOne = true;
				}
				else if(isOne && str.charAt(i) == '0') {
					cnt++;
					isOne = false;
				}
			}
			
			// output
			System.out.println("#"+TC+" "+cnt);
		}
	}

}
