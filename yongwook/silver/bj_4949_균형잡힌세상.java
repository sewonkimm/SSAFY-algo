package sliver;

import java.util.Scanner;
import java.util.Stack;

public class bj_4949_균형잡힌세상 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<Character>();

		while(true) {
			stack.clear();
			String input = sc.nextLine();
			char arr[] = new char[input.length()];
			for (int i = 0; i < arr.length; i++) {
					arr[i] = input.charAt(i);
			}
			for (int i = 0; i < arr.length; i++) {
				if(!stack.isEmpty() && stack.peek()== '('  && arr[i] == ')')
					stack.pop();
				else if(!stack.isEmpty() && stack.peek()== '['  && arr[i] == ']')
					stack.pop();
				else if(arr[i] == '('|| arr[i] == ')'||arr[i] == '['||arr[i] == ']')
					stack.push(arr[i]);
			}
			if(arr[0] == '.') {
				return;
			}
			if(stack.isEmpty()) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}

		}
	}
}
