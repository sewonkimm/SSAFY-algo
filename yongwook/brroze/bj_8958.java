package brroze;

import java.util.Scanner;

public class bj_8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String a = null;
		char a1[] = null;
		int result = 0;
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			cnt = 1;
			result = 0;
			a = sc.next();
			a1 = a.toCharArray();

			for (int z = 0; z < a1.length; z++) {

				if (a1[z] == 'O' ) {
					result += cnt;
					if ( z+1<a1.length &&a1[z] == a1[z + 1]) {
						cnt++;
					}
				}
				if (a1[z] == 'X') {
					cnt = 1;
				}
			}
			System.out.println(result);
		}
	}
}
