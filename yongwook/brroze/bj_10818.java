package brroze;

import java.util.Scanner;

public class bj_10818 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int max = -1000001;
		int min = 1000001;
		
		
		int tc = sc.nextInt();
		int number[] =new int[tc];
		for (int i = 0; i < tc; i++) {
			number[i] = sc.nextInt();
			
			if(max < number[i]) {
				max = number[i];
			}
			if(min >= number[i]) {
				min = number[i];
			}
			
		
		}
	
		System.out.println(min + " "+ max);
	}
}
