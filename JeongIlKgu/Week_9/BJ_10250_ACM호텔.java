/*
 * BJ 10250 ACM호텔
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10250_ACM호텔 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int dong = 0;
			int ho = 1;
			
			// 높이만큼 우선적으로 채워넣어야 하므로
			while(N > H) {
				N -= H;
				ho++;
			}
			// 남은 수가 dong이 된다.
			dong = N;
			
			if(ho < 10) {
				System.out.println(dong + "0" + ho);
			}else {
				System.out.print(dong);
				System.out.println(ho);
			}
		}
	}

}
