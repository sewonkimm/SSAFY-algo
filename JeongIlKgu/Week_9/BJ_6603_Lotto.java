/*
 * BJ 6603 로또
 * 조합
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_6603_Lotto {
	
	static int[] input, tarArray;
	static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			K = Integer.parseInt(st.nextToken()); // 뽑는 수의 개수
			
			if(K == 0) break;
			
			input = new int[K];
			for (int i = 0; i < K; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			tarArray = new int[6];
			Comb(0,0);
			System.out.println();
		}
	}

	private static void Comb(int srcIdx, int tarIdx) {
		// 6개의 로또 번호가 뽑힌 경우
		if(tarIdx == 6) {
			show();
			return;
		}
		
		if(srcIdx == K) return;
		
		tarArray[tarIdx] = input[srcIdx];
		Comb(srcIdx+1, tarIdx+1);
		Comb(srcIdx+1, tarIdx);
	}
	
	private static void show() {
		Arrays.sort(tarArray);
		for (int i = 0; i < 6; i++) {
			System.out.print(tarArray[i] + " ");
		}
		System.out.println();
	}
}
