package sliver;

import java.util.Scanner;

public class bj_1475_방번호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int visit[] = new int[10];
		
		int N = sc.nextInt();
		int max= 0;
		int temp=0;
		if(N==0) {
			System.out.println(1);
			return;
		}
		while(N>0) {
			
			visit[N%10]++;
			N /=10;
			
		}
		for (int i = 0; i < 10; i++) {
			if(i==6 || i==9)
				continue;
			else if(max<visit[i])
				max = visit[i];
		}
		temp = (visit[6]+visit[9]);
		if(temp%2==0)
			temp/=2;
		else
			temp=(temp/2)+1;
		
		if(max<temp) {
			System.out.println(temp);
		}else
			System.out.println(max);
	}
}
