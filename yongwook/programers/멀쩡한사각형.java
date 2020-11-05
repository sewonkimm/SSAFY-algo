package programers;

import java.util.Scanner;

public class 멀쩡한사각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int  w= sc.nextInt();
		int h = sc.nextInt();

		long result = 0;

		if(w == h) {
			result = w*h - w;
		}else {
			if(w>h)
				result = w*h - uclid(w,h)*( (w/uclid(w,h)) +(h /uclid(w,h) )-1);
			else
				result = w*h - uclid(h,w)*( (w/uclid(h,w)) + (h/uclid(h,w))-1);
		}
		System.out.println(uclid(w,h));
		System.out.println(result);
	}

	public static  long uclid(int x , int y) {
		long result = 0;

		if(x%y == 0){
			result = y ;
		}else {
			result = uclid(y,x%y);
		}

		return result ;
	}
}
