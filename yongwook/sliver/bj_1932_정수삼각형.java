package sliver;

import java.util.Scanner;

public class bj_1932_정수삼각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int map[][] = new int[N][N];
		int dpmap[][] = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i+1; j++) {
				map[i][j]= sc.nextInt();
			}
		}
		//////////////////////////

		dpmap[0][0] = map[0][0];
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i+1; j++) {

				/// 왼쪽
				if(j==0) {
					dpmap[i][j]= map[i][j]+dpmap[i-1][j]; 
				}

				//오른쪽
				else if(j==i) {
					dpmap[i][j] = map[i][j]+dpmap[i-1][j-1];
				}
				else {
					dpmap[i][j] = Math.max(dpmap[i-1][j-1]+map[i][j] ,dpmap[i-1][j]+map[i][j]);
				}


			}
		}

		////////////////////////////

		int result =0;
		for (int i = 0; i < N; i++) {
			result = Math.max(dpmap[N-1][i], result);
		}
		System.out.println(result);

	}



}
