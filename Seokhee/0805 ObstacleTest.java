package com.ssafy;
import java.util.*;
public class ObstacleTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int n = sc.nextInt();
			int[] ob = new int[n];
			for(int i=0;i<n;i++) {
				ob[i] = sc.nextInt();
			}
			int up = 0;
			int down = 0;
			
			for(int i=0;i<n-1;i++) {
				if(ob[i]>ob[i+1]) {
					if(ob[i]-ob[i+1]>down)
						down = ob[i]-ob[i+1];
				}
				if(ob[i]<ob[i+1]) {
					if(ob[i+1]-ob[i]>up)
						up = ob[i+1]-ob[i];
				}
			}
			
			System.out.println("#"+t+" "+up+" "+down);
		}
	}
}
