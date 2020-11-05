package sliver;

import java.util.Scanner;

public class bj_9461_파도반수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 0; i < tc ; i++) {
			int n = sc.nextInt();

			long memo[] = new long[101];

			memo[1]= 1;
			memo[2]= 1;
			memo[3]= 1;
			memo[4]= 2;
			memo[5]= 2;
			for (int j = 6; j < memo.length; j++) {
				memo[j] = memo[j-1]+memo[j-5];
			}
			System.out.println(memo[n]);
		}
	}
}
