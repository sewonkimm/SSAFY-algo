import java.io.*;
import java.util.*;

public class algo_1015_boj2630_cutColoredPaper {

	static int blue,white;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		StringTokenizer st;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//n*n -> n=2^k, k=1~7
		cut(0,0,n);
		
		System.out.print(white+"\n"+blue);

	}
	
	static void cut(int x,int y,int n) {
		if(n==1) {
			if(map[x][y] == 1) blue++; //n이 1이면 더 이상 쪼갤 수 없음, 1이면 blue++
			else if(map[x][y] == 0) white++; //n이 1이면 더 이상 쪼갤 수 없음, 0이면 white++
			return;
		}
		int sum = 0;
		for(int i=x;i<x+n;i++) { //n*n만큼 탐색해서 더해보자 => 돌면서 map[x][y] 좌표와 다른게 나오면 멈추는 방식으로 해도 됨
			for(int j=y;j<y+n;j++) {
					sum+=map[i][j];			
			}
		}
		
		if(sum == n*n) { //n*n이 다 1이면 파란 종이다
			blue++;
		}
		else if(sum == 0) { //n*n이 다 0이면 하얀 종이다
			white++;
		}
		
		else {
			//시작점을 바꿔주면서 n을 1/2 시켜주자
			cut(x,y,n/2); //좌상
			cut(x,y+n/2,n/2); //우상
			cut(x+n/2,y,n/2); //좌하
			cut(x+n/2,y+n/2,n/2); //우하
		}
	}
}
