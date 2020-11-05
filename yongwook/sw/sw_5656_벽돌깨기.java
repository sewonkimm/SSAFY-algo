package sw;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import sw.sw_5656_벽돌깨기.Pair;

public class sw_5656_벽돌깨기 {

	static class Pair {
		int x;
		int y;
		int num;
		Pair(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
	
	static int N,W,H,min;
	static Queue<Pair> q;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[H][W];
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
            
			min = -1;
			solve(0,map);
            
			if(min == -1) //벽돌이 모두 깨진 경우
				System.out.println("#"+tc+" "+0);
			else
				System.out.println("#"+tc+" "+min);
		}
	}
	
    
	static void solve(int cnt, int[][] arr) {
		if(cnt == N) {
			int remain = 0;
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(arr[i][j] != 0)
						remain++;
				}
			}
            
			if(min == -1 || min > remain)
				min = remain;	
			return;
		}
		
        //모든 열에 대하여 구슬을 쏘는 경우를 구해준다.
		for(int j=0; j<W; j++) {
			int i = 0;
			while(i < H) {
				if(arr[i][j] != 0) break;
				i++;
			}
			
			if(i == H) continue; //해당 열이 모두 빈칸이라 다음 열로 넘어간다.
			
			int[][] arr2 = copyArr(arr);
			crush(i,j,arr2); //깨뜨리기
			move(arr2); // 빈 칸 정리
			solve(cnt+1,arr2); // 다음 구슬 쏘기
		}
	}
	
    
	static void move(int[][] arr) {
		for(int j=0; j<W; j++) {
			for(int i=H-1; i>0; i--) {	
				if(arr[i][j] == 0) {
                	//빈 칸을 찾으면 해당 빈칸 보다 위쪽 칸을 검사한다.
					int k = i-1;
					while(k >= 0) {
						if(arr[k][j] != 0) { //떠 있는 벽돌(빈 칸이 아닌 칸)을 발견하면
							arr[i][j] = arr[k][j]; //아래로 옮겨주고
							arr[k][j] = 0; //해당칸은 비워준다.
							break;
						}
						k--; //위쪽 칸을 계속 검사
					}
					if(k == -1) break; // 위쪽칸들이 모두 0인 경우 해당 열을 더 검사할 필요가 없으므로 다음 열로 넘어간다.
				}
			}
		}
	}
	
    
	static void crush(int x, int y, int[][] arr) {
		q = new LinkedList();
		q.add(new Pair(x,y,arr[x][y]));
		arr[x][y] = 0;
		
		while(!q.isEmpty()) {
			Pair p = (Pair) q.remove();
			for(int i=0; i<4; i++) {
				int nx = p.x;
				int ny = p.y;
				int num = p.num;
				for(int j=0; j<num-1; j++) {
					nx += dx[i];
					ny += dy[i];
					if(nx < 0 || nx >= H || ny < 0 || ny >= W) break;
					if(arr[nx][ny] == 0) continue;					
					if(arr[nx][ny] > 1)
						q.add(new Pair(nx,ny,arr[nx][ny]));
					arr[nx][ny] = 0; //깨트리기	
				}
	
			}
		}
	}
	
    
	static int[][] copyArr(int[][] arr) {
		int[][] newArr = new int[H][W];
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				newArr[i][j] = arr[i][j];
			}
		}
		return newArr;
	}

}