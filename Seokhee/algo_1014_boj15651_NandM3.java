import java.util.*;
import java.io.*;

public class algo_1014_boj15651_NandM3 {
	//n과 m
	//중복조합 사전순으로
	//자기자신도 갈 수 있도록 만들면 됨
	static StringBuilder sb,sb2;
	static int n,m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //1부터 n까지
		m = sc.nextInt(); //m개 고르기
		
		sb = new StringBuilder(""); //sb2에 추가시켜줄 작은 답들
		sb2 = new StringBuilder(""); //최종 전체 답을 한번에 출력해서 시간초과 극복
		dfs(0);
		System.out.println(sb2);
		
	}
	static void dfs(int cnt) {
		if(cnt == m) {
			sb2.append(sb+"\n");
			return;
		}
		for(int i=1;i<=n;i++) {
			sb.append(i+" ");
			dfs(cnt+1);
			sb.deleteCharAt(sb.length()-1);
			sb.deleteCharAt(sb.length()-1);
		}
	}
}
