package brroze;

import java.util.Scanner;

public class bj_2562 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a[] = new int[9];
		int max = 0;
		int cnt = 0;
		for (int i = 0; i < 9; i++) {
			a[i]= sc.nextInt();
		}
		
		for (int i = 0; i < 9; i++) {
			if(max<a[i]) {
				max = a[i];
				cnt = i;
			}
		}
		System.out.println(max);
		System.out.println(cnt+1);
		
		
	}
}
