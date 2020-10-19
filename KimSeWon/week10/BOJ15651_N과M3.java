package com.week10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// n개중 m개를 고른 중복 수열
// System.out 사용하면 시간초과 => BufferedWriter 사용!

public class BOJ15651_N과M3 {

	static int N, M;
	static int[] combArr;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		combArr = new int[M];
		comb(0);

		bw.flush();
	}

	private static void comb(int cnt) throws IOException {
		
		if(cnt == M) {	// M개 골랐으면 출력
			for(int i=0; i<M; i++) {
				bw.write(Integer.toString(combArr[i]) +" ");
			}
			bw.newLine();
			return;
		}
		
		for(int i=1; i<=N; i++) {
			combArr[cnt] = i;
			comb(cnt+1);	// 중복으로 선택
		}
	}
}
