import java.util.*;
public class cunningTest {
	//dp + bitmask 
	
	//dp(n,m) m-1 번째 줄에서 n 상태로 사람이 앉았을때
	//m번째 줄에서 나올 수 있는 가장 많은 학생의 수
	static int C;
	static int N,M;
	
	static int dp[][]; //dp
	static boolean obs[][]; //장애물
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		
		for(int c=0;c<C;++c) {
			N = sc.nextInt();
			M = sc.nextInt();

			dp = new int[1<<N][M]; //N 2배
			
			for(int i=0;i<(1<<N);++i) {
				Arrays.fill(dp[i], -1); //-1로 dp 다채움
			}
			
			
			
			obs = new boolean[N][M];
			
			for(int i=0;i<N;++i) {
				String input = sc.next();
				for(int j=0;j<M;++j) {
					if (input.substring(j, j + 1).equals("x")) obs[i][j] = true;

//					if(input.charAt(j) == 'x') {
//						obs[i][j] = true; //장애물
//					}
				}
			}
			

			System.out.println(DP(0,0));	
		}
	}
	static int DP(int n,int m) {
		if(m==M) return 0;
		if(dp[n][m]!=-1) return dp[n][m];
		
		int noSit = n; // 현재 사용 불가능한 자리
		
		for(int i=0;i<N;++i) {
			if((n&(1<<i))>0) {
				noSit |= (1<<(i+1)); //비트연산으로 불가능한 자리 체크 
				noSit |= (1<<(i-1));
			}
		}
		
		int result = DP(0,m+1); //앉는 사람없이 다음으로 넘어가는 경우를 기본으로 놓고
		
		for(int i=1;i<(1<<N);++i) {
			if((i&noSit) >0) continue;
			int cnt = 0;
			boolean Sit = true;
			for(int j=0;j<N&&Sit;++j) {
				if((i&(1<<j))>0) {
					cnt++;
					if(obs[j][m]) Sit = false;
				}
			}
			if(Sit) continue;
			result = Math.max(result, DP(i,m+1)+cnt);
		}
		
		return dp[n][m]=result;	
	}
}







