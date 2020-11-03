package gold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class bj_1715_카드정렬하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < t; i++) {

			list.add(sc.nextInt());
		}
		
		Collections.sort(list);
		
		list.get(0)+list.get(1);
		
		
	}
}
