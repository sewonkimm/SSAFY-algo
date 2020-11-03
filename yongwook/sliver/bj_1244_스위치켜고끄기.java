package sliver;

import java.util.Scanner;

public class bj_1244_스위치켜고끄기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);


		int sw = sc.nextInt(); // 스위치 개수
		int arr[] = new int[sw+1]; // 스위치배열

		for (int i = 1; i <= sw; i++) { // 스위치배열
			arr[i] = sc.nextInt();
		}
		int student = sc.nextInt(); //학생수

		for (int i = 0; i < student; i++) {
			int gender = sc.nextInt();// 성별
			int number = sc.nextInt();// 몇번 스위치
			int cnt = 1;
			if(gender == 1) {//남학생일떄
				while(number*cnt<=sw) {					
					if( arr[number*cnt] == 1) {
						arr[number*cnt] = 0;
					}
					else  {
						arr[number*cnt] = 1;
					}
					cnt++;

				}
			}
			else  { //여학생일떄
				if(arr[number] ==1) {  //자기자신 토글 무조건
					arr[number] = 0;
				}else {
					arr[number] = 1;
				}
				while(number+cnt<=sw && number-cnt>=1  ) {
					
					if(arr[number+cnt] == arr[number-cnt]) {
						if(arr[number+cnt] == 1) {
							arr[number+cnt] =0 ;
							arr[number-cnt] =0;
						}else {
							arr[number+cnt] =1 ;
							arr[number-cnt] =1;
						}
						cnt++;
					}
					else {
						break;
					}
				}
			}

		}

		for (int i =1 ; i <= sw; i++) {
		
			System.out.print(arr[i]+" ");
			
			if(i %20 ==0 ) {
				System.out.println();
			}
		}




	}
}
