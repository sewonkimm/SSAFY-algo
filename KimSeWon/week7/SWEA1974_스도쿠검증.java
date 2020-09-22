package com.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1974_스도쿠검증 {

	static int[][] puzzle;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			puzzle = new int[9][9];
			StringTokenizer st;
			for(int i=0; i<9; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<9; j++) {
					puzzle[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			boolean isSdoku = true;
			
			for(int i=0; i<9; i++) {
				if(!checkRow(i)) {	// 가로 체크
					isSdoku = false;
					break;
				}
				
				if(!checkCol(i)) {	// 세로 체크
					isSdoku = false;
					break;
				}
				
				if(!checkBlock(i)) {	// 블록 체크
					isSdoku = false;
					break;
				}
			}
			
			if(isSdoku)	System.out.println("#" + testCase + " 1");
			else 		System.out.println("#" + testCase + " 0");
			
		} // End of testCase
	} // End of main
	
	private static boolean checkRow(int row) {
		boolean[] visited = new boolean[10];
		for(int i=0; i<9; i++) {
			if(visited[puzzle[row][i]])	return false;
			else visited[puzzle[row][i]] = true;
		}
		return true;
	}
	
	private static boolean checkCol(int col) {
		boolean[] visited = new boolean[10];
		for(int i=0; i<9; i++) {
			if(visited[puzzle[i][col]])	return false;
			else visited[puzzle[i][col]] = true;
		}
		return true;
	}
	
	private static boolean checkBlock(int block) {
		boolean[] visited = new boolean[10];
		
		int x = 3 * (block/3);
		int y = 3 * (block%3);
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(visited[puzzle[x+i][y+j]])	return false;
				else visited[puzzle[x+i][y+j]] = true;
			}
			
		}
		return true;
	}

}
