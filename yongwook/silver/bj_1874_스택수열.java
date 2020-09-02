//package sliver;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//import java.util.Stack;
//
//public class bj_1874 {
//	public static void main(String[] args) {
//
//		Scanner sc = new Scanner(System.in);
//
//		int N = sc.nextInt();
//		int arr[] = new int [N];
//		int num = 0;
//		Stack<Integer> stack = new Stack<Integer>();
//		StringBuilder sb = new StringBuilder();
//		Queue<Character> queue = new LinkedList<Character>();
//		// 배열입력
//		for (int i = 0; i < N; i++) {
//
//			arr[i] = sc.nextInt();
//		}
//
//		// 스택입력
//		for (int i = 1; i <=N; i++) {
//
//			stack.add(i);
//			queue.add('+');
//			while(num <N &&  stack.isEmpty()==false &&arr[num] == stack.peek()) {
//
//				stack.pop();
//				queue.add('-');
//				//System.out.println("-");
//				num++;
//			}
//		}
//		if(stack.isEmpty() == false) {
//			System.out.println("NO");
//		}
//	
//
//		if(stack.isEmpty()== true) {
//			int a = queue.size();
//			for (int i = 0; i < a; i++) {
//				System.out.println(queue.poll());
//			}
//		}
//
//	}
//}
package sliver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class bj_1874_스택수열 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int arr[] = new int [N];
		int num = 0;
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		// 배열입력
		for (int i = 0; i < N; i++) {

			arr[i] = sc.nextInt();
		}

		// 스택입력
		for (int i = 1; i <=N; i++) {

			stack.add(i);
			sb.append("+\n");
			while(num <N &&  stack.isEmpty()==false &&arr[num] == stack.peek()) {

				stack.pop();
				sb.append("-\n");
				num++;
			}
		}
		if(stack.isEmpty() == false) {
			System.out.println("NO");
		}else
			System.out.println(sb.toString());
	

	

	}
}

