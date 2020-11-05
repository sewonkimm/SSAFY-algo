package sliver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

public class bj_11866_요세푸스 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Queue<Integer> queue = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int choice = sc.nextInt();
		int cnt = 1;
		
		for (int i = 0; i < N; i++) {
			queue.add(i+1);
			
		}
		int temp=0;
		sb.append("<");
		while(!queue.isEmpty()) {
			
			
			temp = queue.poll();
			if(cnt++%choice ==0) {
				sb.append(temp).append(", ");
			}else {
				queue.offer(temp);
			}
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);

	}
}
