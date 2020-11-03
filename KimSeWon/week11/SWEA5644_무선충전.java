package com.week11;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 1. 각 궤도 위치마다 두 플레이어가 충전 가능한 BC 리스트 구하기
 * 2. A의 리스트, B의 리스트 => 조합 => 충전량의 합이 최대가 되도록 처리
 * 3. 모든 궤도마다 1,2 반복
 */
public class SWEA5644_무선충전 {

	static int M, bcCnt;	// M: 시간, bcCnt: 충전소 갯수
	static Point playerA, playerB;	// 현재 플레이어 위치
	static int[] pathA, pathB;	// path: 각 시간에 따른 궤적 정보, 
	static int[][] bc;
	static int[][] dir = { {0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		playerA = new Point();
		playerB = new Point();
		int T = Integer.parseInt(br.readLine());
		for(int TC=1; TC<=T; TC++) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			bcCnt = Integer.parseInt(st.nextToken());
			
			// 두 플레이어의 초기 위치
			playerA.x = playerA.y = 1;
			playerB.x = playerB.y = 10;
			
			// 0초 포함, 궤적정보
			pathA = new int[M+1];
			pathB = new int[M+1];
			
			// input
			String charsA = br.readLine();
			String charsB = br.readLine();
			for (int i = 1; i <= M; i++) {
				pathA[i] = charsA.charAt((i-1)*2) - '0';	// " " 스페이스 포함
				pathB[i] = charsB.charAt((i-1)*2) - '0';
			}
			
			// BC 정보
			bc = new int[bcCnt][4];	// x좌표, y좌표, 범위, 충전량
			for (int i = 0; i < bcCnt; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				bc[i][1] = Integer.parseInt(st.nextToken());
				bc[i][0] = Integer.parseInt(st.nextToken());
				bc[i][2] = Integer.parseInt(st.nextToken());
				bc[i][3] = Integer.parseInt(st.nextToken());
			}

			//////////////////////////입력 끝/////////////////////////
			

			System.out.println("#"+TC+" "+move());
		} // end TC
		
	} // end main

	private static int move() {
		// 매 시간마다 두 플레이어의 충전량의 합의 최댓값을 구하고 그 것을 누적
		int totalSum = 0;
		int time = 0;
		ArrayList<Integer> bcListA, bcListB;
		while(time <= M) {
			
			// 두 플레이어 이동
			playerA.x += dir[ pathA[time] ][0];
			playerA.y += dir[ pathA[time] ][1];
			playerB.x += dir[ pathB[time] ][0];
			playerB.y += dir[ pathB[time] ][1];
			
			// 자신 위치 기준으로 충전 가능한 충전소 리스트 가져오기
			bcListA = getBC(playerA);
			bcListB = getBC(playerB);
			
			// 충전량의 최댓값 구하기
			totalSum += getCharge(bcListA, bcListB);
			++time;
		}
		return totalSum;
	}

	private static int getCharge(ArrayList<Integer> bcListA, ArrayList<Integer> bcListB) {
		int max, temp;
		max = temp = 0;
		
		int aSize = bcListA.size();
		int bSize = bcListB.size();
		
		if(aSize == 0 && bSize == 0)	return 0;			// 둘다 충전 불가
		else if(aSize == 0)	return getMaxCharge(bcListB);	// B만 충전 가능
		else if(bSize == 0)	return getMaxCharge(bcListA);	// A만 충전 가능
		else {
			// A, B 모두 충전 가능한 상황 -> 조합
			for(Integer a : bcListA) {
				for(Integer b : bcListB) {
					if(a != b) temp = bc[a][3] + bc[b][3];
					else 	   temp = Math.max(bc[a][3], bc[b][3]);	// 둘 중 하나 선택
					
					max = Math.max(max, temp);
				}
			}
		}
		return max;
	}

	private static int getMaxCharge(ArrayList<Integer> bcList) {
		int max = 0;
		for(Integer i : bcList) {
			max = Math.max(max, bc[i][3]);
		}
		return max;
	}

	private static ArrayList<Integer> getBC(Point p) {
		ArrayList<Integer> bcList = new ArrayList<Integer>();
		
		int d = 0;
		for (int i = 0; i < bcCnt; i++) {
			d = Math.abs(bc[i][0]-p.x) + Math.abs(bc[i][1]-p.y);
			if(d <= bc[i][2])	bcList.add(i);
		}
		return bcList;
	}
}
