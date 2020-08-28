/*
 * BJ 1932 정수 삼각형
 * DP
 * 계산의 결과를 줄일 수 있도록 처음과 끝은 고정으로 계산하고
 * 중간은 위의 두 값 중 큰 값으로 계산!
 */

import java.io.IOException;
import java.util.Scanner;

public class BJ_1932_IntegerTriangle {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = 0;
		int[][] map = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				map[i][j] = sc.nextInt();
				// 처음 값 -> 이전 row의 처음 값 + 입력값
				if(j == 1) map[i][j] = map[i-1][j] + map[i][j];
				// 마지막 값 -> 이전 row의 마지막 값 + 입력값
				else if(j == i) map[i][j] = map[i-1][j-1] + map[i][j];
				// 중간 -> 이전 row에서 연결된 두 값 중 큰 값 + 입력값
				else map[i][j] = Math.max(map[i-1][j-1],map[i-1][j]) + map[i][j];
				// 계속 비교하다보면 결국 마지막 값과 비교하게 된다.
				if(map[i][j] > max) max = map[i][j];
			}
		}
		System.out.println(max);
		sc.close();
	}
}
