import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class washRobotTest {

	static int n; //세로(높이 - x)
	static int m; //가로(너비 - y)
	static int r,c;
	static int d; //0-북, 1-동, 2-남, 3-서
	
	static int cnt; 
	
	//편의를 위해서 만들자 
	//후진용
	static int[] dx = {-1, 0, 1, 0}; //북동남서
	static int[] dy = { 0, 1, 0,-1}; //북동남서
	
	//회전용
	static int[] lx = { 0,-1, 0, 1};//~을 바라보고 좌측
	static int[] ly = {-1, 0, 1, 0};
			
	
	static int[][] map;
	//청소하면 2로 바꿔주자?
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s;
		st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		st = new StringTokenizer(br.readLine()," ");
		r = Integer.parseInt(st.nextToken()); //로봇청소기 x
		c = Integer.parseInt(st.nextToken()); //로봇청소기 y
		d = Integer.parseInt(st.nextToken()); //0-북, 1-동, 2-남, 3-서
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		recursive(r,c,d);
		System.out.println(cnt); //청소하는 칸의 개수
		
	}
	//0-북, 1-동, 2-남, 3-서
	static void recursive(int x,int y, int dir) { 
		if(map[x][y] ==0) cnt++;
		map[x][y] = 2;
		
		
		//극혐.. 그냥 d만 써서 4번 반복하는게 나을듯
		for(int i=0;i<4;i++) { //좌측탐색->없으면좌측회전->좌측탐색->없으면좌측회전 반복
			//바라보는방향기준 왼쪽칸이 범위에 유효한가? (이 바라보는 방향은 for문에 의해 바뀜)
			if(x+lx[(dir+4-i)%4]>=0 && y+ly[(dir+4-i)%4]>=0 
					&& x+lx[(dir+4-i)%4]<n && y+ly[(dir+4-i)%4]<m) {
				//해당구역이 청소안한곳이면?
				if(map[x+lx[(dir+4-i)%4]][y+ly[(dir+4-i)%4]] == 0) {
					//그쪽으로 이동하면서 방향도 바꿔준다
					recursive(x+lx[(dir+4-i)%4],y+ly[(dir+4-i)%4],(dir+3-i)%4);
					//청소할 곳 찾았으면 더 반복할 이유없음
					return;
				}		
			}
		}		
		
		//사방이 청소되어있거나 벽이면 바라보는 방향 그대로 후진, 후진할 때 벽있으면 그대로 청소 끝(recursive종료)
		if(x-dx[dir]>=0 && y-dy[dir]>=0 && x-dx[dir]<n && y-dy[dir]<m) {
			if(map[x-dx[dir]][y-dy[dir]] != 1)
				recursive(x-dx[dir],y-dy[dir],dir);
		}	
	}
}






