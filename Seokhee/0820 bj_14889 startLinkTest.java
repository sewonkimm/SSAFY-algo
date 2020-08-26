import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class startLinkTest {

	//백트래킹 사용.. 
	static int n;
	static int[][] map;
	static int[][] select;
	static int[] check;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//n은 짝수, n/2명으로 이루어진 링크팀과 스타트팀, 최대 20명
		check = new int[n]; //0과 1은 다른팀 n/2까지 세주자
		
		
		
		dfs(0,0);
		System.out.println(min);
	}

	
	static void dfs(int now, int cnt) {
		if(cnt == n/2) {
			//계산->dfs
			//여기부분 좀 더 좋은 방법이 있을거 같음(비트마스킹?)
			select = new int[n][n];
			
			int start = 0;
			int link = 0;
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(check[i] == 1 && check[j] == 1) {
						start+=map[i][j];
					}
					else if(check[i] == 0 && check[j] == 0){
						link+=map[i][j];
					}
				}
			}			
			
			int result = (int)Math.abs(start-link);
			if(min>result)
				min = result;

			return;
		}
		
		//백트래킹
		for(int i=now; i<n; i++) { //연산수 줄이기위해서 now 활용
			check[i] = 1;
			dfs(i+1,cnt+1);
			check[i] = 0;
		}
	}
}














