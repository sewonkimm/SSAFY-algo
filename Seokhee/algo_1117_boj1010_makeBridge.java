import java.io.*;
import java.util.*;

public class algo_1117_boj1010_makeBridge {

	//nCr = n-1Cr-1 + n-1Cr
	public static void main(String[] args) throws NumberFormatException, IOException {
		long[][] combi = new long[31][31];
		for(int i=1;i<=30;i++) {
			combi[i][0] = 1;
			combi[i][1] = i;
		}
		
		for(int i=2;i<=30;i++) {
			for(int j=i;j<=30;j++) {
				combi[j][i] = combi[j-1][i-1] + combi[j-1][i];
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int a,b;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			System.out.println(combi[b][a]);
		}
		
	}
}
