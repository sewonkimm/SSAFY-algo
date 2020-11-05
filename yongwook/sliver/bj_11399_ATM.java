package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_11399_ATM {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;

		int tc = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int temp = 0;
		int sum = 0;
		int arr[]= new int[tc];
		for (int i = 0; i < tc; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for (int j = 0; j < tc; j++) {
			if(j>=1)
				temp += arr[j-1];
			sum += arr[j]+temp;
		}
		System.out.println(sum);
	}
}
