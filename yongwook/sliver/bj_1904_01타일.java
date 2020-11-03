package sliver;

import java.util.Scanner;

public class bj_1904_01타일 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int memo[] = new int[n+1];

		memo[1]= 1;
		if(n>=2)
			memo[2]= 2;
		if(n>=3) {
			for (int i = 3; i < memo.length; i++) {
				memo[i]= (memo[i-2]+memo[i-1])%15746;
			}
		}

		System.out.println(memo[n]);
	}
}
