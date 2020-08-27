package brroze;

import java.util.Scanner;

public class bj_2908 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b= sc.nextInt();
		int arr1[] = new int[3];
		int arr2[] = new int[3];
		
		for (int i = 0; i < 3; i++) {
			arr1[i] = a%10;
			arr2[i] = b%10;
			a/= 10;
			b/= 10;
		}
		a = arr1[0]*100 +arr1[1]*10 + arr1[2];
		b = arr2[0]*100 +arr2[1]*10 + arr2[2];
		
		if(a>b)
			System.out.println(a);
		else
			System.out.println(b);
	}
}
