package com.ssafy;
import java.util.*;
public class zTest {
	
	static int n;
	static int r;
	static int c;
	static int size1;
	static int size2;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		size1 = (int)Math.pow(2, n); //배열 사이즈 //4
		
		recursive(r,c,size1);
	}
	
	static void recursive(int x,int y,int size1) {
		
		if(size1 ==2) {
			cnt = cnt+x*2+y;
			System.out.println(cnt);
			return;
		}
		
		int wide = size1/2;
		int sum = (size1/2)*(size1/2);
		
		if(x<wide && y<wide) {
			cnt+=0;
			recursive(x,y,wide);
		}
		else if(x<wide && y<2*wide) {
			cnt+=sum;
			recursive(x,y-wide,wide);
		}
		else if(x<2*wide && y<wide) {
			cnt+=2*sum;
			recursive(x-wide,y,wide);
		}
		else if(x<2*wide && y<2*wide) {
			cnt+=3*sum;
			recursive(x-wide,y-wide,wide);
		}
	}
}
