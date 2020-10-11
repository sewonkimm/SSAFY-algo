/*
 * BJ 7568 덩치
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_7568_Bulk {
	
	static class person{
		int weight, height;

		public person(int weight, int height) {
			this.weight = weight;
			this.height = height;
		}
	}
	static person[] p; // 사람들이 담길 배열

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		p = new person[N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			p[i] = new person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		// 확인
		int count = 0;
		for (int i = 0; i < N; i++) {
			count = 0;
			for (int j = 0; j < N; j++) {
				if(i == j) continue;
				
				if(p[i].weight < p[j].weight && p[i].height < p[j].height) count++;
			}
			System.out.print((count+1) + " ");
		}
	}

}
