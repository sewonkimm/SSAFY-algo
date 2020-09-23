package com.week7;

import java.util.Scanner;

public class BOJ17413_단어뒤집기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		StringBuilder sb = new StringBuilder();
		StringBuilder tag_sb = new StringBuilder();
		boolean isTag = false;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '<') {
				isTag = true;
				System.out.print(sb.reverse());
				sb = new StringBuilder();
				
				tag_sb.append(str.charAt(i));
				continue;
			}
			else if(str.charAt(i) == '>') {
				isTag = false;
				tag_sb.append(str.charAt(i));
				System.out.print(tag_sb);
				tag_sb = new StringBuilder();
				continue;
			}


			if(!isTag && str.charAt(i) == ' ') {
				System.out.print(sb.reverse()+" ");
				sb = new StringBuilder();
				continue;
			}
			else if(isTag && str.charAt(i) == ' ') {
				tag_sb.append(' ');
				continue;
			}
			
		
			if(!isTag && str.charAt(i) != ' ') {
				sb.append(str.charAt(i));
			}
			else if(isTag && str.charAt(i) != ' ') {
				tag_sb.append(str.charAt(i));
			}
			
			if(i == str.length()-1) {	// 마지막 단어 출력
				System.out.print(sb.reverse());
			}
			
		}
		sc.close();
	}

}
