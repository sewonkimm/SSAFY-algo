package practice;
import java.util.Scanner;

public class sw_1226_미로1 {
	static int cnt=0;
	static int[] visit[] = new int[16][16];
	static int map[][] = new int[16][16];
	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		
		
		
		for (int tc = 0; tc < 10; tc++) {
			cnt= 0;
			int N = sc.nextInt();
			for (int i = 0; i < 16; i++) {
				String input = sc.next();
				for (int j = 0; j < 16; j++) {
					map[i][j] =  input.charAt(j)-'0';
					visit[i][j]=  input.charAt(j)-'0';
				}
			}
					
					check(1,1);
			System.out.println("#"+(tc+1+" "+cnt));
		}
	}
	
	static void check(int x , int y) {
		visit[x][y] = 1;
		int dx[] = {-1,1,0,0};
		int dy[] = {0,0,-1,1};
			for (int i = 0; i < 4; i++) {
				int nx = dx[i]+x;
				int ny = dy[i]+y;
				if(nx>=0 && ny>=0 && nx<16 && ny<16 ) {
					if(map[nx][ny] == 3) cnt++;
					if(map[nx][ny]== 0 && visit[nx][ny] ==0) {
						if(map[nx][ny]== 3) {
							cnt ++;
							break;
						}
						else {
							check(nx,ny);
						}
					}
				}
			}
		
	}
}
