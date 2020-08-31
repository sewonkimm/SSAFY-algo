package sliver;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class bj_10866_덱 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Deque<Integer> dq = new LinkedList<Integer>();
		int number =0;
		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			String word = sc.next();
			
			if(word.contains("push_back")) {
				number= sc.nextInt();
				dq.addLast(number);
			}else if(word.contains("push_front")) {
				number= sc.nextInt();
				dq.addFirst(number);
			}else if(word.contains("pop_front")) {
				System.out.println(dq.isEmpty()?-1:dq.pollFirst());
			}else if(word.contains("pop_back")) {
				System.out.println(dq.isEmpty()?-1:dq.pollLast());
			}else if(word.contains("size")) {
				System.out.println(dq.size());
			}else if(word.contains("empty")) {
				System.out.println(dq.isEmpty()?1:0);
			}else if(word.contains("front")) {
				System.out.println(dq.isEmpty()?-1:dq.peekFirst());
			}else if(word.contains("back")) {
				System.out.println(dq.isEmpty()?-1:dq.peekLast());
			}
		}
		
	}
}
