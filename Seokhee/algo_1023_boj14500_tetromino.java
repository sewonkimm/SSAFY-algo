import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_1023_boj14500_tetromino {

	static int n,m;
	static int[][][] map,map2;
	//백준 테트로미노
	//전에 해봤어서 이번엔 맵을 돌리는 방식으로 해봤다
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //높이
		m = Integer.parseInt(st.nextToken()); //너비
		
		//n*m 4개
		map = new int[n][m][4];
		//m*n 4개
		map2 = new int[m][n][4];
		
		//돌리고 대칭시키는 것을 4개에 걸쳐서 넣어줌
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				int now = Integer.parseInt(st.nextToken());
				map[i][j][0] = map[n-i-1][j][1] = map[i][m-j-1][2] = map[n-i-1][m-j-1][3] = now;
			}
		}
		
		//돌리고 대칭시키는 것을 4개에 걸쳐서 넣어줌
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				int now = map[j][i][0];	
				map2[i][j][0] = map2[m-i-1][j][1] = map2[i][n-j-1][2] = map2[m-i-1][n-j-1][3] = now;
			}
		}
		
		//좌상단을 기준으로 더하는 메소드들을 만들자
		int max = 0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				for(int k=0;k<4;k++) {
					int s_result1 = s1(i,j,k);
					int s_result2 = s2(i,j,k);
					int s_result3 = s3(i,j,k);
					int s_result4 = s4(i,j,k);
					int s_result5 = s5(i,j,k);
					if(max < s_result1) max = s_result1;
					if(max < s_result2) max = s_result2;
					if(max < s_result3) max = s_result3;
					if(max < s_result4) max = s_result4;
					if(max < s_result5) max = s_result5;
				}
			}
		}
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<4;k++) {
					int s_result1 = s1_2(i,j,k);
					int s_result2 = s2_2(i,j,k);
					int s_result3 = s3_2(i,j,k);
					int s_result4 = s4_2(i,j,k);
					int s_result5 = s5_2(i,j,k);
					if(max < s_result1) max = s_result1;
					if(max < s_result2) max = s_result2;
					if(max < s_result3) max = s_result3;
					if(max < s_result4) max = s_result4;
					if(max < s_result5) max = s_result5;
				}
			}
		}
		
		
		
		System.out.println(max);
	}
	static int s1(int x, int y, int num) { // ㅡ
		if(y+3 >= m) return 0;
		int count=0;
		count = map[x][y][num]+map[x][y+1][num]+map[x][y+2][num]+map[x][y+3][num];
		return count;
	}
	static int s2(int x, int y, int num) { //ㅁ
		if(x+1 >= n || y+1 >=m) return 0;
		int count=0;
		count = map[x][y][num]+map[x][y+1][num]+map[x+1][y][num]+map[x+1][y+1][num];
		return count;
	}
	static int s3(int x, int y, int num) { //ㄴ
		if(x+2 >= n || y+1 >= m) return 0;
		int count=0;
		count = map[x][y][num]+map[x+1][y][num]+map[x+2][y][num]+map[x+2][y+1][num];
		return count;
	}
	static int s4(int x, int y, int num) {//N
		if(x+2 >= n || y+1 >= m) return 0;
		int count=0;
		count = map[x][y][num]+map[x+1][y][num]+map[x+1][y+1][num]+map[x+2][y+1][num];
		return count;
	}
	static int s5(int x, int y, int num) { //ㅜ
		if(x+1 >= n || y+2 >= m) return 0;
		int count=0;
		count = map[x][y][num]+map[x][y+1][num]+map[x][y+2][num]+map[x+1][y+1][num];
		return count;
	}
	
	static int s1_2(int x, int y, int num) { // ㅡ
		if(y+3 >= n) return 0;
		int count=0;
		count = map2[x][y][num]+map2[x][y+1][num]+map2[x][y+2][num]+map2[x][y+3][num];
		return count;
	}
	static int s2_2(int x, int y, int num) { //ㅁ
		if(x+1 >= m || y+1 >=n) return 0;
		int count=0;
		count = map2[x][y][num]+map2[x][y+1][num]+map2[x+1][y][num]+map2[x+1][y+1][num];
		return count;
	}
	static int s3_2(int x, int y, int num) { //ㄴ
		if(x+2 >= m || y+1 >= n) return 0;
		int count=0;
		count = map2[x][y][num]+map2[x+1][y][num]+map2[x+2][y][num]+map2[x+2][y+1][num];
		return count;
	}
	static int s4_2(int x, int y, int num) {//N
		if(x+2 >= m || y+1 >= n) return 0;
		int count=0;
		count = map2[x][y][num]+map2[x+1][y][num]+map2[x+1][y+1][num]+map2[x+2][y+1][num];
		return count;
	}
	static int s5_2(int x, int y, int num) { //ㅜ
		if(x+1 >= m || y+2 >= n) return 0;
		int count=0;
		count = map2[x][y][num]+map2[x][y+1][num]+map2[x][y+2][num]+map2[x+1][y+1][num];
		return count;
	}
}
