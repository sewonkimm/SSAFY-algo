import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {

	public static void main(String[] args) throws Exception {
    //System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int TC=1; TC<=T; TC++){
			int maxValue = 0;
			
			// input
			int[] in = new int[10];
			for(int i=0; i<10; i++){
				in[i] = sc.nextInt();
			}
			
			// 완전탐색
			for(int i=0; i<10; i++){
				maxValue = Math.max(maxValue, in[i]);
			}
			System.out.println("#"+TC+" "+maxValue);
		}
		sc.close();
	}
}
