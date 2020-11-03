package sliver;

import java.util.Scanner;

public class bj_1018_체스판다시칠하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		char map[][]= new char[N][M];
		int cnt = 0;
		for (int i = 0; i < map.length; i++) { //배열생성
			String input = sc.next();
			for (int j = 0; j < map.length; j++) {
				map[i][j]= input.charAt(j);
			}
		}
		
		for (int i = 0; i < map.length; i++) { //배열생성
			for (int j = 0; j < map.length; j++) {
				if(map[i][0] == 'B' &&  j*2 <M && j*2+1 <M) {
					if(map[i][j*2] !='B' )
						cnt++;
					if(map[i][j*2+1] !='W' )
						cnt++;
				}
				if(map[i][0] == 'W' &&  j*2 <M && j*2+1 <M) {
					if(map[i][j*2] !='W' )
						cnt++;
					if(map[i][j*2+1] !='B' )
						cnt++;
				}
			}
		}
		System.out.println(cnt);
		
		
		
		
	}
}
