import java.io.*;
import java.util.*;
public class algo_0906_boj2217_ropeTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		n = Integer.parseInt(br.readLine());
		int[] rope = new int[n];
		for(int i=0;i<n;i++) {
			rope[i] = Integer.parseInt(br.readLine());

		}
		
		Arrays.sort(rope); //오름차순 소팅
		int max = 0;
		
		//sort의 역순으로 시작 (내림차순으로 탐색)
		//제일 강한 로프를 써서 그 로프 무게만큼을 1개의 로프로 드는 것, 
		//그다음 강한 로프를 쓸 때, 그 두번째 로프 무게만큼을 2개의 로프로 드는 것 
		//=> 들수있는 무게 로프개수 * 해당 번째의 로프의 강함
		
		//(2개의 로프를 쓸 때, 가장 강한 1번째의 로프는 2번째의 로프무게만큼 당연히 들기때문에 확인 안해도 된다)
		//이것을 로프의 개수만큼 반복해서
		//n개의 로프로 n번째로 강한 로프의 버티는 무게만큼 나눠서 버틴다고 생각할 때,
		//(내림차순 시)n번째 로프의 무게 * n이 그 상태에서 들 수 있는 최대 무게이다, 이후 최대값과 비교시작
		for(int i=n-1,j=0;i>=0;i--,j++) {
			if(max<rope[i]*(j+1))
				max = rope[i]*(j+1);
		}
		System.out.println(max);
	}

}
