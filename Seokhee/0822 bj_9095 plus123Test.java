import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class plus123Test {
	//���� 9095�� 1,2,3���ϱ� 
	//dp�� ����ɸ��� ��ȭ���� ��������
	//dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
	//i-1���� 1�� �����ִ� ��� + i-2���� 2�� �����ִ� ��� + i-3���� 3�� �����ִ°��
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
