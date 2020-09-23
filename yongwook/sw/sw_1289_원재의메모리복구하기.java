package sw;

import java.util.Scanner;

public class sw_1289_원재의메모리복구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			
			String input = sc.next();
			
			int a= 1;
			int cnt =0;
			int arr[] = new int[input.length()];
			//배열생성
			for (int j = 0; j < input.length(); j++) {
				 arr[j] = input.charAt(j)-'0';
			}
			//알고리즘
			for (int j = 0; j < input.length(); j++) {
				if(arr[j]== a) {
					cnt++;
					if(a==1) a= 0;
					else if(a==0) a= 1;
				}
			}
			System.out.println("#"+(i+1)+" "+cnt);
			
			
		}
	}
}
