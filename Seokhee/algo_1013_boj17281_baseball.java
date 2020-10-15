import java.util.*;
import java.io.*;

public class algo_1013_boj17281_baseball {

	//백준 17821 야구
	//nextPermutation을 돌려서 가장 큰 점수가 나는 경우를 볼까?
	static int N,R;
	static int[] input;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //2~50
		int[][] map = new int[n][9];
		
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//안타 1, 2루타 2, 3루타 3, 홈런 4, 아웃 0
		
		//9! 의 경우의 수로 돌린다
		N = 9;  //숫자종류
		input = new int[N];
		
		for (int i = 0; i < 9; i++) {
			input[i] = i; //숫자 종류별 투입 0~8
		}
		
		do { //경기
			if(input[3] == 0) {
				int countNow = 0; //낸 점수
				int num = 0;
				
				for(int i=0;i<n;i++) { //이닝
					int outCount = 0;
					int[] base = {0, 0, 0};
					
					while(outCount <3) {
						num = num%9;
						if(map[i][input[num]] == 0) //아웃카운트 세기
							outCount++;
						else {
							int len = map[i][input[num]];
							for(int j=0;j<len;j++) { //친거 만큼 진루 시키자
								countNow += base[2];
								base[2] = base[1];
								base[1] = base[0];
								if(j==0) base[0]=1; 
								else base[0]=0;
							}
						}
						num++; //num은 초기화 없이 계속간다
					}
				}
				if(countNow > max) 
					max = countNow;
			}
			
		}while(nextPermutation(input));
		
		System.out.println(max);
	}
	
	private static boolean nextPermutation(int[] numbers) {
		int i = N-1;
		while(i>0 && numbers[i-1] >= numbers[i]) i--;
		if(i==0) return false; //마지막 순열의 상태이면 다음 순열은 없다
		
		int j =N-1;
		while(numbers[i-1]>=numbers[j]) j--; //무조건 있음
		
		swap(numbers,i-1,j);
		
		int k = N-1;
		while(i<k) {
			swap(numbers,i++,k--);
		}
		return true;
	}
	public static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
