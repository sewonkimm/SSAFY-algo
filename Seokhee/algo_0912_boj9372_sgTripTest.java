import java.io.*;
import java.util.*;
public class algo_0912_boj9372_sgTripTest {

	//백준 상근이의 여행 9372번
	//최소스패닝트리 문제인 줄 알았지만 모든 가중치가 1이므로 dfs,bfs를 활용해도 되고 프림 등의 알고리즘을 사용해도 된다.
	//반드시 도시들을 연결 할 수 있다는 조건덕에 반드시 n-1이 답이 됨
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int n,m;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				//안해도됨, 반드시  모든 도시가 연결 될 수 있으면 가중치가 1인 최소스패닝트리의 개수는 n-1이 된다.
			}
			System.out.println(n-1);
		}
	}

}
