package brroze;

import java.util.Scanner;

public class bj_2675 {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		int tc = sc.nextInt();
		String word = null;
		int cnt = 0;
		for (int i = 0; i < tc; i++) {
			cnt= sc.nextInt();
			word = sc.next();
		
		
		char[] words ;
		words= word.toCharArray();
		
		for (int z = 0; z < words.length; z++) {
			for (int j = 0; j < cnt; j++) {
				System.out.print(words[z]);
			}
		}
		System.out.println();
		}
	}
}
