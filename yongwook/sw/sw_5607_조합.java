package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_5607_조합 {
	static int number = 1234567891;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long arr[] = new long[1000001];
		arr[0] = 1;
		for (int i = 1; i < 1000001; i++) {
			arr[i]= (arr[i-1]*i)%number;
		}
		for(int t=1;t<= N;t++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			

            long bottom = (arr[r] * arr[n - r]) % number;
            long reBottom = fermat(bottom, number - 2);

            System.out.println((arr[n] * reBottom) % number);
		}
	}
	 private static long fermat(long n, int x) {
	        if (x == 0) return 1;
	        long tmp = fermat(n, x / 2);
	        long ret = (tmp * tmp) % number;
	        if (x % 2 == 0) return ret;
	        else return (ret * n) % number;
	    }
}
