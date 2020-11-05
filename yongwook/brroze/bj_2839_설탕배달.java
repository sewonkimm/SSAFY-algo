package brroze;

import java.util.Scanner;

public class bj_2839_설탕배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		int cnt = 0;
		while(true) {
			if(input % 5 == 0) {
				System.out.println(input/5+cnt);
				break;
			}else if(input<=0) {
				System.out.println(-1);
				break;
			}
			
			input -=3 ;
			cnt ++;
		}
	}
}
