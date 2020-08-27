package brroze;

import java.util.Scanner;

public class bj_1009_분산처리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int i = 0; i < tc; i++) {
			int a = sc.nextInt();
			int b= sc.nextInt();
			
			int result = a%10;
			for (int j = 2; j <=b; j++) {
				
				result = (result * a ) %10;
			}
			
			if(result == 0) result = 10;
			System.out.println(result);
	}
	}
}
