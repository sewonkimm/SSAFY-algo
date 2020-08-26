package brroze;

import java.util.Scanner;

public class bj_11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t= sc.nextInt();
		String number = sc.next();
		char number1[] = null;
		number1 = number.toCharArray();
		int result = 0;
		for (int i = 0; i < number1.length; i++) {
			result += number1[i]-48;
		}
		System.out.println(result);
	}
}
