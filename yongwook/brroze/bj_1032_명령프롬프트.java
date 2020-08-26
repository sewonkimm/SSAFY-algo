package brroze;

import java.util.Scanner;

public class bj_1032_명령프롬프트 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		char map[][] = new char[tc][51];
		
		for (int i = 0; i < tc; i++) { //배열 입력
			
			map[i] = sc.next().toCharArray();
		}
		
		char result[] = map[0];
		for (int i = 0; i < map[0].length; i++) {
			for (int j = 0; j < tc; j++) {
				if(result[i]==map[j][i]) {
					continue;
				}else {
					result[i] = '?';
				}
				
			}
		}
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);	
		}
		System.out.println();
		
	}
}
