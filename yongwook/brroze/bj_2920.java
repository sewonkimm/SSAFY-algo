package brroze;

import java.util.Scanner;

public class bj_2920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a[] = new int[8];
		int cnt = 1;
		int result = 0;
		for (int i = 0; i < 8; i++) {
			a[i] = sc.nextInt();
		}
		
		if(a[0]==1) {
			for (int i = 0; i < a.length; i++) {
				if(a[i] == cnt) {
					cnt++;
				}
				if(cnt == 9)
					result = 1;
			}
		}
		if(a[0]== 8) {
			cnt = 8;
			for (int i = 0; i < a.length; i++) {
				
				if(a[i] == cnt) {
					cnt--;
				}
				if(cnt == 0)
					result = 2;
			}
		}
		
		switch(result) {
		case 1:
			System.out.println("ascending");
			break;
		case 2:
			System.out.println("descending");
			break;
		default:
			System.out.println("mixed");
			break;
		}
	}
}
