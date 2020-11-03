package brroze;

import java.util.Scanner;

public class bj_2605_줄세우기 {
	static int input[], student[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //학생수
		
		input = new int[N+1];
		student= new int[N+1];
		for (int i = 1; i <= N; i++) {
			input[i]= sc.nextInt();
			student[i] = i;
		}
		// 알고리즘
		
		for (int i = 1; i <= N; i++) {
			
			swap(i-input[i],i,input[i]);
			
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(student[i]);
			if( i != N)
			System.out.print(" ");
		}
		
	}
	public static void swap(int x, int y, int cnt) {  // 첫번쨰 학생 , 두번쨰학생 , 스왑횟수
		int cnt1= 0;
		int temp = 0;
		if(cnt==0) {
			return;
		}
		else if(cnt >=1) {
			temp = student[y]; 
			student[y] = student[x];
			student[x] = temp;
			cnt--;
			
			cnt1++;
			swap(x+cnt1,y,cnt);
		}
	}
}
