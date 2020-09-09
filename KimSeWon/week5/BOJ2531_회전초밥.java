// N 최대 30000
// d 최대 3000
// k 최대 3000

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// input
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int d = sc.nextInt();
		int k = sc.nextInt();
		int c = sc.nextInt();
		int answer = Integer.MIN_VALUE;

		int[] sushi = new int[N + k - 1];
		for (int i = 0; i < N; i++) {
			sushi[i] = sc.nextInt();
		}
		for (int i = 0; i < k - 1; i++) { // k-1개를 이어붙인다.
			sushi[N + i] = sushi[i];
		}

		int[] sushiType = new int[d + 1]; // 스시의 종류 d개
		for (int i = 0; i < N; i++) {
			
			if(i == 0) {
				for (int j = 0; j < k; j++) { // k개를 연속으로 고른다.
					sushiType[sushi[i + j]]++;
				}
			}
			else {
				// 맨 첫번째 스시를 빼고, 다음 스시 추가
				sushiType[sushi[i-1]]--;
				sushiType[sushi[i+k-1]]++;
			}

			int cnt = countType(sushiType, d); // 초밥의 가짓수
			
			if (sushiType[c] == 0) { // 쿠폰을 사용할 경우
				answer = Math.max(answer, cnt + 1);
			} else { // 쿠폰을 사용할 필요가 없는 경우
				answer = Math.max(answer, cnt);
			}
		}
		System.out.println(answer);
		sc.close();
	}

	private static int countType(int[] arr, int d) {
		int cnt = 0;
		for (int i = 1; i <= d; i++) { // 초밥 index는 1부터 시작하므로
			if (arr[i] > 0)	cnt++;
		}
		return cnt;
	}
}
