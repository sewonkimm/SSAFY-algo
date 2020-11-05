package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_5052_전화번호목록 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < tc; i++) {
			int tc2 = Integer.parseInt(br.readLine());
			String telphon[] = new String[tc2]; // 문자열로 받는이유는 공백이있을수도있고 startWith함수를 쓰기위해서다.
			//처음에 비교할대 이차원배열도생각해보고... 길이구해서 나눈다음에 앞자리 비교할가도생각했는데.. 좋은 api가 있다...
			int result = 0;
			for (int j = 0; j < tc2; j++) {
				telphon[j]= br.readLine().replace(" ", "");
			}
			//정렬을 해주면 사전순으로 정렬되어서 다음꺼만 비교하면된다.
			Arrays.sort(telphon);
			
			for (int j = 1; j < telphon.length; j++) {
				if(telphon[j].startsWith(telphon[j-1])) {
					result = 1;
				}
			}
			sb.append((result==1? "NO" : "YES" )+"\n");
		}
		System.out.println(sb);
		
	}
}	
