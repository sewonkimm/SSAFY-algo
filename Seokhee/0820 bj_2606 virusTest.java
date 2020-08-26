import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class virusTest {

	static int v;
	static int e;
	
	static int[] checked;
	static int[][] map;
	static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		v = Integer.parseInt(br.readLine());
		e = Integer.parseInt(br.readLine());
		
		int from, to;
		checked = new int[v+1]; //0이면 안걸린거 1이면 걸린거 
		
		map = new int[101][101]; //0이면 연결안됨
		
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine()," ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			
			map[from][to] = 1;
			map[to][from] = 1; //무향 그래프 !! 
			//1일경우 from-to(to-from)는 연결되어있다
		}
		
		//1에 연결된 애들부터 시작해보자
		for(int i=2;i<=v;i++) {
			if(map[1][i] == 1 && checked[i] == 0) {
				cnt++;
				checked[i] = 1;
				bfs(1,i);	
			}
		}
		
		System.out.println(cnt);
		
	}
	
	static void bfs(int a, int b) {
		for(int i=2;i<=v;i++) {
			//자기자신을 들릴 필요가 없다, bfs진행
			if(b!=i && map[b][i] == 1 && checked[i] == 0) {
				cnt++;
				checked[i] = 1;
				bfs(b,i);
			}
		}
	}

}
