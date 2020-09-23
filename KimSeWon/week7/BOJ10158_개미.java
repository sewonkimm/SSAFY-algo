package com.week7;

import java.util.Scanner;

public class BOJ10158_개미 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int p = sc.nextInt();
		int q = sc.nextInt();
		int t = sc.nextInt();
		
		int x = w-p;
		if(t-x <=0) {
			p += t;
		}
		else {
			if(((t-x)/w) %2 == 0){
				p = w - ((t-x)%w);
			}
			else p = 0 + ((t-x)%w);
		}
		
		
		int y = h-q;
		if(t-y <= 0) {
			q += t;
		}
		else {
			if(((t-y)/h) %2 == 0){
				q = h - ((t-y)%h);
			}
			else q = 0 + ((t-y)%h);
		}
		
		System.out.println(p+" "+q);
		sc.close();
	}

}
