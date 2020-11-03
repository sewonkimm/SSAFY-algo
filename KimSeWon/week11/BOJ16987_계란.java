package com.week11;

import java.util.Scanner;

public class BOJ16987_계란 {

	static int N, answer;
	static Egg[] eggs;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		answer = 0;
		
		N = sc.nextInt();
		eggs = new Egg[N];
		for(int i=0; i<N; i++) {
			int s = sc.nextInt();
			int w = sc.nextInt();
			eggs[i] = new Egg(s, w);
		}
		go(0, 0);
		
		System.out.println(answer);
		sc.close();
	}

	public static void go(int cur, int cnt) {
		if(cur == N) {
			answer = Math.max(answer, cnt);
			return;
		}
		
		if(eggs[cur].strength <= 0) {	// 현재 들고있는 계란이 깨졌으면 다음으로 넘어감
			go(cur+1, cnt);
		}
		else {
			boolean flag = false;	// 내려 쳤는가?
			
			for(int i=0; i<N; i++) {
				if(cur == i || eggs[i].strength <= 0)	continue;	// 들고있는 계란 or 깨진 계란이면 skip
				
				eggs[cur].strength -= eggs[i].weight;
				eggs[i].strength -= eggs[cur].weight;
				flag = true;
				
				int tmpCnt = 0;
				if(eggs[cur].strength <= 0)	tmpCnt++;
				if(eggs[i].strength <= 0)	tmpCnt++;
				
				go(cur+1, cnt+tmpCnt);
				
				// 초기화
				eggs[cur].strength += eggs[i].weight;
				eggs[i].strength += eggs[cur].weight;
			}
			
			if(!flag)	go(cur+1, cnt);
		}
	}
	
	public static class Egg {
		int strength, weight;
		
		public Egg(int strength, int weight) {
			this.strength = strength;
			this.weight = weight;
		}
	}
}
