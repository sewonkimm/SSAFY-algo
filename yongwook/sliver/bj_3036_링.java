package sliver;

import java.util.Arrays;
import java.util.Scanner;

public class bj_3036_링 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		int arr[]= new int[tc];
		int a[] = new int[tc] ; //최대 공약수 ;
		int big = 0;
		int small = 0;
		int temp =0;
		for (int i = 0; i < tc; i++) {
			arr[i]= sc.nextInt();
		}

		for (int i = 1; i < arr.length; i++) {

			big = Math.max(arr[0], arr[i]);
			small = Math.min(arr[0], arr[i]);
			//유클리드 호제법
			while( true) {			
				temp = big%small ;				 
				big = small;
				small =temp;
				
				if(temp==0) {
					break;
				}
			}
			a[i]= big;
		}
	//	System.out.println(Arrays.toString(a));
		for (int i = 1; i < tc; i++) {
			System.out.println(arr[0]/a[i] + "/"+arr[i]/a[i]);
		}
	}
}
