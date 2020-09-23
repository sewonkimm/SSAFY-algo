package com.week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14696_딱지놀이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int[] A = new int[5];
			for (int k = 0; k < n; k++) {
				A[Integer.parseInt(st.nextToken())]++;
			}

			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			int[] B = new int[5];
			for (int k = 0; k < n; k++) {
				B[Integer.parseInt(st.nextToken())]++;
			}

			// 라운드 시작
			if (A[4] > B[4])
				System.out.println('A');
			else if (A[4] < B[4])
				System.out.println('B');
			else if (A[4] == B[4]) {
				if (A[3] > B[3])
					System.out.println('A');
				else if (A[3] < B[3])
					System.out.println('B');
				else if (A[3] == B[3]) {
					if (A[2] > B[2])
						System.out.println('A');
					else if (A[2] < B[2])
						System.out.println('B');
					else if (A[2] == B[2]) {
						if (A[1] > B[1])
							System.out.println('A');
						else if (A[1] < B[1])
							System.out.println('B');
						else {
							System.out.println('D');
						}
					}

				}

			} // End of 라운드
		} // End of N
	} // End of main

}
