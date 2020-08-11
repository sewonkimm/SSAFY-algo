package practice;

import java.util.Scanner;

public class sw_2068_최대수구하기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc= sc.nextInt();
		for (int i = 0; i < tc; i++) {
			int max[] = new int[10];
			for (int j = 0; j < 10; j++) {
				
				max[j] = sc.nextInt();
			}
			
			int maxnumber= 0;
			
			for (int j = 0; j < 10; j++) {
				if(maxnumber< max[j]) {
					maxnumber =max[j];
				}
			}
			System.out.println("#"+(i+1)+" "+maxnumber);
		}
	}
}
