/*
 * SWEA D3 1493 수의 새로운 연산
 * 1. 시작 좌표를 찾는다. => 주어진 p, q 보다 크면 그 전 좌표
 * 2. 해당 값이 될 때까지 x-1, y+1 반복
 * 3. 해당 값을 별 계산을 위해 저장
 */

import java.util.ArrayList;
import java.util.Scanner;

public class D3_1493_NewCalculateOfNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int p = 0, q = 0;
		// p와 q를 찾으면 바로 더해준다.
		int[] result = new int[2];
		// 각 (1,y)에 해당하는 값을 저장하기 위한 배열
		ArrayList<Integer> start = new ArrayList<Integer>();

		for (int t = 1; t <= T; t++) {
			p = sc.nextInt();
			q = sc.nextInt();
			// 배열 초기화, 처음 index 0에 0을 넣고 시작
			start.clear();
			start.add(0);
			result[0] = result[1] = 0;

			int index = 0, count = 0, num = 1, temp = 0;
			while (!(p == 0 && q == 0)) {
				start.add(num);
				num += (++index);
				// p 처리
				count = 0;
				if (p != 0 && p < num) {
					temp = start.get(index);
					while (p > temp) {
						temp++;
						count++;
					}
					result[0] += (1 + count);
					result[1] += (index - count);
					p = 0;
				}
				// q 처리
				count = 0;
				if (q != 0 && q < num) {
					temp = start.get(index);
					while (q > temp) {
						temp++;
						count++;
					}
					result[0] += (1 + count);
					result[1] += (index - count);
					q = 0;
				}
			}
			// 시작점 찾아가기
			int startY = result[1] + result[0] - 1;
			int answer = 1;
			for (int i = 1; i < startY; i++) {
				answer += i;
			}
			answer += (result[0] - 1);
			System.out.println("#"+t+" "+answer);
		}
		sc.close();
	}

}
