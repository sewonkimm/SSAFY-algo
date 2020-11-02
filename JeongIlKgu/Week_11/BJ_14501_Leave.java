/*
 * BJ 14501 퇴사
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14501_Leave {
	
	static int N, max;
	static int[] time, pay;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		time = new int[N+1];
		pay = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			time[i] = Integer.parseInt(st.nextToken());
			pay[i] = Integer.parseInt(st.nextToken());
		}
		
		check(1,0);
		
		System.out.println(max);
	}
	
	private static void check(int day, int total) {
		if(day == N+1) {
			max = Math.max(total, max);
			return;
		}
		
		check(day+1, total);
		
		if(day + time[day] <= N+1) {
			check(day + time[day], total+pay[day]);
		}
	}
}
