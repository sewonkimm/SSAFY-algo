package com.week8;

import java.util.Scanner;

public class BOJ7568_덩치 {

	public static class Person {
		int weight, height;

		public Person(int weight, int height) {
			this.weight = weight;
			this.height = height;
		}
	
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Person[] list = new Person[N];
		for(int i=0; i<N; i++) {
			int weight = sc.nextInt();
			int height = sc.nextInt();
			list[i] = new Person(weight, height);
		}
		
		// 덩치 구하기 - 브루트포스
		for(int i=0; i<N; i++) {
			int ranking = 1;
			for(int j=0; j<N; j++) {
				if(list[i].weight < list[j].weight && list[i].height < list[j].height) {
					ranking++;
				}
			}
			System.out.print(ranking+" ");
		}		
		sc.close();
	}

}
