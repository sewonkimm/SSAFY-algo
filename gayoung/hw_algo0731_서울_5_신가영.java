package com.ssafy;

import java.util.Scanner;
import java.util.Stack;

public class Calculator_1223 {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    Stack<Character> stack = new Stack<Character>(); // �ǿ�����
	    Stack<Character> temp = new Stack<Character>(); // ������
	    Stack<Character> temp2 = new Stack<Character>(); // �ݴ��
	    
	    for (int tc = 1; tc <= 10; tc++) {
		    int T = sc.nextInt();
		    char[] number = sc.next().toCharArray(); // �ϳ��ϳ� ���� �ޱ�
		    
		    for (int i = 0; i < T; i++) {
				if (number[i]>48 && number[i]<58) { // 0~9
					stack.push(number[i]); // stack�� ���� �־��ֱ�
				}else if(number[i]=='+'){ 
					while(!temp.isEmpty() && temp.peek()=='*') {
						stack.push(temp.pop()); // temp�� ��� *�� ���� ��
						// temp���� ���� stack�� �־���
					}
					temp.push(number[i]); // + ���� �ٸ� �� ���� �� �ٷ� temp�� �־���
				}else {
					temp.push(number[i]); // *�� �ٷ� temp�� �־���
				}
			}
		    while(!temp.isEmpty()) { // temp�� ����������� ��
		    	stack.push(temp.pop()); // temp����  stack���� �ֱ�
		    }
		    
		    // �ݴ�� �����ֱ�
		    while(!stack.isEmpty()) { // stack�� �ڿ��� ���� ���ϱ� �ݴ�� �����ֱ�
		    	temp2.push(stack.pop()); // temp2 ������ Ǫ��
		    }	    
		    
		    Stack<Integer> stack2 = new Stack<Integer>(); //���ο� ���� ����
		    for (int i = 0; i < T; i++) {
				if (temp2.peek()>48 && temp2.peek()<58) { // ���� �ٽ� stack�� �־��ֱ�
					stack2.push(temp2.pop()-'0');
				}
				else if(temp2.peek()=='*') {  // temp2�� �ִ� * ���ö�
					int a = stack2.pop();
					int b = stack2.pop();
					temp2.pop();
					stack2.push(a*b); // ���� �������ֱ�
				}
				else if(temp2.peek()=='+') { // temp2�� �ִ� + ���� ��
					int a = stack2.pop();
					int b = stack2.pop();
					temp2.pop();
					stack2.push(a+b); // ���� �������ֱ�
				}
			}
		    System.out.println("#"+tc+" "+stack2.pop()); // ���
		  
		}			
	}
}