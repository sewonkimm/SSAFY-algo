/*
 * BJ 15651 N 과 M (3)
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_15651_NandM3 {
	
	static int[] arr;
	static int N,M;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		perm(0);
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static void perm(int cnt) throws IOException {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				bw.write(String.valueOf(arr[i])+" ");
			}
			bw.newLine();
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			arr[cnt] = i;
			perm(cnt+1);
		}
	}
}
