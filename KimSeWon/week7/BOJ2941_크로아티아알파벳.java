package com.week7;

import java.util.Scanner;

public class BOJ2941_크로아티아알파벳 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int cnt = 0;
		for(int i=0; i<str.length(); i++) {
			
			cnt++;
			
			if(str.charAt(i) == 'c') {
				if(i+1 < str.length() && (str.charAt(i+1) == '=' || str.charAt(i+1) == '-')) {
					i++;
				}
			}
			else if(str.charAt(i) == 'l') {
				if(i+1 < str.length() && str.charAt(i+1) == 'j') {
					i++;
				}
			}
			else if(str.charAt(i) == 'n') {
				if(i+1 < str.length() && str.charAt(i+1) == 'j') {
					i++;
				}
			}
			else if(str.charAt(i) == 's') {
				if(i+1 < str.length() && str.charAt(i+1) == '=') {
					i++;
				}
			}
			else if(str.charAt(i) == 'z') {
				if(i+1 < str.length() && str.charAt(i+1) == '=') {
					i++;
				}
			}
			else if(str.charAt(i) == 'd') {
				if(i+1 < str.length() && str.charAt(i+1) == '-') {
					i++;
					continue;
				}
				
				if(i+2 <str.length() && str.charAt(i+1) == 'z' && str.charAt(i+2) == '=') {
					i+=2;
				}
			}
		}
		System.out.println(cnt);
		sc.close();
	}

}
