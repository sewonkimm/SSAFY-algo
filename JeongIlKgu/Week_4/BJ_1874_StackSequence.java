/*
 * BJ 1874 스택수열
 * Stack & 자료구조!
 * 오름차순으로 스택에 수를 넣으면서
 * 스택을 주어진 순열과 비교하면서 확인
 * cf) NO 철자 주의 할 것!
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BJ_1874_StackSequence {
	
	static int[] seq; // 순열 받을 배열
	static int index, N; // 순열의 인덱스 값, 총 갯수
	static Stack<Integer> st = new Stack<Integer>();
	static ArrayList<String> list = new ArrayList<String>(); // 결과값을 저장해둘 리스트

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		seq = new int[N];
		for (int i = 0; i < N; i++) {
			seq[i] = sc.nextInt();
		}
		// 확인
		for (int i = 1; i <= N; i++) {
			// 우선, 무조건 push하고 리스트에 +추가
			st.push(i);
			list.add("+");
			// 스택과 순열 비교
			while(!st.isEmpty()) {
				// 스택의 top과 순열의 현재 수가 동일하다면 
				// 리스트에 -추가, pop, 인덱스+1 한다.
				if (st.peek() == seq[index]) {
					list.add("-");
					st.pop();
					index++;
				}else break;
			}
		}
		// 결과 출력
		if(!st.isEmpty()) System.out.println("NO");
		else {
			for (int j = 0; j < list.size(); j++) {
				System.out.println(list.get(j));
			}
		}
		sc.close();
	}

}
