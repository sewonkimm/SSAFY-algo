package brroze;

import java.util.Scanner;

public class bj_13300_방배정 {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int women[] = new int[7];
		int man[] = new int[7];
		int result = 0;
		for (int i = 0; i < N; i++) {
			int gender = sc.nextInt();
			int grade = sc.nextInt();
			
			if(gender == 0) {
				women[grade]++;
			}else {
				man[grade]++;
			}
		}
		
		for (int i = 1; i <= 6; i++) {
			if(women[i]%K ==0)
				result += women[i]/K;
			else
				result += women[i]/K +1;
			if(man[i]%K ==0)
				result += man[i]/K;
			else
				result += man[i]/K +1;
		}
		System.out.println(result);
	}
}	
