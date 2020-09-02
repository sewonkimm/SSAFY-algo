/*
 * BJ 1342 행운의 문자열 => 실패(시간 초과)
 * 주어진 문자열을 순열 알고리즘(Next Permutation)을 이용해 새로운 문자열을 생성하고
 * 처음부터 끝까지 반복하면서 행운의 문자열인지 확인한다.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ_1342_LuckyString {

	static int sLen, answer; // 입력받은 문자열의 길이, 정답수
	static String s; // 입력받은 문자열
	static int[] p; // 순열에서 사용할 순서 배열
	static List<String> arr = new ArrayList<String>(); // 문자열을 비교하기 위해 생성

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		String st;
		s = sc.nextLine();
		sLen = s.length();
		// 순열에 사용할 순서 배열 생성
		p = new int[sLen];
		for (int i = 0; i < sLen; i++) {
			p[i] = i;
		}
		// Next Permutation 시작
		do {
			st = ""; // 문자열이 같은 경우를 비교해 제거하기 위함
			boolean check = true;
			// 순열로 구성한 순서에 따라 문자열 구성
			for (int i = 0; i < sLen; i++) {
				st += s.charAt(p[i]);
			}
			// 이미 비교를 끝낸 문자열은 더 이상 비교하지 않기 위해!
			for (int i = 0; i < arr.size(); i++) {
				if(st.equals(arr.get(i))){
					check = false;
					break;
				}
			}
			// 각 문자열의 바로 옆을 확인
			if(check) {
				for (int i = 0; i < sLen-1; i++) {
					if(st.charAt(i) == st.charAt(i+1)) {
						check = false;
						break;
					}
				}
				
				if(check) {
					answer++;
					arr.add(st);
				}
			}
		} while (np(p));
		System.out.println(answer);
		sc.close();
	}
	// Next Permutation
	private static boolean np(int[] input) {
		int i = sLen-1;
		while(i>0 && input[i-1]>=input[i]) i--;
		
		if(i == 0) return false;
		
		int j = sLen-1;
		while(input[i-1]>=input[j]) j--;
		swap(input,i-1,j);
		
		int k = sLen-1;
		while(i<k) swap(input,i++,k--);

		return true;
	}
	// 위치를 바꿔주는 함수
	private static void swap(int numbers[],int i,int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
