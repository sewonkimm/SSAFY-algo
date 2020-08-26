import java.util.*;
public class lcsTest {
	
	static int[][] dp;
	//백준 9251 LCS
	//LCS 전형적인 dp문제 유형
	//점화식으로 표현가능함 -> dp
	//1부터 시작하는 이중포문, 
	//해당 자리 문자가 같으면 dp[i][j] = dp[i-1][j-1]+1;
	//해당 자리 문자가 다르면 dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String st1, st2;
		
		st1 = sc.next();
		st2 = sc.next();
		int len1 = st1.length();
		int len2 = st2.length();
		
		dp = new int[len1+1][len2+1]; //0으로 초기화 되있을 것이다
		
		//기준을 len1, len2 어느것으로 잡아도 상관없다, 편하게 len1
		for(int i=1;i<=len1;i++) {
			for(int j=1;j<=len2;j++) {
				if(st1.charAt(i-1) == st2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}
				else if(st1.charAt(i-1) != st2.charAt(j-1)) {
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
				
			}
		}
		
		System.out.println(dp[len1][len2]);
		
	}
}
