import java.util.*;
public class nTileTest {
	//백준 11726번 dp문제
	//전형적인 dp문제 2*n타일링
	//규칙을 찾아보면 dp[i] = dp[i-1]+dp[i-2] 의 점화식이 나오는데
	//너무 값이 커지기때문에 10007로 나눈 값을 사용하라 명시한 것으로 보임
	static int[] dp; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		dp = new int[1001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		
		for(int i=4;i<=n;i++) {
			dp[i] = (dp[i-1]+dp[i-2])%10007;
		}
		System.out.println(dp[n]%10007);
	}

}
