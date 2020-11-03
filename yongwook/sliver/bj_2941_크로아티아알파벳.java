package sliver;

import java.util.Scanner;

public class bj_2941_크로아티아알파벳 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		
		char arr[] = input.toCharArray();
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			
			
			if(i+1<arr.length && arr[i]=='c' && arr[i+1]== '=') {
				result++;
				i++;
			}
			else if(i+1<arr.length &&arr[i]=='c' && arr[i+1]== '-'){
				result++;
				i++;
			}
			else if(i+2< arr.length &&arr[i]=='d' && arr[i+1]== 'z'  && arr[i+2]== '='){
				result++;
				i= i+2;
			}
			else if(i+1<arr.length &&arr[i]=='d' && arr[i+1]== '-'){
				result++;
				i++;
			}
			else if(i+1<arr.length &&arr[i]=='l' && arr[i+1]== 'j'){
				result++;
				i++;
			}
			else if(i+1<arr.length &&arr[i]=='n' && arr[i+1]== 'j'){
				result++;
				i++;
			}
			else if(i+1<arr.length &&arr[i]=='s' && arr[i+1]== '='){
				result++;
				i++;
			}
			else if(i+1<arr.length &&arr[i]=='z' && arr[i+1]== '='){
				result++;
				i++;
			}
			else {
				result++;
			}
		}
		System.out.println(result);
	}
}
