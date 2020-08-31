import java.io.*;
import java.util.*;
public class TSP_Test4 {
	//외판원 순회
	//백준 2098번 tsp알고리즘 사용
	//0부터 출발해서 모든 마을을 도는 최소값은 다른 마을을 출발점으로 하는 최소값과 같다
	//비트마스킹으로 해당 마을에 방문했는가,안했는가를 빠르게 판단해보자 (마을은 16개이하이다)
	static int N; //마을개수
	static int[][] distance; //거리
	static int[][] dp;
	static int[] input;
	static int sum;
	static int INF = 0x3f3f3f3f;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		distance = new int[N][N];
		dp = new int[N][(1<<N)-1]; //n이 16이하여서 가능 , dp 크기 설정
		//1로 되어있는 곳이 방문한 도시이고 N점에서 몇 곳의 도시를 돌았을 때, 최소비용을 저장
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				distance[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) //못 가는길, 없는 길 세팅
            Arrays.fill(dp[i], INF);

		
		System.out.println(tsp(0,1));
	}
	
	public static int tsp(int node,int nowTown) {
		if(nowTown==((1<<N)-1)) { //모든 마을에 도착, 전부다 1로 채워진 비트일 경우  = (1<<N)-1
			if(distance[node][0] == 0) return INF; //가는 길이 없으면 못감
			return distance[node][0];
		}

		if(dp[node][nowTown] != INF) { //이미 한번 찾았던 곳이면 연산 없이 출력
			return dp[node][nowTown];
		}
		
		for(int i=0;i<N;i++) {
			int nextTown = nowTown | (1<<i); //다음 갈 곳을 1로 설정
			if(distance[node][i] ==0| (nowTown & (1<<i)) > 0) continue; //갈 길이 없거나, 도시에 방문한 적이 있으면 넘기기
			dp[node][nowTown] = Math.min(dp[node][nowTown],distance[node][i] + tsp(i,nextTown));
			//해당 도시에서 nextTown상태로 가기위해선 
			//도시에서 nextTown 상태로 가는 법과 해당도시에서 아무도시(0~n)를 거친 다음에 그 도시에서 nextTown 상태로 가는 법, 두 가지를 비교한다
		}
		return dp[node][nowTown];
	}
	
}
