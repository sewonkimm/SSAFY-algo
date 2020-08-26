package com.ssafy;
import java.util.*;
public class tournamentTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int kim = sc.nextInt();
		int lim = sc.nextInt();
		
		int cnt = 0;
		//어느 자리에 있던 무조건 이김 -> 이기는 사람의 숫자 패턴은? (n+1)/2
		//짝수일때만 생각하고 만들었는데 어쩌다보니 홀수일때도 됨
		while(kim != lim) {
			kim = (kim+1) / 2;
			lim = (lim+1) / 2;
			cnt++;
		}
		System.out.println(cnt);
	}

}
