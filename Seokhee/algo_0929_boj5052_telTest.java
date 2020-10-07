import java.io.*;
import java.util.*;
public class algo_0929_boj5052_telTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//백준 5052 전화번호 목록
		//길이 순서대로 정렬을 하고 싶은데.. 정렬하는데 시간이 걸리고 비교하는데 시간이 걸림
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder(""); //시간 단축을 위한 sb
		
		for(int t=0;t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			
			String[] arr = new String[n];
			
			for(int i=0;i<n;i++) {
				arr[i] = br.readLine();
			}
			
			Arrays.sort(arr); //정렬 조건을 comparator로 따로 주지 않아도 (알파벳순 +길이순)정렬이 포함되어있음
			
			for(int i=0;i<n;i++) {
				System.out.println(arr[i]);
			}
			
			int flag = 0;

			for(int i=0;i<n-1;i++) {
				//전이랑만 비교해주면됨, 알파벳 순이기때문에 바로 직전보다 더 전이랑 같다면 이미 앞에서 같다고 나올 것이다 그래서 앞뒤만
				//12 163 1255를 넣으면 12 1255 163으로 정렬이 됨, 알파벳이 우선
				//그렇기 때문에 1255이전의 12와 163이 중복이 된다고 가정하면 163 이전의 1255에서 이미 같을 것이라는것이다
				if(arr[i+1].startsWith(arr[i])) { //substring을 사용하니까 시간초과가 남, startswith를 사용하자
					flag = 1;
					sb.append("NO\n");
					break;
				}
			}
			
			if(flag == 0)
				sb.append("YES\n");
		}
		System.out.println(sb);
	}
}
