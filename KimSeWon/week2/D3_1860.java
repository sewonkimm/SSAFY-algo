package com.study;

import java.util.*;
import java.io.*;

public class BreadTest {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int TC=1; TC<=T; TC++){
			// input
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] guest = new int[11112];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++){
				guest[Integer.parseInt(st.nextToken())]++ ;
			}
						
			int time = 0;
			int bread = 0;
			String result = "Possible";
			while(time < 11112){
				
				// 붕어빵 추가
				if(time != 0 && time % M == 0){
					bread += K;
				}
				
				// 손님에게 붕어빵 제공
				if(guest[time] != 0){
					if(bread-guest[time]<0){	// 붕어빵을 줄 수 없으면 종료
						result = "Impossible";
						break;
					}
					
					// 붕어빵을 줄 수 있으면
					bread -= guest[time];	// 빵 개수 줄이기
				}
				
				time++;
			}
			
			System.out.println("#"+TC+" "+result);
		} // end of TC
	}

}
