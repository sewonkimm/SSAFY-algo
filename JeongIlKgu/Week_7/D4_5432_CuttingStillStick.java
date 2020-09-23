/*
 * SWEA D4 5432 쇠막대기 자르기
 * 1. '('일 경우, 무조건 막대 개수 +1
 * 2. ')'일 경우,
 * 2-1. 전이 '('라면, 레이저 => 막대 개수 -1, 잘린 막대 개수+=막대개수
 * 2-2. 전이 ')'라면, 막대이기 때문에 막대 개수 -1, 잘린 막대 개수+1
 */

import java.util.Scanner;

public class D4_5432_CuttingStillStick {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		
		for (int t = 1; t <= T; t++) {
			String s = sc.nextLine();
			int cut = 0; // 잘린 막대의 총 개수
			int stick = 0; // 현재 존재하는 막대의 개수
			for (int i = 0; i < s.length(); i++) {
				switch (s.charAt(i)) {
				case '(':
					stick++;
					break;
				case ')':
					if(s.charAt(i-1) == '(') cut += (--stick);
					else if(s.charAt(i-1) == ')') {
						stick--;
						cut++;
					}
					break;
				}
			}
			System.out.println("#"+t+" "+cut);
		}
		sc.close();
	}

}
