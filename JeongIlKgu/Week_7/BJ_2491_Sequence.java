/*
 * BJ 2491 수열
 * 증가와 감소의 길이를 각각 두어 계산
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2491_Sequence {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()); // 입력될 수의 개수
		// 길이의 최대 값, 입력받는 수, 비교할 전 값
		int max = Integer.MIN_VALUE, num = 0, prev = 0;
		// 증가와 감소하는 수의 길이
		int lenUp = 1, lenDown = 1;
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		// 처음 입력되면 len은 +1되고 총 개수 -1
		prev = Integer.parseInt(st.nextToken()); // 최초 값
		N--;
		// 확인
		while(st.hasMoreTokens()) {
			num = Integer.parseInt(st.nextToken());
			if(prev < num) { // 증가
				lenUp++;
				max = Math.max(lenUp, max);
				lenDown = 1;
			}else if(prev > num) { // 감소
				lenDown++;
				max = Math.max(lenDown, max);
				lenUp = 1;
			}else { // 같음
				lenUp++;
				lenDown++;
				max = Math.max(lenUp, max);
				max = Math.max(lenDown, max);
			}
			prev = num;
		}
		// 1개 처리
		max = Math.max(lenUp, max);
		max = Math.max(lenDown, max);
		
		System.out.println(max);
	}
}
