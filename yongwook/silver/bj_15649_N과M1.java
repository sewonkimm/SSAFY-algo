package sliver;

import java.util.Scanner;

public class bj_15649_N과M1 {
	static int N,M;
	static StringBuilder sb; 
	static boolean visit[] ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		visit = new boolean[N+1];
		dfs(0);
	}

	public static void  dfs(int x) {
		
		if( x== M) {
			System.out.println(sb);
			return;
		}else {
			for (int i = 1; i <= N; i++) {
				if(visit[i] != true) 
				{
					sb.append(i+" ");
					visit[i] = true;
					dfs(x+1);
					visit[i]= false;
					sb.deleteCharAt(sb.length()-1);
					sb.deleteCharAt(sb.length()-1);
				}
			}
		}

	}
}
