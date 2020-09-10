/*
 * BJ 1759 암호 만들기 => 실패(시간 초과)
 * => NextPertation으로 nPr을 하는 방법을 알아야 할 수 있을 듯
 * 순환으로 가능한 경우를 만들고
 * 조건을 완전 탐색으로 확인해본다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_1759_MakingCode {

	static int L, C; // 주어지는 두 정수
	static char[] input, tgtArray;
	static boolean[] isUsed;
	static ArrayList<String> list = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		input = new char[C];
		tgtArray = new char[L];
		isUsed = new boolean[C];
		
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < C; i++) {
			input[i] = st.nextToken().charAt(0);
		}
		perm(0);
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	private static void	perm(int idx) {
		if (idx == L) {
			// 문자열 확인
			if (check(tgtArray)) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < L; i++) {
					sb.append(tgtArray[i]);
				}
				list.add(sb.toString());
			}
			return;
		}

		for (int i = 0; i < C; i++) {
			if(!isUsed[i]) {
				tgtArray[idx] = input[i];
				isUsed[i] = true;
				perm(idx+1);
				isUsed[i] = false;
			}
		}
	}

	private static boolean check(char[] arr) {
		int consonant = 0; // 자음 수
		int vowel = 0; // 모음 수

		// 순서대로 되어 있는지 확인 + 자음수와 모음수 체크
		for (int i = 0; i < L - 1; i++) {
			if (arr[i] > arr[i + 1]) return false;
			if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') vowel++;
			else consonant++;
		}
		// 마지막 단어까지 확인
		if (arr[L - 1] == 'a' || arr[L - 1] == 'e' || arr[L - 1] == 'i' || arr[L - 1] == 'o' || arr[L - 1] == 'u') vowel++;
		else consonant++;
		// 자음수 또는 모음수가 최소 개수를 넘지 못하는지 확인
		if (consonant < 2 || vowel < 1)
			return false;
		return true;
	}

}
