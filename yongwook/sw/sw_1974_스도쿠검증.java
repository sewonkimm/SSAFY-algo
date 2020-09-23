package sw;

import java.util.Scanner;

public class sw_1974_스도쿠검증 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		
		for (int i = 0; i < tc; i++) {
			
			int map[][] = new int[9][9];
			
			
			
			int end =0;
			//가로열검사 -> 경우의 수를 줄이기위해 가로열은 입력하면서 검사한다.
			OUTER:
				for (int j = 0; j < 9; j++) {

					//가로열 체크 초기화
					int check1[] = new int[10];
					// 입력하면서 가로열 체크 
					for (int z = 0; z < 9; z++) {
						map[j][z]= sc.nextInt();
						check1[map[j][z]] += 1;
						if(check1[map[j][z]]==2) {
							end = 1;
							break OUTER;
						}
					}
				}
			if(end ==1) {
				System.out.println("#"+(i+1)+" "+0);
				continue;
			}
			//세로열체크
			OUTER1:
				for (int j = 0; j < 9; j++) {
					//세로열 체크 초기화
					int check2[] = new int[10];
					for (int z = 0; z < 9; z++) {
						check2[map[z][j]]+=1;
						if(check2[map[z][j]]==2) {
							end = 1;
							break OUTER1;
						}

					}
				}
			if(end ==1) {
				System.out.println("#"+(i+1)+" "+0);
				continue;
			}
			// 9*9 체크
			

			int start = 0;
			int end1 = 3;
			int start1 = 0;
			int end2 =3;
			OUTER2:
				for (int a= 0; a < 3; a++) {
					
					
					for (int j = 0; j < 3; j++) {
						//9*9 체크 초기화	
						int check3[] = new int[10];
						//9*9
						for (int k = start1; k < end2; k++) {
							for (int z = start; z < end1; z++) {
								check3[map[k][z]]+=1;
								
								if(check3[map[k][z]]==2) {
									end = 1;
									break OUTER2;
								}
							}
						}
						start+=3;
						end1+=3;
					}
					start1+=3;
					end2+=3;
					
					start = 0;
					end1 =3;
					
				}
			if(end ==1) {
				System.out.println("#"+(i+1)+" "+0);
				continue;
			}
			System.out.println("#"+(i+1)+" "+1);

		}
	}
}
