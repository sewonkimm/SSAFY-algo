package com.week3;

import java.util.Scanner;

/**
 * 
 * @author sewonkimm
 * 1. union-find 알고리즘을 이용해 입력받은 컴퓨터를 하나의 그래프로 연결
 * 2. 부모가 1인 것들의 갯수를 구하면 1번 컴퓨터때문에 웜 바이러스에 걸린 컴퓨터의 갯수를 알 수 있음
 */

public class Q2606 {

	static int N;
	static int[] parents;
	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		makeSet();
		
		int M = sc.nextInt();
		for(int i=0; i<M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			union(s, e);
		}
		
		// 1과 연결된 컴퓨터 갯수 구하기
		int answer = 0;
		for(int i=2; i<=N; i++) {
			if(find(i) == 1)	answer++;	 
		}
		System.out.println(answer);
	}
	
	public static void makeSet() {
		parents = new int[N+1];
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int x) {
		if(parents[x] == x)	return x;
		return parents[x] = find(parents[x]);
	}
	
	public static boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(px == py)	return false;	// 이미 같은 그래프

		// 루트 합치기
		if(px < py) {
			parents[py] = px;
		}
		else {
			parents[px] = py;
		}
		return true;
	} 
}
