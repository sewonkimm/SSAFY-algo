// 시간초과

/**
 * 순열로 모든 경우의 수 구함
 * 비용 총합을 계산
 * 최솟값 출력
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ2098 {

	static int[] idx;
	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] W = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				W[i][j] = sc.nextInt();
			}
		}

		// 순열
		idx = new int[N];
		for(int i=0; i<N; i++) {
			idx[i] = i;
		}
		
		int answer = Integer.MAX_VALUE;
		do {
			
			int sum = 0;
			// 여행 비용 구하기
			for(int i=0; i<N-1; i++) {
				sum += W[idx[i]][idx[i+1]];
			}
			sum += W[idx[N-1]][idx[0]];	// 다시 시작한 도시로 돌아오는 비용
			
			// 최솟값 출력
			answer = Math.min(answer, sum);
		} while(nextPermutation(N));
		
		// output
		System.out.println(answer);
		sc.close();
	}
	
	
	public static boolean nextPermutation(int N) {
		int i = N-1;
		while(i>0 && idx[i-1] > idx[i]) {
			--i;
		}
		if(i == 0) return false;
		
		int j = N-1;
		while(idx[i-1] > idx[j]) {
			--j;
		}
		
		swap(i-1, j);
		
		int k = N-1;
		while(i < k) {
			swap(i++, k--);
		}
		
		return true;
	}
	
	public static void swap(int i, int j) {
		int tmp = idx[i];
		idx[i] = idx[j];
		idx[j] = tmp;
	}
}
