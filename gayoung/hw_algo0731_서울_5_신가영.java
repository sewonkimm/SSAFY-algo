package com.ssafy;

import java.util.Scanner;
import java.util.Stack;

public class Calculator_1223 {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    Stack<Character> stack = new Stack<Character>(); // 피연산자
	    Stack<Character> temp = new Stack<Character>(); // 연산자
	    Stack<Character> temp2 = new Stack<Character>(); // 반대로
	    
	    for (int tc = 1; tc <= 10; tc++) {
		    int T = sc.nextInt();
		    char[] number = sc.next().toCharArray(); // 하나하나 숫자 받기
		    
		    for (int i = 0; i < T; i++) {
				if (number[i]>48 && number[i]<58) { // 0~9
					stack.push(number[i]); // stack에 숫자 넣어주기
				}else if(number[i]=='+'){ 
					while(!temp.isEmpty() && temp.peek()=='*') {
						stack.push(temp.pop()); // temp가 비고 *가 없을 때
						// temp에서 빼서 stack에 넣어줌
					}
					temp.push(number[i]); // + 빼고 다른 거 없을 때 바로 temp에 넣어줌
				}else {
					temp.push(number[i]); // *는 바로 temp에 넣어줌
				}
			}
		    while(!temp.isEmpty()) { // temp가 비어있지않을 때
		    	stack.push(temp.pop()); // temp에서  stack으로 넣기
		    }
		    
		    // 반대로 돌려주기
		    while(!stack.isEmpty()) { // stack은 뒤에서 부터 빼니까 반대로 돌려주기
		    	temp2.push(stack.pop()); // temp2 쪽으로 푸시
		    }	    
		    
		    Stack<Integer> stack2 = new Stack<Integer>(); //새로운 스택 생성
		    for (int i = 0; i < T; i++) {
				if (temp2.peek()>48 && temp2.peek()<58) { // 숫자 다시 stack에 넣어주기
					stack2.push(temp2.pop()-'0');
				}
				else if(temp2.peek()=='*') {  // temp2에 있는 * 나올때
					int a = stack2.pop();
					int b = stack2.pop();
					temp2.pop();
					stack2.push(a*b); // 숫자 연산해주기
				}
				else if(temp2.peek()=='+') { // temp2에 있는 + 나올 때
					int a = stack2.pop();
					int b = stack2.pop();
					temp2.pop();
					stack2.push(a+b); // 숫자 연산해주기
				}
			}
		    System.out.println("#"+tc+" "+stack2.pop()); // 출력
		  
		}			
	}
}