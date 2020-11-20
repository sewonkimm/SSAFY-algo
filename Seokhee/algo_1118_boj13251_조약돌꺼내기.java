import java.util.*;
import java.io.*;

public class algo_1118_boj13251_조약돌꺼내기 {
	static int m;
	static int totalStone;
	static int[] stone;
	static double[] pick;
	static int k;
	static double ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		stone = new int[m];
		pick = new double[m];
		for(int i=0;i<m;i++) {
			stone[i] = sc.nextInt();
			totalStone += stone[i];
		}
		k = sc.nextInt();
		
		stoneFunc();
		
		System.out.println((String.format("%.15f", ans)));
	}
	
	static void stoneFunc() {
		for(int i=0;i<m;i++) {
			if(stone[i] < k)
				continue;
			double tmp = 1.0;
			for(int j=0;j<k;j++) {
				tmp *= (double)(stone[i]-j)/(totalStone-j);
			}
			pick[i] = tmp;
		}
		ans = 0;
		for(int i=0;i<m;i++) {
			ans += pick[i];
		}
	}
}
