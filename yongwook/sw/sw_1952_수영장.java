package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_1952_수영장 {
	private static int[] price;
	private static int[] plan;
	private static int min;
	public static void main(String[] args) throws  IOException  {

		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		price = new int[5]; //1일  한달 3달 6개월
		plan = new int[13]; // 각월  수영자 이용계획
		
		for (int i = 1; i <= tc; i++) {
			
			min = Integer.MAX_VALUE;
			st= new StringTokenizer(br.readLine());
			
			
			for (int j = 1; j <= 4; j++) { // 1일 1달 3달 1년 요금 input
				price[j] = Integer.parseInt(st.nextToken());	
			}

			st= new StringTokenizer(br.readLine()); // 수영자 이용계획 input
			for (int j = 1; j <= 12; j++) {
				plan[j] = Integer.parseInt(st.nextToken());
			}


			dfs(1,0); // start month, money;
			System.out.println("#"+i+" "+min);

		}




	}
	private static void dfs(int month, int money) {
		
		if(month>=13) {
			
			min = Math.min(min, money);
			return;
		}
		
		 
		// 모든 경우의 수를 사용할땐 재귀를 사용하자...   // 여기서  0값 체크안해주는 이유는 어차피 최소체크
		dfs(month+1, money+plan[month]* price[1]);	
		dfs(month+1, money+ price[2]);
		dfs(month+3, money+ price[3]);
		dfs(month+12, money+ price[4]);
		
	}

	
}
