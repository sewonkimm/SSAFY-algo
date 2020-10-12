/*
 * BJ 2942 퍼거슨과 사과
 * 수학
 */

import java.util.Scanner;

public class BJ_2942_SirFerguson {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int R = sc.nextInt();
		int G = sc.nextInt();
		int small = 0;
		
		// 더 작은 수를 확인하기 위함
		if(R <= G) small = R;
		else small = G;
		
		for (int i = 1; i <= small; i++) {
			if(R%i == 0 && G%i == 0) {
				System.out.println(i + " " + R/i + " " + G/i);
			}
		}
		
		sc.close();
	}

}
