import java.util.*;
import java.io.*;

public class algo_1008_boj6603_lotto {
	
	//백준 6603 로또
	//조합 돌리면되는데 넥퍼 넘 길어서 dfs씀
	static int n;
	static int[] num;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			
			if(n==0) break;
			
			num = new int[n];
			for(int i=0;i<n;i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			sb = new StringBuilder("");
			dfs(0,0);
			
			System.out.println();
		}
		
	}
	
	//조합을 dfs로 해보자
	static void dfs(int s,int c) {
		if(c == 6) {
			System.out.println(sb);
			return;
		}
		for(int i=s;i<n;i++) {
			if(n-i+c < 6) break; //같은 수 반복방지, 시간복잡도 줄이기
			sb.append(num[i]+" ");
			dfs(i+1,c+1); //같은 수 반복방지
			sb.deleteCharAt(sb.length()-1); //빈칸 제거
			sb.deleteCharAt(sb.length()-1); //숫자제거
			if(sb.length() != 0 && sb.charAt(sb.length()-1) != ' ') //숫자가 두자리 수였을 경우 하나 더 제거
				sb.deleteCharAt(sb.length()-1);		
		}
	}
}
