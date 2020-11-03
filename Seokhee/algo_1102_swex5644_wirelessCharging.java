import java.io.*;
import java.util.*;

public class algo_1102_swex5644_wirelessCharging {

	static int T,m,a;
	static int[] manA,manB;
	static int dx[] = {0,-1,0,1,0};
	static int dy[] = {0,0,1,0,-1};
	static ArrayList<BC> BClist;
	static class BC{
		int x;
		int y;
		int c;
		int p;
		
		public BC(int x, int y, int c, int p) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		
		manA = new int[m];
		manB = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			manA[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			manB[i] = Integer.parseInt(st.nextToken());
		}
		
		
		
		BClist = new ArrayList<>();
		for(int i=0; i<a; i++) {
			st = new StringTokenizer(br.readLine());
			
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			BClist.add(new BC(x,y,c,p));
		}
		
		int x1 = 1;
		int y1 = 1;
		int x2 = 10;
		int y2 = 10;
		
		int sum = getMax(x1,y1,x2,y2);
		
		for(int i=0; i<m; i++) {
			x1 += dx[manA[i]];
			y1 += dy[manA[i]];
			x2 += dx[manB[i]];
			y2 += dy[manB[i]];
			
			sum += getMax(x1,y1,x2,y2);
		}
		
		System.out.println("#"+(t+1)+" "+sum);
		}
	}
	static int getMax(int x1,int y1, int x2, int y2) {
		int[][] amount = new int[2][a];
		
		for(int i=0;i<a;i++) {
			amount[0][i] = check(x1,y1,i);
		}
		
		for(int i=0;i<a;i++) {
			amount[1][i] = check(x2,y2,i);
		}
		
		int max = 0;
		for(int i=0;i<a;i++) {
			for(int j=0;j<a;j++) {
				int sum = amount[0][i] + amount[1][j];
				
				if(i==j && amount[0][i] == amount[1][j])
					sum/=2;
				if(sum > max)
					max = sum;
			}
		}
		return max;
	}
	static int check(int x, int y, int num) {

		int a = Math.abs(x-BClist.get(num).x);
		int b = Math.abs(y-BClist.get(num).y);
		int dist = a+b;
        
        //해당 BC에 포함되는 경우에 p값을 리턴
		if(dist <= BClist.get(num).c)
			return BClist.get(num).p;
		else
			return 0;
	}
}
