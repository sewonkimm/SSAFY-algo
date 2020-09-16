import java.io.*;
import java.util.*;
public class algo_0912_boj1238_partyTest {

	//백준 1238 파티
	//마을이 1000개쯤이면 플로이드와샬도 가능하다 O(n^3)
	//3중 포문으로 각 지점에서 각 지점으로 가는 최단거리를 구함
	static int INF = 987654321; //INF는 10억쯤 되는 값이 편리하다고 한다
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		int[][] d = new int[n+1][n+1];
		
		for(int i=0;i<n+1;i++) {
			Arrays.fill(d[i], INF);
			d[i][i] = 0; //자기자신에서 자기자신 가는건 비용없이 가능
		}
		
		int xx,yy,ww;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			xx = Integer.parseInt(st.nextToken());
			yy = Integer.parseInt(st.nextToken());
			ww = Integer.parseInt(st.nextToken());
			d[xx][yy] = ww;
		}
		
		for(int k=1;k<n+1;k++) { //플로이드와샬 3중포문 최단거리를 구하고 O(n^3)임
			for(int i=1;i<n+1;i++) {
				for(int j=1;j<n+1;j++) {
					if(d[i][k] + d[k][j] < d[i][j]) {
						d[i][j] = d[i][k] + d[k][j];
					}
				}
			}
		}
		
		int max = -1;
		for(int i=1;i<n+1;i++) { //출발지->축제 + 축제->출발지를 max비교 
			max = Math.max(max, d[i][x]+d[x][i]);
		}
		
		System.out.println(max);
	}

}
