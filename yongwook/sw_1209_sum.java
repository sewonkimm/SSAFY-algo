package practice;

import java.util.Scanner;

public class sw_1209_sum {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		
		for (int i = 0; i < 10; i++) {
			
			int a = sc.nextInt();
			int map[][] = new int[100][100];
			for (int j = 0; j < 100; j++) {
				for (int j2 = 0; j2 <100; j2++) {
					map[j][j2] = sc.nextInt();
				}
			}
			///////////////////////
			int max[] = new int[4];
			int temp = 0;
			//가로열 max구하기
			for (int j = 0; j < 100; j++) {
				for (int j2 = 0; j2 < 100; j2++) {
					temp+= map[j][j2] ;
				}
				if(max[0]<temp) {
					max[0]= temp;
					
				}
				temp =0;
			}
			temp =0;
			//세로열
			for (int j = 0; j < 100; j++) {
				for (int j2 = 0; j2 < 100; j2++) {
					temp+= map[j2][j] ;
				}
				if(max[1]<temp) {
					max[1]= temp;
					
				}
				temp =0;
			}
			temp =0;
			////////////////////////////
			for (int j = 0; j < 100; j++) {
				for (int j2 = 0; j2 < 100; j2++) {
					if(j==j2)
					temp+= map[j][j2] ;
				}		
			}
			max[2] = temp;
			temp =0;
			//////////////////////////////
			int cnt = 99;
			for (int j = 0; j < 100; j++) {
				for (int j2 = 0; j2 < 100; j2++) {
					if(j2==cnt) {
						cnt--;
						temp+= map[j][j2] ;
					}
				}		
					
			}
			max[3] = temp;
			temp =0;
			
			int result= 0;
			for (int j = 0; j < max.length; j++) {
				if(result<max[j]) {
					result = max[j];
				}
			}
			System.out.println("#"+(i+1)+" "+result);
		}
	}
}
