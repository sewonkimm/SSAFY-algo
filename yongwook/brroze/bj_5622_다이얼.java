package brroze;

import java.util.Scanner;

public class bj_5622_다이얼 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String N = sc.next();
		
		char arr[] = N.toCharArray();
		
		int sum =0;
		for (int i = 0; i < arr.length; i++) {
			
			if(arr[i] == 'A'||arr[i] == 'B'||arr[i] == 'C') {
				sum = sum +2;
			}
			else if(arr[i] == 'D'||arr[i] == 'E'||arr[i] == 'F') {
				sum = sum +3;
			}
			else if(arr[i] == 'G'||arr[i] == 'H'||arr[i] == 'I') {
				sum = sum +4;
			}
			else if(arr[i] == 'J'||arr[i] == 'K'||arr[i] == 'L') {
				sum = sum +5;
			}
			else if(arr[i] == 'M'||arr[i] == 'N'||arr[i] == 'O') {
				sum = sum +6;
			}
			else if(arr[i] == 'P'||arr[i] == 'Q'||arr[i] == 'R'||arr[i] == 'S') {
				sum = sum +7;
			}
			else if(arr[i] == 'T'||arr[i] == 'U'||arr[i] == 'V') {
				sum = sum +8;
			}
			else if(arr[i] == 'W'||arr[i] == 'X'||arr[i] == 'Y'||arr[i] == 'Z') {
				sum = sum +9;
			}
				
		}
		System.out.println(sum+arr.length);
	}
}
