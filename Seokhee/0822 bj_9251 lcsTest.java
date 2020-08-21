import java.util.*;
public class lcsTest {
	
	static int[][] dp;
	//���� 9251 LCS
	//LCS �������� dp���� ����
	//��ȭ������ ǥ�������� -> dp
	//1���� �����ϴ� ��������, 
	//�ش� �ڸ� ���ڰ� ������ dp[i][j] = dp[i-1][j-1]+1;
	//�ش� �ڸ� ���ڰ� �ٸ��� dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String st1, st2;
		
		st1 = sc.next();
		st2 = sc.next();
		int len1 = st1.length();
		int len2 = st2.length();
		
		dp = new int[len1+1][len2+1]; //0���� �ʱ�ȭ ������ ���̴�
		
		//������ len1, len2 ��������� ��Ƶ� �������, ���ϰ� len1
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
