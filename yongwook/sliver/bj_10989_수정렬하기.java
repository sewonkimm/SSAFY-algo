package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_10989_수정렬하기 {
	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
	//	ArrayList<Integer> arr = new ArrayList<Integer>();
		
		int tc = Integer.parseInt(br.readLine()); 
		
		int arr[] = new int[tc];
		for (int i = 0; i < tc; i++) {
				
			arr[i] = Integer.parseInt(br.readLine());
			//arr.add(Integer.parseInt(br.readLine()));
		}
		
		Arrays.sort(arr);
	//	Collections.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append('\n');
		}
		
		System.out.println(sb);
		
		
	}
}
