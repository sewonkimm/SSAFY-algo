/*
    모든 양과 늑대의 갯수를 세고
    BFS로 한 영역을 탐색해서 양이 더 많으면 양의 마릿수를 빼고, 늑대가 많으면 늑대 마릿수를 빼는 방식으로 구현했습니다.
    울타리로 쌓여있지 않은 탈출 가능한 영역을 탐색하게 되었을 경우에는 뺄셈하는 과정을 건너뛰도록 했는데
    틀렸다고 나오네요...
 */

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3184_양 {

	static int R, C, sheep, wolf;
	static char[][] map;
	static boolean[][] visited;
	static int[][] dir = { {-1,0}, {1,0}, {0,-1}, {0,1} };
	
	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'v')		wolf++;
				else if(map[i][j] == 'o')	sheep++;
			}
		}

		// 탐색
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] != '#' && !visited[i][j]) {	
					
					int o = 0;	// 구역 안 양의 수 
					int v = 0;	// 구역 안 늑대 수
					
					Queue<Point> q = new LinkedList<>();
					q.offer(new Point(i, j));
					visited[i][j] = true;
					
					boolean flag = true; 
					while(!q.isEmpty()) {
						Point now = q.poll();
						if(map[now.x][now.y] == 'o')		o++;
						else if(map[now.x][now.y] == 'v')	v++;
							
						for(int k=0; k<4; k++) {	// 4방 탐색
							int nx = now.x + dir[k][0];
							int ny = now.y + dir[k][1];
							
							if(nx < 0 || nx >= R || ny < 0 || ny >= C)	{	// 탈출 가능한 구역
								flag = false;
								continue;
							}
							
							if(!visited[nx][ny] && map[nx][ny] != '#') {
								visited[nx][ny] = true;
								q.offer(new Point(nx, ny));
							}
						}
					}		
					
					if(flag) {			// 탈출하지 못하는 영역안에 있을 경우
						if(o > v) {		// 구역안에 양의 수가 늑대보다 많을 때
							wolf -= v;
						}
						else {			// 구역안에 늑대의 수가 양보다 많을 때 
							sheep -= o;
						}
					}
				}
			}
		}
		
		// output
		System.out.println(sheep+" "+wolf);
	}

}
