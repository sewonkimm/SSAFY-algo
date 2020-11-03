package com.week11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 자기보다 작은 사람 수 + 자기보다 큰 사람 수 + 1 = 전체 학생 수(N)
 */


public class SWEA5643_키순서 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int TC = 1; TC <= T; TC++) {
			
			int N = sc.nextInt();	// 학생들의 수
			int M = sc.nextInt(); 	// 키 비교 횟수
			
			Student[] students = new Student[N+1];
			for (int i = 1; i <= N; i++) {
				students[i] = new Student();
			}

			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				students[a].up.add(b);
				students[b].down.add(a);				
			}
			

			int cnt = 0;	// 자신의 키가 몇번째인지 알 수 있는 학생 수
			for (int i = 1; i <= N; i++) {
				int up, down;
				up = down = 0;
				
				Queue<Integer> qUp = new LinkedList<Integer>();
				qUp.add(i);
				boolean[] visitUp = new boolean[N+1];
				visitUp[i] = true;
				
				while(!qUp.isEmpty()) {
					int now = qUp.poll();
					for(int k=0; k<students[now].up.size(); k++) {
						int next = students[now].up.get(k);
						if(!visitUp[next]) {
							++up;
							qUp.add(next);
							visitUp[next] = true;
						}
					}
				}

				Queue<Integer> qDown = new LinkedList<Integer>();
				qDown.add(i);
				boolean[] visitDown = new boolean[N+1];
				visitDown[i] = true;
				
				while(!qDown.isEmpty()) {
					int now = qDown.poll();
					for(int k=0; k<students[now].down.size(); k++) {
						int next = students[now].down.get(k);
						if(!visitDown[next]) {
							++down;
							qDown.add(next);
							visitDown[next] = true;
						}
					}
				}
				
				if(up + down == N-1)	++cnt;
			}
			System.out.println("#"+TC+" "+cnt);
		} // end TC
		sc.close();
	} // end main

	public static class Student{
		ArrayList<Integer> down = new ArrayList<Integer>();
		ArrayList<Integer> up = new ArrayList<Integer>();
	}
}
