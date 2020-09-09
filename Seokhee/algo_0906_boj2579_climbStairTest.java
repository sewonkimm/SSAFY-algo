import java.io.*;
import java.util.*;
public class algo_0906_boj2579_climbStairTest {
	//백준 2579 계단오르기
	//bfs로 구현하자 계단이 300이하라서 절대 터질 일 없다
	//점수 최고점도 300만점이라 양호
	//는 계산량이 너무 많다 -> bfs+DP로 전환, 이전 계단과 현재 계단을 밟았을 때 그 경우로 기록된 최고점수보다 낮으면 더 이상 안해도됨(술래잡기와 동일) 
	static int att;
	static int[] stair;
	static int max = 0;
	static int[][] dp;
	static class Status{ //이전상태 지금상태 그리고 들어올 층수를 통해서 세 계단을 이용할 수 있음
		int preStair;
		int nowStair;
		int total;
		public Status(int preStair, int nowStair, int total) {
			super();
			this.preStair = preStair;
			this.nowStair = nowStair;
			this.total = total;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		att = Integer.parseInt(br.readLine());
		stair = new int[att];
		dp = new int[att][att];

		
		for(int i=0;i<att;i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		if(att>=3) { //3이상일때 구해주자
			bfs();
			System.out.println(max);
			return;
		}
		else if(att==2) { //2개일 때는 0,1 밟는게 최고
			System.out.println(stair[0]+stair[1]);
		}
		else if(att==1) { //1개일 떄는 0 밟는게 최고
			System.out.println(stair[0]);
		}
	}

	static void bfs() {
		Queue<Status> queue = new LinkedList<>();
		//계단의 1층을 0으로 배열을 편하게 쓰자
		//Status클래스을 만들어서 사용
		//3층 이상일 때, 제일 처음 나올 수 있는 3가지 경우의 수를 모두 넣고 시작
		queue.add(new Status(0,1,stair[0]+stair[1]));
		queue.add(new Status(0,2,stair[0]+stair[2]));
		queue.add(new Status(1,2,stair[1]+stair[2]));
		
		while(!queue.isEmpty()) {
			Status s = queue.poll();
			
			int preStair = s.preStair;
			int nowStair = s.nowStair;
			int nowTotal = s.total;

			if(dp[preStair][nowStair]>nowTotal)
				continue;
			
			if(nowStair==att-1) {
				if(max<nowTotal)
					max = nowTotal;
				continue;
			}

			//연속해서 2계단을 밟았을 경우, +1경우는 스킵해주자
			if(nowStair - preStair != 1 && nowStair+1 <att) {
				if(dp[nowStair][nowStair+1]<nowTotal+stair[nowStair+1]) { 
					//이전에 동일하게 왔는데 더 기록이 좋은 경우가 있으면 볼 필요가 없음
					dp[nowStair][nowStair+1] = nowTotal+stair[nowStair+1];
					queue.add(new Status(nowStair,nowStair+1,nowTotal+stair[nowStair+1]));			
				}
			} //+2 계단은 범위가 허락하는 한 무조건 진행
			if(nowStair+2 <att) { 
				if(dp[nowStair][nowStair+2]<nowTotal+stair[nowStair+2]) {
					//이전에 동일하게 왔는데 더 기록이 좋은 경우가 있으면 볼 필요가 없음
					dp[nowStair][nowStair+2] = nowTotal+stair[nowStair+2];
					queue.add(new Status(nowStair,nowStair+2,nowTotal+stair[nowStair+2]));
				}
			}
		}
	}
}
