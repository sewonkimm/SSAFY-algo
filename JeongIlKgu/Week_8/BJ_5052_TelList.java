/*
 * BJ 5052 전화번호 목록
 */

import java.util.Arrays;
import java.util.Scanner;

public class BJ_5052_TelList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			sc.nextLine();
			String[] tel = new String[n];
			for (int i = 0; i < n; i++) {
				tel[i] = sc.nextLine();
			}
			// 이 문제에서 핵심!
			// 정수를 기준으로 정렬하는 것이 아닌 문자열을 기준으로 정렬
			// 길이에 관계없이 정렬되기 때문
			Arrays.sort(tel);
			// 바로 앞의 번호와 다음 번호에 포함되는지만 확인하면 된다.
			boolean check = false;
			for (int i = 0; i < n-1; i++) {
				if(tel[i+1].startsWith(tel[i])) {
					check = true;
					break;
				}
			}
			if(check) System.out.println("NO");
			else System.out.println("YES");
		}
		sc.close();
	}
}
