import java.util.*;
public class algo_0910_kakao01_compressStringTest {

	//카카오 코테 연습문제 1번
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] arr = new char[s.length()];
		arr = s.toCharArray();
		int min = Integer.MAX_VALUE;
		int flag=0;
		
		if(s.length() == 1) {
			System.out.println(1);
			return;
		}
		for(int i=1;i<=s.length()/2;i++) { //1개부터 n/2까지 자르기
			StringBuilder sb = new StringBuilder("");
			
			for(int j=0;j<s.length();j=j+i) { //시작점부터 자를 문자열 길이만큼의 기준이 되는 녀석
				int same=1;
				flag = 1;
				for(int a=j+i;a<s.length();a=a+i) { //비교대상의 시작점
					flag = 0;
					for(int k=j;k<j+i;k++) { //기준이 되는 애 처음부터 끝까지 돌기
						if(a+i>s.length()) { //잘랐을 때 마지막에 오버가 됐을 경우
							flag=1;
							break;
						}
						if(arr[k]!=arr[a+k-j]) { //같지않으면 flag 변경
							flag = 1;
							break;
						}
					}
					if(flag == 0) {
						same++;
						j=j+i;
					}
					else if(flag == 1) 
						break;
				}
				if(same == 1) {
					int leng;
					if(j+i>s.length()) //잘랐을 때 마지막에 오버가 됐을 경우
						leng = s.length();
					else leng = j+i;
					for(int b=j;b<leng;b++) { //일반적인경우
						sb.append(arr[b]);
					}
				}
				else if(same>1) {
					sb.append(same);
					for(int b=j;b<j+i;b++) { //일반적인경우
						sb.append(arr[b]);
					}
				}
			}
			min = Math.min(min,sb.toString().length());
		}
		
		System.out.println(min);
	}
}
