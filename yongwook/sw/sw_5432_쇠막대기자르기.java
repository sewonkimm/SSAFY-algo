package sw;

import java.util.Scanner;

public class sw_5432_쇠막대기자르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		int result = 0;
		int bar =0;
		for (int i = 0; i < tc; i++) {
			result = 0;
			String input = sc.next();
			char arr[] = input.toCharArray();
			
			for (int j = 0; j < arr.length; j++) {
				if(arr[j]=='(' && arr[j+1] == ')') {
					result += bar;
				}else if(arr[j] == '(') {
					bar++;
				}else if(arr[j]== ')' && arr[j-1] != '(') {
					result+= 1;
					bar--;
				}
			}
			System.out.println("#"+(i+1)+" "+result);
		}
		
	}
}
