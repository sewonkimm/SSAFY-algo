package sliver;

import java.util.Scanner;
import java.util.Stack;

public class bj_9012_괄호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		
		for (int i = 0; i < t; i++) {
			
			String input = sc.next();
			char[] word = input.toCharArray();
			int cnt1 =0;
			int cnt2 =0;
			for (int j = 0; j < word.length; j++) {
				if(word[j]== '(') {
					cnt1++;
				}
				else if(word[j]== ')'  ){
					cnt2++;
				}
				if(cnt2 > cnt1) {
					break;
				}
			}
			
			if(cnt1 == cnt2) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
}
