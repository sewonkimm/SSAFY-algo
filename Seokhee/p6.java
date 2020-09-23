import java.io.*;
import java.util.*;
public class p6 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp1 = new int[n]; //커지는 
		int[] dp2 = new int[n]; //작아지는
		
		dp1[0] = 1;
		dp2[0] = 1;
		int max = 1;
		for(int i=1;i<n;i++) {
			if(num[i]>=num[i-1])
				dp1[i] = dp1[i-1]+1;
			else dp1[i] = 1;
			if(dp1[i] > max)
				max = dp1[i];
		}
		
		for(int i=1;i<n;i++) {
			if(num[i]<=num[i-1])
				dp2[i] = dp2[i-1]+1;
			else dp2[i] = 1;
			
			if(dp2[i] > max)
				max = dp2[i];
		}
		

		System.out.println(max);
		
	}

}
