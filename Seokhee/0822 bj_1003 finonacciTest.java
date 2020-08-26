import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class finonacciTest {
	
	static int[][] dp; //�������� dp���� = �Ǻ���ġ
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//���ѽð� 0.25���̱⶧���� ���۸��� ���
		dp = new int[41][2]; //0~40 �̹Ƿ� 41��
		dp[0][0] = 1; dp[0][1] = 0; //�� �Ǻ���ġ���� 0 ���Ƚ���� 1 ���Ƚ���� ����� �� �ʱ�ȭ
		dp[1][0] = 0; dp[1][1] = 1;
		
		int T = Integer.parseInt(br.readLine());
		int n;
		for(int t=0;t<T;t++) {
			n = Integer.parseInt(br.readLine());
			for(int i=2;i<=n;i++) { 
				dp[i][0] = dp[i-1][0]+dp[i-2][0]; //���� ��뷮 ������
				dp[i][1] = dp[i-1][1]+dp[i-2][1]; //���� ��뷮 ������
			}
			System.out.println(dp[n][0]+" "+dp[n][1]);
		}
		
	}
	//����� ������·� ®�µ� �ð������Ǽ� ����
//	static int fibonacciDPu0(int n) {
//		if(n==0) {
//			return dp[0][0];
//		}
//		else if(n==1) {
//			return dp[1][0];
//		}
//		else {
//			if(dp[n][0]!=0) return dp[n][0];
//			return fibonacciDPu0(n-1)+fibonacciDPu0(n-2);
//		}
//	}
//	static int fibonacciDPu1(int n) {
//		if(n==0) {
//			return dp[0][1];
//		}
//		else if(n==1) {
//			return dp[1][1];
//		}
//		else {
//			if(dp[n][1]!=0) return dp[n][1];
//			return fibonacciDPu1(n-1)+fibonacciDPu1(n-2);
//		}
//	}
}
