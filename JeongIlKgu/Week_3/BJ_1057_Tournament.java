/*
 * BJ 1057 토너먼트
 * 가장 먼저 생각이 든 것은 Queue에 두개씩 넣으면서 비교하는 풀이
 * 하지만, 그냥 수학 문제!
 * 토너먼트의 특성상, 둘이 만나지 않을 경우는 없다.
 * 따라서, 홀수번호라면 나누기 2 더하기 1
 * 짝수번호라면 나누기 2를 하면서 같은 수가 나오는지 확인
 */

import java.util.Scanner;

public class BJ_1057_Tournament {

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int kim = sc.nextInt();
		int im = sc.nextInt();
		int count = 0; // 라운드 수
		// 각 라운드마다 kim과 im 비교
		while(kim != im) {
			kim = kim/2 + kim%2;
			im = im/2 + im%2;
			count++;
		}
		System.out.println(count);
		sc.close();
	}

}
