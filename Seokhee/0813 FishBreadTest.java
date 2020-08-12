package com.ssafy;
import java.util.*;

public class FishBreadTest {

	static int[] human;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			human = new int[n];
			for(int i=0;i<n;i++) {
				human[i] = sc.nextInt();
			}
			Arrays.sort(human); //빨리온사람부터 주는거로 정렬
			
			//fishsub 이미 왔다간 손님수(이미 먹은거니까 현재시간의 총생산량 계산에서 빼주기위해서)
			int fishSub = 0;
			
			for(int i=0;i<n;i++) {
				//true, false 여부를 위해, (손님이 온 시간 /생산에 걸리는 시간) 의 몫으로 생산량을 구한다
				int TF = ((human[i]/m) * k -(fishSub+1)); 
				fishSub++; //한명왔다감
				if(TF<0) { //생산량이 음수(손님이 더많다)면 불가능
					System.out.println("#"+t+" "+"Impossible");
					i = n;
					fishSub=0;
				}
				if(i==n-1) { //손님을 모두 받았으면 가능
					System.out.println("#"+t+" "+"Possible");
				}
			}
			
			
		}

	}

}
