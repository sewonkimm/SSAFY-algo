import java.util.Scanner;

public class algo_0928_boj1562_stairNumberTest {

	//백준 1562 계단 수
	//1. 계단수는 맨 끝자리 숫자를 기준으로 센다, 맨 끝자리 숫자는 두 곳의 수를 합쳐주면 됨, 예를 들어 끝자리 3은 이전단계의 2와 4에서 파생되므로 더 해줌
	//2. 0과 9는 예외로 1과 8에서만 파생되므로 따로 세어줌, 여기까지가 일반 계단 수
	//3. 이 계단수 문제는 0~9가 모두 등장해야하므로 0~9까지 사용한 숫자를 담을 비트개수만큼의 배열 1<<10짜리 칸이 추가로 더 필요하므로 3차원으로 DP배열 선언
	//4. 이후 가능한 모든 상태비트를 다 돌면서 역시 0과 9는 예외로 하여 진행을 해주고 모든 숫자를 사용한 1023(0~9)일때, 즉 (1<<10)-1일때를 찾아서 다 더해줌
	final static long mod = 1000000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		long[][][] dp = new long[101][10][1<<10]; //마지막칸은 사용한 수를 표기하는 비트
		
		for(int i=1;i<10;i++) {
			dp[1][i][1<<i] = 1; //첫 자리 1부터 9까지 돌자, 비트도 채워줌
		}
		
		for(int i=2;i<=n;i++) { //자릿수 ~100
			for(int j=0;j<=9;j++) { //마지막으로 쓴 수 0~9
				for(int k=0;k<(1<<10);k++) { //가능한 모든 상태비트
					if(j==0) { //마지막 수 0
						dp[i][0][k | (1<<0)] = (dp[i][0][k | (1<<0)] + dp[i-1][1][k]) % mod;
					}
					else if(j==9) { //마지막 수 9
						dp[i][9][k | (1<<9)] = (dp[i][9][k | (1<<9)] + dp[i-1][8][k]) % mod;
					}
					else { //나머지 숫자가 커질 것을 대비해서 두번으로 나눠서 계산 했음
						dp[i][j][k | (1<<j)] = (dp[i][j][k | (1<<j)] + dp[i-1][j-1][k]) % mod ;
						dp[i][j][k | (1<<j)] = (dp[i][j][k | (1<<j)] + dp[i-1][j+1][k]) % mod;
					}
				}
			}
		}

		long sum = 0;
		
		for(int i=0;i<10;i++) {
			sum = (sum + dp[n][i][(1<<10)-1] % mod ) % mod;
		}
		
		System.out.println(sum);
	}
}
