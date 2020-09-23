package sw;

import java.util.Scanner;

public class sw_1940_가랏_RC카 {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
	
		for (int i = 0; i < t; i++) {
			int road = 0; //거리
			int comand = 0;// 첫번째 명령값
			int input1 = 0;// 두번째 명령값
			int speedsave = 0; // 속도저장값
			int tc = sc.nextInt();
			
			for (int j = 0; j < tc; j++) {
				 comand = sc.nextInt(); // 명령 값
				 
				if(comand == 0) {
					road +=speedsave;
				}else if(comand ==1) {//가속일때
					input1 = sc.nextInt();
					speedsave += input1;
					road+= speedsave;
					
				}else if(comand == 2) {//감속일때
					input1 = sc.nextInt();
					if(speedsave-input1 >=00)
					speedsave -= input1;
					if(speedsave>=0)
					road+= speedsave;
				}
			}
			System.out.println("#"+(i+1)+" "+road);
		}
	}
}
