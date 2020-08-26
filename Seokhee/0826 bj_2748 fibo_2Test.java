import java.util.*;
public class fibo_2Test {

	//백준 2748 피보나치2
	static long[] dp; //90까지면 int 터짐
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		dp = new long[91]; //long으로해서
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		
		for(int i=3;i<=n;i++) { //전형적인 메모이제이션(dp)사용한 피보나치
			dp[i] = dp[i-1]+dp[i-2];
		}
		System.out.println(dp[n]);
	}

}
