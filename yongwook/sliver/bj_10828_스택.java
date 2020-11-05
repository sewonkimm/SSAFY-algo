package sliver;

import java.util.Scanner;
import java.util.Stack;

public class bj_10828_스택 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> st = new Stack<>();
		int tc = sc.nextInt();
		int number = 0;
		for (int i = 0; i < tc; i++) {
			
			String word = sc.next();
			
			
			if(word.equals("push")) {
				 number = sc.nextInt();
				st.push(number);
			}else if(word.equals("top")) {
				System.out.println(st.isEmpty()?-1:st.peek());
			}else if(word.equals("size")) {
				System.out.println(st.size());
			}else if(word.equals("empty")) {
				System.out.println(st.isEmpty()?1:0);
			}else if(word.equals("pop")) {
				System.out.println(st.isEmpty()?-1:st.pop());
			}
		}
	}
}
