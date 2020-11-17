import java.io.*;
import java.util.*;

public class algo_1117_boj5567_wedding {

	//백준 5567 결혼식
	//나의친구 + 나의친구의 친구
	//나의 친구를 먼저 구한다 -> 그 친구들의 친구를 구한다
	static boolean[] friends; //방문여부
	static int[][] map;
	static List<Integer> list = new ArrayList<>();
	static int n;
	static int m;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		friends = new boolean[n+1];
		map = new int[n+1][n+1];
				
		StringTokenizer st;
		int a,b;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			map[a][b] = map[b][a] = 1;
			
			if(a == 1) {
				list.add(b);
			}
			if(b == 1) {
				list.add(a);
			}
		}
		
		while(!list.isEmpty()) {
			int now = list.get(0);
			friends[now] = true;
			for(int i=2;i<=n;i++) {
				if(now == i) continue;
				if(map[now][i] == 1) {
					friends[i] = true;
				}
			}
			list.remove(0);
		}
		
		int cnt = 0;
		for(int i=2;i<=n;i++) {
			if(friends[i] == true)
				cnt++;
		}
		System.out.println(cnt);
	}
}










