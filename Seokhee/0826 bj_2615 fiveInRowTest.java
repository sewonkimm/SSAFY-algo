import java.io.*;
import java.util.*;

public class fiveInRowTest {

	//백준 2615번 오목 0826과제
	//본래라면 dfs,bfs를 활용해서 풀어야하겠지만 리스트에 돌이 존재하는 곳만의 위치를 활용하여
	//단순 브루트포스로도 풀 수 있게하였다.
	static int[][] map;
	static int[] dx = { 0,-1,-1, 1}; 
	static int[] dy = {-1,-1, 0,-1};
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<int[]> stone = new ArrayList<>();
		n = 19; //바둑판
		map = new int[n][n];
		StringTokenizer st;
		
		//map에는 꼭 다 넣어주고 8방으로 2칸씩 검사를 할 예정이라서 리스트에는 마지막 2칸은 쳐내줌
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(i<17 && j<17 && i>=2 && j>=2 && (map[i][j] == 1 | map[i][j] == 2)) {
					stone.add(new int[] {i,j});
				}
			}
		}
		
		//fiveInRow를 해서 답이나오면 그만하자, 답은 1개이거나 없다.
		int[] a = new int[2];
		for(int i=0;i<stone.size();i++) {
			a[0] = stone.get(i)[0];
			a[1] = stone.get(i)[1];
			if(fiveInRow(a[0],a[1],map[a[0]][a[1]]) == true) {
				stone.clear();
				return;
			}
		}
		System.out.println(0);
	}
	static boolean fiveInRow(int x,int y,int num) {

		//8방탐색 (답에서 점의 위치를 출력하기위해 통일성을 가지도록 4방만 사용(음수쪽도 검사하기때문에 8방탐색과 동일)
		int a,b,c,d,e=0,f=0;
		for(int i=0;i<4;i++) {
			a = map[x+dx[i]][y+dy[i]];
			b = map[x-dx[i]][y-dy[i]];
			c = map[x+2*dx[i]][y+2*dy[i]];
			d = map[x-2*dx[i]][y-2*dy[i]];
			
			
			//6목이상이 되는 것을 방지하기위해서, 그러나 바둑판 범위 바깥일 경우 그냥 e,f는 0이되어도 상관없음
			//바둑판 범위 바깥일 경우 = 그 줄은 2혹은 16이 포함된 줄이므로 6목의 가능성은 없다.
			if(x+3*dx[i]>=0 && y+3*dy[i]>=0 && x+3*dx[i]<n && y+3*dy[i]<n)
				e = map[x+3*dx[i]][y+3*dy[i]];
			if(x-3*dx[i]>=0 && y-3*dy[i]>=0 && x-3*dx[i]<n && y-3*dy[i]<n)
				f = map[x-3*dx[i]][y-3*dy[i]];

			//5목이면서 6목이상은 아닌것?
			if( num== a &&
				num== b &&
				num== c &&
				num== d &&
				num!= e &&
				num!= f) { //출력하고 가장 왼쪽위의 돌 출력
				System.out.println(num);
				System.out.println((x+2*dx[i]+1)+" "+(y+2*dy[i]+1));
				return true;
			}
		}
		//없으면 false하면 main에서 알아서 0 출력해줌
		return false;
	}

}
