package brroze;

import java.util.Scanner;

public class bj_2577_f {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a=sc.nextInt();
		int b= sc.nextInt();
		int c = sc.nextInt();		
		int arr[] = new int[10];		
		int mp =  (a*b*c);
		
		while(mp != 0) {
			arr[mp %10] +=1 ;
			mp= mp/10;
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println(arr[i]);
		}
	}
}
