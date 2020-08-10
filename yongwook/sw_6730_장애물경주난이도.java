package practice;

import java.util.Scanner;

public class sw_6730_장애물경주난이도 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int tc= sc.nextInt();
		for (int i = 0; i < tc; i++) {
			
			int N =sc.nextInt();
			int block[]= new int[N];
			for (int j = 0; j < N; j++) {
				block[j] = sc.nextInt();
			}
			////////////// 탐색
			int max=0, min=0 ;
			for (int j = 0; j < block.length; j++) {
					if(j+1<block.length) {
						if(block[j]<block[j+1]) {
							if(max<block[j+1]-block[j])
							max=block[j+1]-block[j];
						}
						if(block[j]>block[j+1]) {
							if(min<block[j]-block[j+1])
							min=block[j]-block[j+1];
						}
							
					}
			}
			System.out.println("#"+(i+1)+" "+max + " "+ min);
		}
	}
}
