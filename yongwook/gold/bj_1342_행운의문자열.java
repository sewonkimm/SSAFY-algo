package gold;

import java.util.Arrays;
import java.util.Scanner;

public class bj_1342_행운의문자열 {
	static String word;
	static char words[];
	static char arr[];
	static int result;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		 word = sc.next();
		 words = new char[word.length()];
		 for (int i = 0; i < word.length(); i++) {
			words[i] = word.charAt(i);
		}
		 Arrays.sort(words);
		
		permutation(1,3);
		
	}
	
	public static void permutation(int i , int start) {
		
		System.out.println(Arrays.toString(arr));
		
		for (int j = 0; j < arr.length; j++) {
			
		}
		
	}
}
