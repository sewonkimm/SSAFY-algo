package com.week11;

import java.io.*;
import java.util.*;

public class BOJ2605_줄세우기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] line = new int[n+1];	// line[x] x번 위치의 학생번호
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=1; i<=n; i++) {
			int diff = Integer.parseInt(st.nextToken());
			
			if(diff == 0) {
				line[i] = i;
			}
			else {
				for(int k=i; k>=i-diff; k--) {
					line[k] = line[k-1];
				}
				line[i-diff] = i;
			}
			
		}
		
		for(int i=1; i<=n; i++) {
			System.out.print(line[i]+" ");
		}
		
	}

}
