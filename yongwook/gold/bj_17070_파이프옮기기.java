package gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj_17070_파이프옮기기 {
	static int map[][] ;
	static int visit[][];
	static int result;
	static int dx[] = {1,0,1};//하 우 하우 
	static int dy[] = {0,1,1};
	static int T,state;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//	StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		map = new int[T][T];
		result = 0;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < T; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		map[0][0] = 2; 
		map[0][1] = 2;
		state = 1;
		check(0,1);
		
		System.out.println(result);
		
	}	
	
	public static void check(int x, int y) {
		
		if(state== 1) {	 // 가로로 놓임 
			for (int i = 1; i < 3; i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;
				if(nx<T && ny < T && nx>=0 && ny>=0 && map[nx][ny]==0 )  {
					
					if(i==1 ) {
						map[nx][ny] =2;
						state = 1;
						if(map[T-1][T-1] == 2) {
							result++;
							state = 1;
						}
						
						check(nx,ny);
						map[nx][ny] =0;
					}
					else if(i==2 && map[nx-1][ny]==0 && map[nx][ny-1] ==0) {
						map[nx][ny]=2;
						state = 3;
						
						if(map[T-1][T-1] == 2) {
							result++;
							state = 1;
						}
						check(nx,ny);
						map[nx][ny] =0;
					}
				}
					
			}
		}
		else if(state== 2) { // 세로로 놓임 
			for (int i = 0; i < 3; i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;
				if(nx<T && ny < T && nx>=0 && ny>=0 && i!=1 && map[nx][ny]==0 ) {
					
					if(i==0 ) {
						map[nx][ny] =2;
						state = 2;
						if(map[T-1][T-1] == 2) {
							result++;
							state = 1;
						}
						check(nx,ny);
						map[nx][ny] =0;
					}
					else if(i==2 && map[nx-1][ny]==0 && map[nx][ny-1] ==0) {
						map[nx][ny]=2;
						state = 3;
						if(map[T-1][T-1] == 2) {
							state = 1;
							result++;
						}
						
						check(nx,ny);	
						map[nx][ny] =0;
					}
				}
					
			}
		}
	
		else if(state== 3) { // 대각으로 놓임 
			for (int i = 0; i < 3; i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;
				if(nx<T && ny < T && nx>=0 && ny>=0  && map[nx][ny]==0) {

					if(i==0 ) {
						map[nx][ny] =2;
						state = 2;
						if(map[T-1][T-1] == 2) {
							state = 1;
							result++;
						}
						check(nx,ny);
						map[nx][ny] =0;
					}
					else if(i==1 ) {
						map[nx][ny] =2;
						state = 1;
						if(map[T-1][T-1] == 2) {
							state = 1;
							result++;
						}
						check(nx,ny);
						map[nx][ny] =0;
					}
					else if(i==2 && map[nx-1][ny]==0 && map[nx][ny-1] ==0) {
						map[nx][ny]=2;
						state = 3;
						if(map[T-1][T-1] == 2) {
							state = 1;
							result++;
						}
						check(nx,ny);
						map[nx][ny] =0;	
					}
					
				}
					
			}
		}
	
		
	}
}
