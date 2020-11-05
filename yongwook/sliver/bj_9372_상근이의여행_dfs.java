package sliver;

import java.util.Scanner;

public class bj_9372_상근이의여행_dfs {
	static int country , airplane ,tc , result ;
	static int arr[][];
	static int visit[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		 tc = sc.nextInt();
	
		 
		for (int i = 0; i < tc; i++) {
			
			  country =  sc.nextInt();
			 airplane = sc.nextInt();
			 arr = new int[country+1][country+1];
			 result = 0;
			 visit = new int[country+1];
			for (int j = 0; j < airplane; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				arr[x][y] = arr[y][x]=1;
			}
			
			dfs(1);
			System.out.println(result);
		}
		
	}
	static void dfs(int x) {
		
		visit[x] =1;
		for (int i = 1; i < country+1; i++) {
				if(arr[x][i]==1 && visit[i] ==0) {
					result++;
					dfs(i);
			}
		}
	}
}
