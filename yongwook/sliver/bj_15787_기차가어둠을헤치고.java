package sliver;

import java.util.Scanner;

public class bj_15787_기차가어둠을헤치고 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); //기차수
		int M = sc.nextInt();// 명령수
		int result = 0 ;//통과 기차수
		int arr[] = new int[N+1]; //총기차
		boolean visit[] = new boolean[1<<21];
		
		for (int i = 0; i < M; i++) {
			int  order = sc.nextInt();
			int  train = sc.nextInt();

			if(order == 1) {
				int  person = sc.nextInt();
				arr[train] = ( arr[train] | 1 << person );
			}
			if(order == 2) {
				int  person = sc.nextInt();
				arr[train] = (arr[train] & 0<<person) ;
			}
			if(order == 3) {
				arr[train] = arr[train] <<1 ;
				  arr[train] = arr[train] & ((1<<21)-1);
			}
			if(order == 4) {
				arr[train] = arr[train] >>1 ;
				arr[train] = arr[train]& ~1;
			}
		}
		
		  for(int i=1; i<=N; i++) {
	            if(!visit[arr[i]]) {
	                result++;
	                visit[arr[i]] = true;
	            }
	        }
		  System.out.println(result);
	}
}
