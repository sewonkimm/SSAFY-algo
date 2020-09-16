import java.io.*;
import java.util.*;
public class algo_0913_boj1194_moonTest {
	//백준 1194 달이차오른다 가자
	//bfs + 비트마스킹
	//일반 bfs랑 다른점
	//1. 출구가 여러개라서(보통 bfs에선 배열의 끝 r,c값으로 1개임) 리스트에 담고 매 poll시마다 위치 체크를 리스트전체에서 찾아봄
	//2. 키를 비트에 담고서 문을 만나면 대소문자는 아스키코드에서 32가 차이나므로 키 저장은 'a'를 빼주는 식으로, 문은 32와 'a'를 빼주는 식으로 비트마스크과정을 진행
	//3. 해당 지점을 방문했는지는 키를 가진 상태를 담고있는 1칸의 배열이 더 필요해서 좌표값 + 키 상태를 저장해둘 3차원 check배열을 사용
	static int n,m;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static char[][] map;
	static boolean[][][] check;
	static List<int[]> exit = new ArrayList<>();
	static Queue<Point> queue = new LinkedList<>();
	static class Point{
		int x;
		int y;
		int cnt;
		int key;
		public Point(int x, int y, int cnt, int key) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.key = key;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		check = new boolean[n][m][1<<6]; //키를 가지고 있는 경우는 0(000000)~63(111111)의 값이 나오므로 64크기로 선언하면 딱맞다
		String s;
		
		for(int i=0;i<n;i++) { //char배열이라 간편하게 for문 1개로 가능
			s = br.readLine();
			map[i] = s.toCharArray();
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] == '0') {
					map[i][j] = '.';
					queue.add(new Point(i,j,0,0)); //시작점은 한개이므로 .으로 그냥 바꿔준다
					check[i][j][0] = true; //시작점은 키를 한개도 없이 방문한 적이 있다고 바꿔줌
				}
				else if(map[i][j] == '1') {
					exit.add(new int[] {i,j}); //탈출구는 리스트에 저장 (개수가 주어지지않고 최소 1개 이상으로 가변적)
				}
			}
		}

		bfs();
	}
	
	static void bfs() {
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int i=0;i<exit.size();i++) { //출구인지 리스트를 for문으로 방문하여 확인
				if(p.x == exit.get(i)[0] && p.y == exit.get(i)[1]) {
					System.out.println(p.cnt);
					return;
				}
			}
			
			for(int i=0;i<4;i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny<m) {
					if(map[nx][ny] != '#') { //벽이 아니라면
						int nowKey = p.key; //현재 키 상태를 nowkey에 저장
						if(map[nx][ny] >='a' && map[nx][ny] <='f') { //키를 만나면
							nowKey = p.key | (1<<(map[nx][ny]-'a')); //nowkey변경
							if(check[nx][ny][nowKey] == false) { //해당 키상태로 방문한 적이 없으면
								queue.add(new Point(nx,ny,p.cnt+1,nowKey)); //거기서 부터 시작
								check[nx][ny][nowKey] = true; //방문처리
							}
						}
						else if(map[nx][ny] >='A' && map[nx][ny] <='F') { //문을 만나면
							if((nowKey & (1<<(map[nx][ny]-32-'a')))>0) { //해당 키를 가지고 있으면
								if(check[nx][ny][nowKey] == false) { //해당 키 상태로 방문한 적이 없으면
									queue.add(new Point(nx,ny,p.cnt+1,nowKey)); //거기서부터 시작
									check[nx][ny][nowKey] = true; //방문처리
								}
							}
						}
						else if(check[nx][ny][nowKey] == false) { //키도 문도 아닌데 해당 키 상태로 방문한 적이 없으면
							queue.add(new Point(nx,ny,p.cnt+1,nowKey)); //거기서부터 시작
							check[nx][ny][nowKey] = true; //방문처리
						}
					}
				}
			}
		}
		
		//큐가 비면 더 이상 새로이 움직일 방법이 없다는 뜻
		System.out.println(-1);
	}
}













