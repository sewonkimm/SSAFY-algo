/*
Scanner로 입력받았는데 시간초과...
그래서 BufferedReader로 바꿨는데도 시간초과...
Priority Queue 쓰면 안되는 건가요...?
 */

package com.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ11279_최대힙 {

	static PriorityQueue<Integer> reversedPQ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x == 0) {
				if(pq.isEmpty())	System.out.println(0);
				else { 
					System.out.println(reversedPQ.poll());
					pq.poll();
				}
			}
			else {
				pq.offer(x);
				reversedPQ = new PriorityQueue<Integer>(pq.size(), Collections.reverseOrder());
				reversedPQ.addAll(pq);
			}
		}
	}

}
