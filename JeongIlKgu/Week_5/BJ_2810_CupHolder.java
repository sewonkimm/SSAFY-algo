/*
 * BJ 2810 컵홀더
 * 싱글 좌석만 있는 경우, 사람 수만큼 컵을 놓을 수 있고
 * 커플 좌석이 하나라도 포함되있는 경우, 마지막 컵을 놓는 자리까지 확인해야 한다.
 */

import java.util.Scanner;

public class BJ_2810_CupHolder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		String s = sc.nextLine();
		int answer = 0; // 사용하는 컵홀더 개수
		boolean check = false; // 커플 좌석이 하나라도 있는지 확인
		for (int i = 0; i < N; i++) {
			if(s.charAt(i) == 'S') { // 싱글 좌석인 경우
				answer++;
			}else if(s.charAt(i) == 'L') { // 커플 좌석인 경우
				answer++;
				i++; // 커플 좌석일 경우 한 좌석은 확인 X
				check = true;
			}
		}
		if(check) System.out.println(++answer);
		else System.out.println(answer);
		sc.close();
	}

}
