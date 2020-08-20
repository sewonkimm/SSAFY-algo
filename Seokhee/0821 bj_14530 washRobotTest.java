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
		
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
	}
	//0-북, 1-동, 2-남, 3-서
	static void recursive(int x,int y, int dir) { 
		//System.out.println(x+" "+y+" "+dir);
		if(map[x][y] ==0) cnt++;
		map[x][y] = 2;
		
		
		//극혐.. 그냥 d만 써서 4번 반복하는게 나을듯
		for(int i=0;i<4;i++) {
			if(x+lx[(dir+4-i)%4]>=0 && y+ly[(dir+4-i)%4]>=0 
					&& x+lx[(dir+4-i)%4]<n && y+ly[(dir+4-i)%4]<m) {
				if(map[x+lx[(dir+4-i)%4]][y+ly[(dir+4-i)%4]] == 0) {
					recursive(x+lx[(dir+4-i)%4],y+ly[(dir+4-i)%4],(dir+3-i)%4);
					return;
				}		
			}
		}
		
//		//지금 바라보는 방향의 좌측
//		if(x+lx[d]>=0 && y+ly[d]>=0 && x+lx[d]<n && y+ly[d]<m) {
//			if(map[x+lx[d]][y+ly[d]] == 0) {
//				recursive(x+lx[d],y+ly[d],(dir+3)%4);
//				return;
//			}		
//		}
		
		
		if(x-dx[dir]>=0 && y-dy[dir]>=0 && x-dx[dir]<n && y-dy[dir]<m) {
			if(map[x-dx[dir]][y-dy[dir]] != 1)
				recursive(x-dx[dir],y-dy[dir],dir);
		}	
	}



}






