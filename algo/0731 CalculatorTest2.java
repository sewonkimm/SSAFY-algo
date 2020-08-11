package com.ssafy;
import java.util.Scanner;
import java.util.Stack;

public class CalculatorTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			int n = sc.nextInt();
			String ex = sc.next();
			Stack<Character> stack = new Stack<Character>();
			char[] exChar = new char[n]; 
			char[] exChar2 = new char[n];
			int num = 0;
			for(int i=0;i<n;i++) {
				exChar[i] = ex.charAt(i);
			}
			for(int i=0;i<n;i++) {
				if(exChar[i]>='0' && exChar[i]<='9') {
					//System.out.print(exChar[i]+" " );
					exChar2[num] = exChar[i];
					num++;
				}
				else {
					while(!stack.isEmpty()) {
						if( (stack.peek() == '-' || stack.peek() == '+') 
							&& (exChar[i] == '*' || exChar[i] == '/')) {
							stack.push(exChar[i]);
							break;
						}
						else {
							//System.out.print(stack.peek()+" ");
							exChar2[num] = stack.peek();
							num++;
							stack.pop();
						}
					}
					if(stack.isEmpty()) {
						stack.push(exChar[i]);
					}			
				}
				if(i==n-1) {
					while(!stack.isEmpty()) {
						//System.out.print(stack.peek()+" ");
						exChar2[num] = stack.peek();
						num++;
						stack.pop();
					}
				}
			}
			Stack<Integer> s = new Stack<Integer>();
			char ch;
			for(int i=0;i<n;i++) {
				ch = exChar2[i];
				int a,b;
				
				if(exChar2[i]>='0' && exChar2[i]<='9') {
					s.push(ch-'0');
				}
				else {
					b = s.pop();
					a = s.pop();
					
					switch(ch) {
					case '+': s.push(a+b); break;
					case '-': s.push(a-b); break;
					case '*': s.push(a*b); break;
					case '/': s.push(a/b); break;
					}
				}
			}
			System.out.println("#"+t+" "+s.pop());
		}
	}

}
