package brroze;

import java.util.Scanner;

public class bj_1110_더하기사이클 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int a= sc.nextInt();
		int c = a;
		int b = 0;
		int cnt =0;
		while(true) {
			
			
			b = (a/10+ a%10)%10+ (a%10)*10;
			a= b;
			cnt++;
			if( a== c)
				break;
				
		}
		System.out.println(cnt);
	}
}
