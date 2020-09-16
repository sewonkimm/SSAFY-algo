package sliver;

import java.util.Scanner;

public class bj_1065_한수 {
	static int result =0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int number = sc.nextInt();
		if(number <100)
			System.out.println(number);
		
		else if(number>= 100){
			checkhansu(number);
			System.out.println(result);
		}
		
	
		
	}
	
	public static void checkhansu(int number) {
		result = 99; 
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		
		for (int i = 100; i <=number; i++) {
			
			 num1 = i/10/10;
			 num2 = i/10%10;
			 num3 = i%10;
			 
			if((num2- num1) == (num3-num2)) {
				result++;
			}
		}
		
		
		
	}
}
