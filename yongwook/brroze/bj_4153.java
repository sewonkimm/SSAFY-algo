package brroze;

import java.util.Scanner;

public class bj_4153 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int max= 0;
		int number[] = new int[3];
		int result = 0;
		
		while(true) {
			result = 0;
			max = 0;
			for (int i = 0; i < number.length; i++) {
				number[i] = sc.nextInt();
				if(max<number[i]) {
					max =number[i];
				}
				
			}
			
			for (int i = 0; i < number.length; i++) {
				if(number[i] != max) {
					result += number[i]*number[i];
				}
			}
			
			
			if(result ==0 || max ==0) {
				break;
			}
			else if(result == max*max)
				System.out.println("right");
			else
			System.out.println("wrong");
			
			
			
		}
	}
}
