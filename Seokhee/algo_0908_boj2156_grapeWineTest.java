import java.io.*;

public class algo_0908_boj2156_grapeWineTest {

	//백준 2156 포도주시식
	//dp문제 생각보다 쉽지 않다
	//한칸을 뛴 상태로 최고를 고르는식으로 하자 (연속 3개가 안되므로)
	//현재 안집는 거 중에 최고  vs 현재꺼 집고 전전꺼에서 최고 vs 현재꺼 집고 전꺼집고 전전전꺼에서 최고
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] glass = new int[n+1];
		int[] dp = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			glass[i] = Integer.parseInt(br.readLine());
		}
		
		if(n==1) {
			dp[1] = glass[1];
			System.out.println(dp[1]);
		}
		else if(n==2) {
			dp[1] = glass[1];
			dp[2] = glass[1]+glass[2];
			System.out.println(dp[2]);
		}
		else if(n>=3) {
			dp[1] = glass[1];
			dp[2] = glass[1]+glass[2];
			dp[3] = Math.max(dp[1]+glass[3],dp[2]);
			dp[3] = Math.max(dp[3],dp[0]+glass[2]+glass[3]);
			for(int i=4;i<=n;i++) {
				dp[i] = Math.max(dp[i-2]+glass[i],dp[i-1]);
				dp[i] = Math.max(dp[i],dp[i-3]+glass[i]+glass[i-1]);
				//현재 안집는 거 중에 최고  vs 현재꺼 집고 전전꺼에서 최고 vs 현재꺼 집고 전꺼집고 전전전꺼에서 최고
			}
			System.out.println(dp[n]);
		}	
	}
}
