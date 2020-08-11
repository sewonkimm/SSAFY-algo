package practice;

import java.util.Arrays;
import java.util.Scanner;

public class sw_1206_view {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = 10;
		
		for (int i = 0; i < tc; i++) {
			int result = 0;
			int N = sc.nextInt();
			int high[] = new int[N];
			for (int j = 0; j < N; j++) {
				 high[j] = sc.nextInt();
			}
			
			for (int j = 2; j < N-2; j++) {
				
				int status[] = new int[4];
				
				status[0] = high[j] -high[j-1] ;
				status[1] = high[j] -high[j+1] ;
				status[2] = high[j] -high[j-2] ;
				status[3] = high[j] -high[j+2] ;
				
				Arrays.sort(status);
				if(status[0]<0||status[1]<0||status[2]<0||status[3]<0 ) continue;
				else
				Arrays.sort(status);
				result = result+status[0];
				
				
			}
			System.out.println("#"+(i+1)+" "+result);
		}
	}
}
