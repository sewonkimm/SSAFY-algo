package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_15651__N과M3 {
	static int N, M ;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		 
		 //백트래킹
		 
		 dfs(0); //고르는 갯수
		
	}
	
	public static void dfs(int x) {
		if( x == M) {
			
			System.out.println(sb);
			return;
		}else {
			for (int i = 1; i <= N; i++) {
				sb.append(i+" ");
				dfs(x+1);
				sb.deleteCharAt(sb.length()-1);//공백없애고
				sb.deleteCharAt(sb.length()-1);// 숫자없애기
			}
		}
			
		/*
		 * 1+" " dfs(1) 1+" " 출력하고 함수끝나고 공백사라지고 숫자사라지고, 2실행하네
		 * 
		 */1+" "+dfs(1);2+" ",dfs(2); -> 출력을하고 2개제거 그다음 dfs1 두개제거 -> 공백
		 아하 그리고나서
		 3, 4  제거제거
		 
		
	}
}
