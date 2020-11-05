package sliver;

import java.util.Scanner;

public class bj_1316_그룹단어체커 {
	public static void main(String[] args) {

		Scanner sc  = new Scanner(System.in);

		int N  = sc.nextInt();
		int result = 0;

		for (int i = 0; i < N; i++) {
			boolean check[] = new boolean[200];
			String input = sc.next();
			char arr[] = input.toCharArray();
			for (int j = 0; j < arr.length; j++) {

				while(j+1 < arr.length && arr[j] == arr[j+1]) {
					j++;
				}
				if(check[arr[j]] != true)
					check[arr[j]] = true;
				else if(check[arr[j]] == true){
					break;
				}

				if(j == arr.length-1) {
					result++;
				}
			}

		}	
		System.out.println(result);
	}
}
