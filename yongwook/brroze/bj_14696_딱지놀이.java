package brroze;

import java.util.Scanner;

public class bj_14696_딱지놀이 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
	
		for (int i = 0; i < N; i++) {
			int win1[] = new int[5];
			int win2[] = new int[5];
			
			int a = sc.nextInt();
			for (int j = 0; j < a; j++) {
				int number = sc.nextInt();
				win1[number]++;	
			}
			

			int b = sc.nextInt();
			for (int j = 0; j < b; j++) {
				int number1 = sc.nextInt();
				win2[number1]++;
			}
			

			for (int j = 4; j >= 1; j--) {
				if(win1[j]> win2[j]) {
					System.out.println("A");
					break;
				}else if(win1[j]<win2[j]) {
					System.out.println("B");
					break;
				}else if(j==1 && win1[j]==win2[j]){
					System.out.println("D");
					break;
				}else {
					continue;
				}
				
			}


		}
	}
}
