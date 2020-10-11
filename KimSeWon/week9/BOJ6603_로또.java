package com.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 49개 중 6개를 뽑아서 -> 집합 S에 있는 수만 고르는 것보다
// 집합 S 중 6개 뽑는 것이 훨씬 효율적이다.
// k의 범위가 6~13이기 때문에 경우의 수를 많이 줄일 수 있다.

public class BOJ6603_로또 {

	static int k;
	static int[] s;
	static int[] comb = new int[6];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			k = Integer.parseInt(st.nextToken());
			if(k == 0)	return;	// 프로그램 종료
			
			s = new int[k];
			for(int i=0; i<k; i++) {
				s[i] = Integer.parseInt(st.nextToken());
			}
			
			lotto(0, 0);
			System.out.println();
		}
	}
	
	private static void lotto(int cur, int depth) {
		if(cur == 6) {	// 6개를 다 뽑았을 때
			for(int i=0; i<6; i++) {
				System.out.print(comb[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=depth; i<k; i++) {
			comb[cur] = s[i];
			lotto(cur+1, i+1);
		}
	}
}
