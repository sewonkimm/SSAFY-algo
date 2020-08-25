import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class plus123Test {
	//백준 9095번 1,2,3더하기 
	//dp가 적용될만한 점화식을 세워보자
	//dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
	//i-1에게 1씩 더해주는 경우 + i-2에게 2씩 더해주는 경우 + i-3에게 3씩 더해주는경우
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] dp = new int[12]; int n;
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int t=0;t<T;t++) {
			n = Integer.parseInt(br.readLine());
			for(int i=4;i<=n;i++) {
				dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
			}
			System.out.println(dp[n]);
		}
		
	}

}
