package sliver;

import java.io.IOException;
import java.util.Scanner;

public class bj_1541_잃어버린괄호 {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		int min =0;
		String arr[] = input.split("-"); //마이너스 기준으로 나누어줌
		
		String arr1[] = arr[0].split("\\+"); // 0번쨰는 무조건 양수가 오니까 플러스가올경우 일단 다분리함 
			for(String x : arr1) {
				min += Integer.parseInt(x) ;//그리고나서다합쳐줌
			}
		// 그리고나서 뒤에꺼 -나오는순간 싹다뻄 
			
		for (int i = 1; i < arr.length; i++) {
			
			// -로 나눈것중에서 플러스 올수도있으니 그걸 배열에 다넣어줌 
			arr1= arr[i].split("\\+");
			
			for (String x : arr1) {
				min -= Integer.parseInt(x);
			}
		}
		System.out.println(min);
		
	}
}
