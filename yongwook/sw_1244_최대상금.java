package practice;

import java.util.Scanner;

public class sw_1244_�ִ��� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int i = 0; i < tc; i++) {
			
			String input = sc.next();
			char money[] = new char[input.length()];
			for (int j = 0; j < input.length(); j++) {
				 money[j] = (char) input.charAt(j);
			}
			int chage = sc.nextInt();
			char max = 0;
			////////////////////////////////////////////////
		
			for (int j = 0; j < money.length; j++) { //�ִ밪 ���ϱ�
				if( max <money[j]) max = money[j];					
			}
			for(int j = money.length-1; j>0 ; j--) {
				if(money[j]==max) {
					money[j]= money[0];
					break;
				}
			}
			money[0] =  max ;
			
			
			
			System.out.print("#"+(i+1)+" ");
			for (int j = 0; j < money.length; j++) {
				System.out.print(money[j]);
			}
			System.out.println();
		}
	}
}
