package com.ssafy;
import java.util.*;
public class tournamentTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int kim = sc.nextInt();
		int lim = sc.nextInt();
		
		int cnt = 0;
		while(kim != lim) {
			kim = (kim+1) / 2;
			lim = (lim+1) / 2;
			cnt++;
		}
		System.out.println(cnt);
	}

}
