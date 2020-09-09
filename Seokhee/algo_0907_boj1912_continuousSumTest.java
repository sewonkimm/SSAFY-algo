import java.io.*;
import java.util.*;

public class algo_0907_boj1912_continuousSumTest {
	//백준 1912 연속합
	//지금까지 계속 한 개씩 더한거랑 지금 다가올 하나와 비교해서 다가올 하나가 클 경우, 걔를 다시 시작점으로 둔다.
	//그 과정에서 dp를 정하고 max와 계속 비교를 해서, 가장 큰 dp를 구하여 출력.
	static int n;
	static int[] num;
	static int[] dp;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new int[n];
		dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		num[0] = Integer.parseInt(st.nextToken()); //for문 하나만 쓰기위해서 0번째는 빼냄
		dp[0] = num[0]; //dp[0]은 0번째 숫자 그 자체.
		max = dp[0]; //max로 선정
		for(int i=1;i<n;i++) { 
			num[i] = Integer.parseInt(st.nextToken());
			dp[i] = Math.max(dp[i-1]+num[i],num[i]); 
			//시작점부터 앞에서 계속 더한 것과 다가올 하나의 수와 비교, 다가올 수가 더 크면 걔를 시작점으로 다시 dp 시작.
			max = Math.max(max,dp[i]);
		}

		System.out.println(max);
	}
}
