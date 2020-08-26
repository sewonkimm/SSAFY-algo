package brroze;

import java.util.Scanner;

public class bj_2884 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int time1 = sc.nextInt();
		int time2 = sc.nextInt();
		
		if(time2>=45) {
			time2 = time2 -45;
			System.out.println(time1+" "+time2);

		}else if(time1==0) {
			time1 = 23 ;
			time2 = 60-45+time2;
			System.out.println(time1+" "+time2);
		}else {
			time1 = time1-1;
			time2 = 60-45+time2;
			System.out.println(time1+" "+time2);
		}
			
				
	}
}
