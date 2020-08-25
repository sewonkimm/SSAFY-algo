package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_6782_현주가좋아하는제곱근놀이 {
	static long cnt = 0;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long tc = Long.parseLong(st.nextToken());
		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			long N =  Long.parseLong(st.nextToken());;
			cnt =0;
			while(N!=2) {
				double a =  Math.sqrt(N);
				if ((long)a*a==N) {
					N = (long)a ; 
				}else {
					a = (long)a;
					cnt += ((a+1)*(a+1)-N);
	                N = (long)Math.sqrt((a+1)*(a+1));
				}
				cnt++;
			}
			System.out.println("#"+(i+1)+" "+cnt);
		}
		
		
		
	}
}

