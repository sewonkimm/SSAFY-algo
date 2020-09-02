import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
public class luckyStringTest2 {

	//<스터디과제>
	
	//백준 1342번 행운의문자열
	//원소에 같은게 들어있는 조합은 짜본적이 없어서 조금 고민
	//조합 초반부터 행운이 아닐경우 아예 멈춰서 시간복잡도를 줄이자
	//모든 경우를 set에 넣어서 set size를 구해도 좋을듯?
	
	//위의 방법을 사용하니까 8개 이상의 문자열에서 최악의 경우를 넣어보면 1초이상 소요.
	//nextPermutation의 필요성을 느낌
	static int[] ch;
	static String s;
	static int totalCount;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		s = sc.next();
		ch = new int[s.length()];
		for(int i=0;i<s.length();i++) {
			ch[i] = s.charAt(i);
		} //세팅
		N = s.length();
		Arrays.sort(ch);
		
		do { //최초는 사전순 제일 앞
			if(checkLucky(ch)) //nextPermutation 사용 후, 행운의 문자열이 맞는가 체크!
				totalCount++;
		}while(nextPermutation(ch));
		
		System.out.println(totalCount);
	}
	public static boolean checkLucky(int[] s) { //행운의 문자열 체크
		for(int i=0;i<s.length-1;i++){ //돌면서 붙어있는 문자가 같은지 확인, 같으면 false
			if(s[i] == s[i+1])
				return false;
		}
		return true;
	}
	private static boolean nextPermutation(int[] numbers) {
		//step1. 꼭대기 찾기
		int i = N-1;
		while(i>0 && numbers[i-1] >= numbers[i]) i--;
		if(i==0) return false; //마지막 순열의 상태이면 다음 순열은 없다
		
		//step2. i-1위치와 교환할 다음단계 큰 수 뒷쪽에서 찾기
		int j =N-1;
		while(numbers[i-1]>=numbers[j]) j--; //무조건 있음
		
		//step3. i-1 위치값과 j 위치값 교환
		swap(numbers,i-1,j);
		
		//step4. i위치부터 맨 뒤까지 오름차순 정렬
		int k = N-1;
		while(i<k) {
			swap(numbers,i++,k--);
		}
		return true;
	}
	//스왑함수
	public static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
