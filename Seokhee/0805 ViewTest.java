package com.ssafy;
import java.util.*;

public class ViewTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			int w = sc.nextInt();
			int[] bd = new int[w];
			for(int i=0;i<w;i++) {
				bd[i] = sc.nextInt();
			}
			int min = 256;
			int cnt = 0;
			for(int i=2;i<w-2;i++) {
				for(int j=-2;j<3;j++) {
					if(j == 0)
						continue;
					if(bd[i]-bd[i+j] >= 1 && min > bd[i]-bd[i+j])
						min = bd[i]-bd[i+j];
					if(bd[i]<=bd[i+j]) {
						min = 0;
						j=3;
					}
				}
				cnt += min;
				min = 256;
			}
			System.out.println("#"+t+" "+cnt);
			cnt = 0;
		}
		
		
		
	}
	
}
