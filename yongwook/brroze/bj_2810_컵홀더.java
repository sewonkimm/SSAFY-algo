package brroze;

import java.util.Scanner;

public class bj_2810_컵홀더 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		char seat[] = new char[tc]; //좌석수 배열
		String input = sc.next(); 
		int result = 0;
		//베열입력
		for (int i = 0; i < tc; i++) {
			seat[i] = input.charAt(i);

		}
		
		// S나 LL를 만나면 컵놓을수있는 자리 체크 
		for (int i = 0; i < seat.length; i++) {
			
			if(seat[i] == 'S') {
				result++; //사람수
			}else if(seat[i]=='L') { // L은 두개가 한쌍으로 배열하나 건너뜀 
				i++;
				result++;
			}
		}

		if(seat[tc-1]=='S' |seat[tc-1]=='L' && result< tc) //좌석수가 넘어가면 안됨 안넘을때만 실행
			result += 1; // 맨끝자리는 2개이므로 1개더증가
		System.out.println(result);
	}
}
