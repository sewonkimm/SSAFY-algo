package sliver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class bj_1181_단어정렬 {
	public static void main(String[] args)  {
		
		ArrayList<String> list = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		
		int number= sc.nextInt();
		String word = null;
		for (int i = 0; i < number; i++) {
			word = sc.next();
			if(!list.contains(word)) {
				list.add(word);
			}
		}
		//길이로 정렬
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				if(o1.length()> o2.length()) {
					return 1;
				}else if(o1.length()== o2.length()){
					return o1.compareTo(o2); 
				}
				return-1;
			}

		
		});
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
}
