import java.io.*;
import java.util.*;

public class p1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//IM 대비 1번 일곱난쟁이, 9명의 난쟁이 중 합이 100이 되는 일곱난쟁이를 찾자
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] n = new int[9];
		int sum = 0;
		for(int i=0;i<9;i++) {
			n[i] = Integer.parseInt(br.readLine());
			sum+=n[i];
		}
		Arrays.sort(n);
		
		for(int i=0;i<8;i++) { //0~8 중에 고르기
			for(int j=i+1;j<9;j++) { //i+1부터 9까지 고르기
				if(sum-n[i]-n[j] == 100) { //100이면 그상태로 출력
					for(int k=0;k<9;k++) {
						if(k!=i && k!=j)	
							System.out.println(n[k]);
					}
					return;
				}
			}
		}
		
	}

}
