import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_1860_ºØ¾î»§ {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int tc = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int Z[] = new int[N]; //»ç¶÷ÀÌ ¹æ¹®ÇÑ ÃÊ 
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				Z[j]= Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(Z);
			int number = K; // 2ÃÊ¿¡ ¸¸µå´Â ºØ¾î»§¼ö\
			int number1[] = new int[N];
			String table = "Possible" ;
			int cnt = 0; //ÆÈ¸°°¹¼ö
			for (int j = 0; j < Z.length; j++) {
				number1[j] = Z[j]/M*K-cnt; // ÇØ´ç»ç¶÷ÀÌ ¿ÔÀ»¶§ ÃÑ ºØ¾î»§¼ö
				if(number1[j]>= 1) {
					cnt++;
				}
				else {
					table = "impossible";
				}
			}
			
			System.out.println("#"+(i+1)+" "+ table);
		}
	}
}
