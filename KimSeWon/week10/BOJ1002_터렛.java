package com.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1002_터렛 {

	public static class Pos{
		int x, y, r;

		public Pos(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			Pos posA = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Pos posB = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			
			// 원 교차점 종류
			// 1. 두점에서 만남 => 2개
			// 2. 한점에서 교차 => 1개
			// 3. 만나지 않음 => 0 개
			// 4. 같은 원 => 무한개
			
			int dis = pow(Math.abs(posA.x-posB.x)) + pow(Math.abs(posA.y-posB.y));	// 중점사이의 거리
			int add = pow(posA.r + posB.r);
			int sub = pow(posA.r - posB.r);
			
			if(dis == 0) {
				if(posA.r == posB.r)	System.out.println(-1);
				else 					System.out.println(0);
			}
			else if(dis > add || dis < sub) {
				System.out.println(0);
			}
			else if(dis == add || dis == sub) {
				System.out.println(1);
			}
			else if(dis < add || dis > sub) {
				System.out.println(2);
			}
			
		} // end of while
	}
	
	private static int pow(int i) {
		return i*i;
	}

}

