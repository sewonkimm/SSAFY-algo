import java.io.*;
import java.util.*;

public class algo_0928_boj11399_ATMTest {

	//백준 11399 ATM
	//정렬해서 누적합을 구하자, 그 누적합을 다 더하자
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] acc = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0;i<n;i++) { //처음 배열 초기화
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr); //정렬, 오름차순
		
		acc[0] = arr[0]; //누적을 구하기 위한 초기조건
		
		for(int i=1;i<n;i++) { //누적합을 구함
			acc[i] = acc[i-1]+arr[i];
		}
		
		int sum = 0;
		
		for(int i=0;i<n;i++) {
			sum += acc[i]; //누적합들을 더해준다
		}
		
		System.out.println(sum);
	}

}
