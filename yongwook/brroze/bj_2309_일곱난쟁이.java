package brroze;

import java.util.Arrays;
import java.util.Scanner;

public class bj_2309_일곱난쟁이 {
	
	static int[] heights,ans;
	private static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		heights = new int[9];// 난쟁이들의 키
		isSelected = new boolean[9];// 부분집합에 포함여부 저장
		ans = new int[7];// 최종 선택된 7 난쟁의 키 저장.
		
		for (int i = 0; i < 9; i++) {
			heights[i]=sc.nextInt();
		}
		
		
		find(0,0,0); // 첫번째난쟁이부터시작하고 , 선택수, 총합
		//선택된 일곱난쟁이를 찾아서 ans배열에 담자
		for (int i = 0,j=0; i < 9; i++) {
			if(isSelected[i]) {
				
				ans[j++] = heights[i];
			}
		}
		Arrays.sort(ans);
		for (int i = 0; i < 7; i++) {
			System.out.println(ans[i]);
		}
		comb(0,0,0);
		
		Arrays.sort(ans);
		for (int i = 0; i < 7; i++) {
			System.out.println(ans[i]);
		}
	}
	// 부분집합코드
	public static boolean find(int index, int cnt, int sum) { 
		
		if(cnt==7 && sum==100) {
			//답
			return true;
		}
		if(cnt == 7 || index == 9 || sum>100) {
			return false;
		}
		
		//선택
		isSelected[index] = true;
		
		if(find(index+1,cnt+1,sum+heights[index])) return true;// 선택한 상황을 반영하여 다음으로 넘어감.
		//비선택
		isSelected[index] = false;
		return find(index+1,cnt,sum);
		
		
	}
	
	
	public static boolean comb(int start,int cnt,int sum) { //난쟁이스타트포인트 //뽑힌조합의 원소수
		if(cnt==7 && sum ==100) {
			return true;
		}
		if(cnt == 7 || sum>100)return false;
		
		for (int i = start; i < 9; i++) {
			ans[cnt] = heights[i]; // 조합 대상 선택
			if(comb(i+1,cnt+1,sum+heights[i])) return true;
		}
		return false;
	}
		
}
