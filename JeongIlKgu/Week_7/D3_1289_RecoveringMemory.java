/*
 * SWEA D3 1289 원재의 메모리 복구하기
 */

import java.util.Scanner;

public class D3_1289_RecoveringMemory {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		
		for (int t = 1; t <= T; t++) {
			String s = sc.nextLine();
			int answer = 0; // 수정 횟수
			// 시작이 1인 메모리 값의 경우 처리
			if(s.charAt(0) == '1') answer++;
			// 앞뒤가 다르면 수정해야 한다.
			for (int i = 1; i < s.length(); i++) {
				if(s.charAt(i-1) != s.charAt(i)) answer++;
			}
			System.out.println("#"+t+" "+answer);
		}
		sc.close();
	}

}
