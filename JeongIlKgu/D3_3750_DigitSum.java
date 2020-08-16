/*
 * D3 3750 Digit Sum
 * 10으로 나눈 몫과 나머지를 활용
 * 이때, 나머지들을 더한 결과값이 1의 자리수이면 출력!
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D3_3750_DigitSum {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for (int t = 1; t <= T; t++) {
			int result = 0; // 10으로 나눈 나머지 값을 더할 결과 변수
			 // 입력이 10의 18승까지 가능하기 때문에 Long타입으로 선언 
			long num = Long.parseLong(in.readLine());
			while(true) {
				while(num > 0) {
					result += (num%10); // 10으로 나눈 나머지를 더한다.
					num /= 10; // 10으로 나눈 몫을 저장
				}
				// 더한 최종 값을 10으로 나눴을 때, 0이 나오면 출력
				if(result/10 == 0) {
					System.out.println("#" + t + " " + result);
					break;
				}else {
					num = result;
					result = 0;
				}
			}
		}
	}

}
