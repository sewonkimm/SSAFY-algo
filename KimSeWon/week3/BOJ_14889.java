// 조합 안 푼지 얼마나 됐다고 벌써 까묵나...

package com.week3;

import java.util.Scanner;

/**
 * 
 * @author sewonkimm
 * N명중 N/2명을 뽑는 조합(순서 상관없으므로)
 * 
 * 1. 조합으로 팀을 먼저 나누고
 * 2. 입력받은 값에 따라 팀의 능력치를 구한다.
 *
 */
public class Q14889 {

	static int N;
	static int result = Integer.MAX_VALUE;
	static int[][] ablity;
	static boolean[] selected;	// 조합에서 뽑힌 숫자를 기록하는 배열
	
	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		selected = new boolean[N+1];
		ablity = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				ablity[i][j] = sc.nextInt();
			}
		}
		
		// 조합 구하기
		combination(0, 1);
		

		// output
		System.out.println(result);
	}
	
	public static void combination(int cnt, int curnum) {
		
		// N개 중 N/2개를 뽑으면 종료
		if(cnt == N/2) {
			// a팀과 b팀의 차이를 구해서
			int aResult = 0;
			int bResult = 0;
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(i == j) continue;
					
					if(selected[i] && selected[j]) {
						aResult += ablity[i][j];
					}
					else if(selected[i] == false && selected[j] == false) {
						bResult += ablity[i][j];
					}
				}
			}
			
			// 최솟값을 result에 저장
			result = Math.min(result, Math.abs(aResult-bResult));
			return;
		}
		
		if(curnum > N)	return;
		
		selected[curnum] = true;
		combination(cnt+1, curnum+1);
		selected[curnum] = false;
		combination(cnt, curnum+1);
	}

}
