import java.io.*;
import java.util.*;
public class algo_0907_boj15683_keepingWatchTest {

	//백준 15683 감시
	//구현문제이고 조건들이 까다로워서 잘 보고 풀어야한다
	static int r,c;
	static int num;
	static int min = Integer.MAX_VALUE;
	static int[][] map;
	static int[][][] copy;
	static int[] dx = {-1,0,1,0}; //상 좌 하 우 시계방향 혹은 반시계방향으로 해야 편하다
	static int[] dy = {0,-1,0,1};
	static List<int[]> cctv = new ArrayList<>(); //씨씨티비위치
	static Queue<int[]> cctv5 = new LinkedList<>(); //5번씨씨티비위치
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
		
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<c;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] >=1 && map[i][j] <= 4) {
					cctv.add(new int[] {i,j,map[i][j]});
				}
				else if(map[i][j] == 5) //5번은 따로저장 4방이므로
					cctv5.add(new int[] {i,j});
			}
		}
		int d3 = (int)Math.pow(4, cctv.size());
		copy = new int[r][c][d3*4]; //대충 크게 선언 (d3이상으로) 
		
		//5번 cctv는 경우의수 돌릴 필요가 없어서 애초에 map자체를 바꿔줘도 됨
		//아예 맵 자체를 바꿔주는 알고리즘
		int size = cctv5.size();
		for(int i=0;i<size;i++) {
			int[] now5 = cctv5.poll();
			int x = now5[0];
			int y = now5[1];
			for(int j=0;j<4;j++) {
				int nx = x;
				int ny = y;
				while(true) {
					nx = nx+dx[j];
					ny = ny+dy[j];
					if(nx>=0 && ny>=0 && nx<r && ny<c) {
						if(map[nx][ny] == 0 || map[nx][ny] == -1)
							map[nx][ny] = -1;
						else if(map[nx][ny] == 6) break;
					}
					else break;
				}
			}
		}
		
		if(cctv.size()==0) { //5가 cctv사이즈에서 빠지므로(cctv5에 포함) 0일 가능성이 생김
			System.out.println(check(map));
			return;
		}
		
		num = 0;
		for(int i=0;i<4;i++) { 
			int nn = num; //copy는 배열이므로 여러개가 필요하다고 생각했음, copy의 번호, 1씩 상승
			copy1(map,copy,nn);  //현재상태를 임시카피에 넣어두고
			num++;
			dfs(i,0,nn); //map을 가지고 dfs연산을 한다
			
			copy2(copy,map,nn); //해당 dfs가 끝나면 copy에서 map으로 복사해서 dfs시작전으로 만들어줌 			
		}
		System.out.println(min);
	}
	private static void dfs(int input, int cNum, int nn) {

		int[] now = cctv.get(cNum); //cctv를 꺼내와서
		int x = now[0];
		int y = now[1];
		int cN = now[2];
		
		
		int nx = x;
		int ny = y;
		
		//한 방향만 볼때
		if(cN == 1) { //정해진 방향(input)으로 다 -1로 체크
			nx = x;
			ny = y;
			while(true) {
				nx = nx+dx[input];
				ny = ny+dy[input];
				if(nx>=0 && ny>=0 && nx<r && ny<c) {
					if(map[nx][ny] == 0 || map[nx][ny] == -1)
						map[nx][ny] = -1;
					else if(map[nx][ny] == 6) break;
				}
				else break;
			}
		}
		//반대방향을 향할 때
		else if(cN == 2) {
			for(int i=0;i<4;i=i+2) { //포문을 2번만 돌도록 했음, 반대방향이라서 2만큼의 차이를 의도함
				nx = x;
				ny = y;
				while(true) {
					nx = nx+dx[(input+i)%4];
					ny = ny+dy[(input+i)%4];
					if(nx>=0 && ny>=0 && nx<r && ny<c) {
						if(map[nx][ny] == 0 || map[nx][ny] == -1)
							map[nx][ny] = -1;
						else if(map[nx][ny] == 6) break;
					}
					else break;
				}
			}
		}
		//90도 각도로 본다
		else if(cN == 3) {
			for(int i=0;i<2;i++) { //1만큼의 차이를 의도해서 2만큼만 돌리면됨, 방향은 input이 정해줌
				nx = x;
				ny = y;
				while(true) {
					nx = nx+dx[(input+i)%4];
					ny = ny+dy[(input+i)%4];
					if(nx>=0 && ny>=0 && nx<r && ny<c) {
						if(map[nx][ny] == 0 || map[nx][ny] == -1)
							map[nx][ny] = -1;
						else if(map[nx][ny] == 6) break;
					}
					else break;
				}
			}
		}
		//세 방향을 본다
		else if(cN == 4) {
			for(int i=0;i<3;i++) {//1만큼의 차이를 의도해서 3만큼만 돌리면됨, 방향은 input이 정해줌
				nx = x;
				ny = y;
				while(true) {
					nx = nx+dx[(input+i)%4];
					ny = ny+dy[(input+i)%4];
					if(nx>=0 && ny>=0 && nx<r && ny<c) {
						if(map[nx][ny] == 0 || map[nx][ny] == -1)
							map[nx][ny] = -1;
						else if(map[nx][ny] == 6) break;
					}
					else break;
				}
			}
		}

		if(cNum+1 == cctv.size()) { //모든 씨씨티비를 다 봤다면 0의 개수를 체크(사각지대)
			int cnt = check(map);
			if(min>cnt) //비교
				min = cnt;
			return;
		}
		
		for(int i=0;i<4;i++) { //dfs내에서 계속 모든 경우의수로 씨씨티비를 다 사용할 때 까지 dfs반복
			
			int na = num;
			
			copy1(map,copy,na);
			num++;
			dfs(i,cNum+1,na);
			copy2(copy,map,na);	
		}
	}
	//map to copy
	private static void copy1(int[][] m, int[][][] cp, int n) {
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				cp[i][j][n] = m[i][j];
			}
		}
	}
	//copy to map
	private static void copy2(int[][][] cp, int[][] m, int n) {
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				 m[i][j] = cp[i][j][n];
			}
		}
	}

	//사각지대의 개수를 세주는 check
	private static int check(int[][] m) {
		int cnt = 0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(m[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}
}
