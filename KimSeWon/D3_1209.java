import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int T=1; T<=10; T++){
			// input
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			for(int i=0; i<100; i++){
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<100; j++){
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int maxValue = 0;
			// 각 행 sum
			for(int i=0; i<100; i++){
				int sum=0;
				for(int j=0; j<100; j++){
					sum += arr[i][j];
				}
				maxValue = Math.max(maxValue, sum);
			}
			
			// 각 열 sum
			for(int i=0; i<100; i++){
				int sum=0;
				for(int j=0; j<100; j++){
					sum += arr[j][i];
				}
				maxValue = Math.max(maxValue, sum);
			}
			
			// 대각선 sum
			int sum1 =0;
			int sum2 =0;
			for(int i=0; i<100; i++){
				sum1 += arr[i][i];
				sum2 += arr[i][99-i];
			}
			maxValue = Math.max(maxValue, Math.max(sum1, sum2));
			
			
			System.out.println("#"+T+" "+maxValue);
		}
	}

}
