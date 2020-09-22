package com.week7;

import java.util.Scanner;

public class BOJ1244_스위치켜고끄기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[] status = new boolean[n+1];	// 스위치 상태 저장
		for(int i=1; i<=n; i++) {
			int x = sc.nextInt();
			if(x == 1)	status[i] = true;
		}
		
		int student = sc.nextInt();
		for(int i=0; i<student; i++) {
			int gender = sc.nextInt();
			int number = sc.nextInt();
			
			if(gender == 1) {	// 남학생
				int idx = number;
				while(idx <= n) {
					status[idx] = !status[idx];
					idx += number;
				}
			}
			
			else {	// 여학생
				
				int left = number;
				int right = number;
				while(left >= 1 && right <= n) {
					if(status[left] == status[right]) {
						left--;
						right++;
					}
					else	break;
				}
				
				for(int k=left+1; k<=right-1; k++) {
					status[k] = !status[k];
				}
			}
		}
		
		// output - 한 줄에 20개씩 출력
		int cnt = 0;
		for(int i=1; i<=n; i++) {
			if(status[i])	System.out.print(1+" ");
			else 			System.out.print(0+" ");
			
			if(++cnt == 20) {
				System.out.println();
				cnt = 0;
			}
		}
		sc.close();
	}

}
