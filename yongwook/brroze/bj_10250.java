package brroze;

import java.util.Scanner;

public class bj_10250 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		int H,W,N=0;
		int result = 0;
		for (int i = 0; i < tc; i++) {
			H= sc.nextInt();
			W = sc.nextInt();
			N = sc.nextInt();
			
			if(H ==1)
			result = 100+N;
			else if(N%H==0)
			result = H*100+N/H;
			else
			result =  (N%H)*100 + (N/H)+1;
			System.out.println(result);
		}
	}
}
