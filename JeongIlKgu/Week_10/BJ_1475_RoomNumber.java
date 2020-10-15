/*
 * BJ 1475 방 번호
 */

import java.util.Scanner;

public class BJ_1475_RoomNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int[] num = new int[10];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < s.length(); i++) {
			num[s.charAt(i) - '0']++;
		}
		
		for (int i = 0; i <= 8; i++) {
			if(i == 6) {
				if((num[6]+num[9])%2 == 0) {
					num[6] = (num[6]+num[9])/2;
				}else {
					num[6] = (num[6]+num[9])/2 + 1;
				}
			}
			max = Math.max(num[i], max);
		}
		
		System.out.println(max);
		sc.close();
	}

}
