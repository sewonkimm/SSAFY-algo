import java.io.*;
import java.util.*;
public class p17 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] num = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int sum = 0;
		for(int i=0;i<k;i++) {
			sum += num[i];
		}
		
		int max = sum;
		
		for(int i=0;i<n-k;i++) {
			sum -= num[i];
			sum += num[i+k];
			
			if(max < sum)
				max = sum;
		}
		
		System.out.println(max);
		
	}

}
