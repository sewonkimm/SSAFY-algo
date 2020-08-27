package brroze;

import java.util.HashSet;
import java.util.Scanner;

public class bj_3052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		int b[] = new int[42];
//		int a = 0;
//		int result = 0;
//		for (int i = 0; i < 10; i++) {
//			a = sc.nextInt()%42;
//			b[a]= 1;
//		}
//		
//		for (int i = 0; i < b.length; i++) {
//			if(b[i] ==1)
//				result++;
//		}
//		System.out.println(result);
//		
		
		HashSet<Integer> h =new  HashSet<Integer>();
		
		for (int i = 0; i < 10; i++) {
			h.add(sc.nextInt() %42);
		}
		
		System.out.println(h.size());
		
	}
}
