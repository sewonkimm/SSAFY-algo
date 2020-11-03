package com.week11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4014_활주로건설 {

	static int N, X, count;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase = 1; testcase <= T; testcase++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());	// 지형의 크기
			X = Integer.parseInt(st.nextToken());	// 경사로의 길이
			count = 0;		// 건설 가능한 활주로의 수
			
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			process();
			
			System.out.println("#"+testcase+" "+count);
		}
	}
	
	private static void process() {
		for(int i=0; i<N; i++) {
			if(makeRoad(map[i]))	++count;	// 행
			
			int[] colArr = new int[N];
			for(int j=0; j<N; j++) {
				colArr[j] = map[j][i];
			}
			if(makeRoad(colArr))	++count;	// 열
		}
	}
	
	private static boolean makeRoad(int[] arr) {
		int beforHeight, size;
		beforHeight = arr[0];	// 이전칸의 높이
		size = 1;	// 평지의 길이
		for(int j=1; j<N; j++) {
			if(beforHeight == arr[j])	{	// 1. 평지
				++size;
			}
			else if(arr[j] - beforHeight == 1) {	// 2. 오르막
				if(size < X)	return false;	// 활주로 건설 불가

				beforHeight++;
				size = 1;
			}
			else if(beforHeight - arr[j] == 1){	// 3. 내리막
				
				// 경사로 길이만큼 길이 있는지 확인
				int cnt = 0;
				for(int k=j; k<N; k++) {
					if(arr[k] != beforHeight-1)	break;
					cnt++;	// 이전높이 -1 만큼의 평지 길이 카운트
				}
				
				if(cnt < X)	return false;	// 활주로 건설 불가
				
				beforHeight--;
				size = 0;
				j += X-1;	// 경사로 다음칸의 위치로 이동
			}
			else return false;	// 4. 높이가 2 이상 차이나는 경우
		}
		return true;
	}
	

}
