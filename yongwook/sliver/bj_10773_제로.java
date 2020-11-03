package sliver;

import java.util.Scanner;
import java.util.Stack;

public class bj_10773_제로 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		
		int tc = sc.nextInt();
		
		for (int i = 0; i < tc; i++) {
			int temp = sc.nextInt();
			if(temp== 0 ) {
				stack.pop();
			}else 
			stack.push(temp);
		}
		if(stack.isEmpty())
		System.out.println(0);
		else {
			int sum=0;
			while (!stack.isEmpty()) {
				 sum += stack.pop();
			}
			System.out.println(sum);
			
		}
	}
}
