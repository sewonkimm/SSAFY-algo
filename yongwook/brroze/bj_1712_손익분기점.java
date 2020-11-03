package brroze;

import java.util.Scanner;

public class bj_1712_손익분기점 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		if(b>=c) {
			System.out.println(-1);
		}else {
			System.out.println(a/(c-b)+1);
		}
	}
}
