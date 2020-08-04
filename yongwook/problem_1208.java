package problem;

import java.util.Scanner;

public class problem_1208 {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int max =0 ;
		int min = 0;
		for(int t=0 ; t<10; t++) {
			
			int[] map = new int[100];
			
			int result =0;
			int dump = sc.nextInt(); // 덤프 입력받기
			for(int i=0 ; i<100; i++) { // 가로에 높이 입력 
				
				
				map[i] = sc.nextInt();
				
			}
			
			for (int j = 0; j < dump; j++) {
				
				max=map[0];
				min=map[0];
				
				for(int i=0 ; i<100 ; i++) { // 최소 최댓값 찾기
					
					if(max< map[i]) {
						max = map[i];
					}
					if(min> map[i]) {
						min = map[i];
					}
				}
				
				for(int i=0 ; i<100 ; i++) {// 최대값  줄이기 
					
					if(max == map[i]) {
						map[i]--;
						
						
						break;
					}
				}
				for(int i=0 ; i<100 ; i++) {// 최소값 증가 
					if(min== map[i]) {
						 map[i]++;
						 
						 break;
					}
				}
				for(int i=0 ; i<100 ; i++) { // 최소 최댓값 찾기
					
					if(max<= map[i]) {
						max = map[i];
					}
					if(min>= map[i]) {
						min = map[i];
					}
				}
				if( max- min == 0 || max - min == 1) {
                    break;
                }
			}
			
			result = max-min;
		
			System.out.println("#"+(t+1)+" "+result);
		}
	}

}
