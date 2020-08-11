package com.ssafy;
import java.util.Scanner;
public class PrizeTest {
	static int chance;
	static int answer;
	static String[] stArray;
	static String st;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			st = sc.next();
			stArray = st.split("");
			chance = sc.nextInt();
			
			answer = 0;
			
			answer = dfs(0,0);
			
			System.out.println("#"+t+" "+answer);
		}
	}
	static int dfs(int k,int count) {
		String temp;
		String targetNum = "";
		
		if(Integer.valueOf(st) ==0)
			return 0;
		
		if(chance == count) {
			for(int i=0;i<stArray.length;i++) {
				targetNum+=stArray[i];
			}
			//System.out.println(targetNum);

			if(Integer.valueOf(targetNum)>answer) {
				answer = Integer.valueOf(targetNum);
			}
			return answer;
		}
		
		for(int i=k;i<stArray.length;i++) {
			for(int j=i+1;j<stArray.length;j++) {
				if(Integer.valueOf(stArray[i]) <= Integer.valueOf(stArray[j])) {
					temp = stArray[i]; stArray[i] = stArray[j]; stArray[j] = temp;
					dfs(i,count+1);
					temp = stArray[i]; stArray[i] = stArray[j]; stArray[j] = temp;
				}
			}
		}
		
		if(chance % 2 == 0 && answer == 0) return Integer.valueOf(st);
		else if(chance % 2 == 1 && answer == 0){
			for(int i=k;i<stArray.length;i++) {
				for(int j=i+1;j<stArray.length;j++) {
						temp = stArray[i]; stArray[i] = stArray[j]; stArray[j] = temp;			
						dfs(i,1);
						temp = stArray[i]; stArray[i] = stArray[j]; stArray[j] = temp;
				}
			}
		}
		return answer;
	}
}
