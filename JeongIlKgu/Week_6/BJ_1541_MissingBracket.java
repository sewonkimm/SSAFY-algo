/*
 * BJ 1541 잃어버린 괄호
 * -가 나오면 그 뒤에 다른 -가 나오기 전까지 다 +한다.
 */

import java.util.Scanner;

public class BJ_1541_MissingBracket {

	static int answer; // 최소값
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		// -를 기준으로 나눈다.
		String[] arr = s.split("-");
		// 최초 -가 나오기 전까지 더한다. +는 이스케이프 처리
		answer += sum(arr[0].split("\\+"));
		// 남은 것들은 모두 빼준다.
		for (int i = 1; i < arr.length; i++) {
			answer -= sum(arr[i].split("\\+"));
		}
		System.out.println(answer);
		sc.close();
	}
	
	private static int sum(String[] arr) {
		int result = 0;
		for (String n : arr) {
			result += Integer.parseInt(n);
		}
		return result;
	}
}
