package sliver;

import java.util.Scanner;
import java.util.Stack;

public class bj_9012_괄호_스택 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		Stack<Character> stack= new Stack<Character>();
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			
			stack.clear();
			String input = sc.next();
			char arr[] = input.toCharArray();
			
			for (int j = 0; j < arr.length; j++) {
				if(!stack.isEmpty() && stack.peek() == '('  && arr[j] == ')') {
					stack.pop();
				}else {
					stack.push(arr[j]);
				}
					
				
			}
			if(stack.isEmpty())
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
