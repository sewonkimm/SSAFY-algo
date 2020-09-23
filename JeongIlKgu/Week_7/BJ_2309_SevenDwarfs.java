/*
 * BJ 2309 일곱 난쟁이
 * 조합 -> 100인지 확인 -> 오름차순 출력
 */

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2309_SevenDwarfs {

	static int[] dwarfs = new int[9];
	static int[] target = new int[7];
	static boolean isFinish = false;
	
	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			dwarfs[i] = sc.nextInt();
		}
		sc.close();
		// 조합
		comb(0, 0);
	}

	private static void comb(int idx, int tgtidx) {
		// 이미 100을 확인한 경우 모든 재귀 종료
		if(isFinish) return;
		if(tgtidx == 7) {
			// 합쳐서 100인지 확인
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += target[i];
			}
			// 100이라면 오름차순 출력
			if(sum == 100) {
				Arrays.sort(target);
				for (int i = 0; i < 7; i++) {
					System.out.println(target[i]);
				}
				isFinish = true;
			}
			return;
		}
		
		if(idx == 9) return;
		
		target[tgtidx] = dwarfs[idx];
		comb(idx+1, tgtidx+1);
		comb(idx+1, tgtidx);
	}
}
