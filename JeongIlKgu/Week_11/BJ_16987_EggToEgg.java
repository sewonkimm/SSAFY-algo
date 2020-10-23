/*
 * BJ 16987 계란으로 계란치기
 * => N 수가 적기 때문에 재귀로 모든 경우를 탐색하면서 지나간다.
 */

import java.util.Scanner;

public class BJ_16987_EggToEgg {
	
	// 계란 정보
	static class Egg{
		int d, w;

		public Egg(int d, int w) {
			this.d = d;
			this.w = w;
		}
	}
	static int N, max; // size와 최대값
	static Egg[] eggs; // 계란들을 담을 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		eggs = new Egg[N];
		for (int i = 0; i < N; i++) {
			eggs[i] = new Egg(sc.nextInt(), sc.nextInt());
		}
		search(0); // 가장 처음 계란부터 탐색 시작
		System.out.println(max);
		sc.close();
	}
	
	private static void search(int idx) {
		// 매번 깨진 계란의 최대 개수를 찾아본다.
		int count = 0;
		for (int i = 0; i < N; i++) {
			if(eggs[i].d <= 0) count++;
		}
		max = Math.max(count, max);
		// 마지막 계란까지 확인한 경우
		if(idx == N) return;
		
		if(eggs[idx].d > 0) { // 내구도가 남아있다면
			for (int i = 0; i < N; i++) {
				if(idx != i && eggs[i].d > 0) {
					// 쌍방으로 내구도를 감소시키고 다음 계란 확인
					eggs[i].d -= eggs[idx].w;
					eggs[idx].d -= eggs[i].w;
					search(idx+1);
					// 복구
					eggs[i].d += eggs[idx].w;
					eggs[idx].d += eggs[i].w;
				}
			}
		} else {
			search(idx+1);
		}
	}
}
