package com.week10;

import java.io.*;
import java.util.*;

public class BOJ2630_색종이만들기 {

	static int[] count;
	static int[][] paper;
	static boolean[][] visited;
	static int white, blue, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 한 변의 길이
		paper = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		count = new int[2];
		cutPaper(N);

		System.out.println(count[0]);
		System.out.println(count[1]);
	}

	public static class StartPoint {
		int x, y;

		public StartPoint(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void cutPaper(int len) {

		if(len < 1)	return;

		int div = N / len;
		Boolean isAllSame = true;
		for (int i = 0; i < div; i++) {
			for (int j = 0; j < div; j++) {

				StartPoint sp = new StartPoint(len * i, len * j);
				
				if(!visited[sp.x][sp.y]) {
					if (isSame(len, sp) == -1) {	// 모두 같은 색이 아니라면
						isAllSame = false;				
					}
					else {
						// 방문 처리
						for(int p=0; p<len; p++) {
							for(int q=0; q<len; q++) {
								visited[sp.x+p][sp.y+q] = true;
							}
						}
						
						// 색종이 수 세기
						count[paper[sp.x][sp.y]]++;
					}
					//System.out.println(len+": ("+sp.x+","+sp.y+") white="+count[0] + "blue="+count[1]);
				} 
			} // end of for j
		} // end of for i
		
		if(!isAllSame) {
			cutPaper(len/2);	// 색종이를 자른다
		}

	}

	// 모두 같은 색으로 칠해져 있는지 확인
	public static int isSame(int len, StartPoint sp) { // len: 확인할 길이, startPoint: 시작 좌표
		int color = paper[sp.x][sp.y];

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (paper[sp.x + i][sp.y + j] != color)
					return -1;
			}
		}

		return color;
	}
}
