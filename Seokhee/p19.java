import java.io.*;
import java.util.*;
public class p19 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] room = new int[2][7];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			room[s][c]++;
		}
		
		int cnt = 0;
		for(int i=0;i<2;i++) {
			for(int j=1;j<=6;j++) {
				if(room[i][j] == 0)
					continue;
				cnt += (room[i][j]-1)/k+1;
			}
		}
		System.out.println(cnt);
	}

}
