import java.util.*;
import java.io.*;

public class algo_1014_boj1475_roomNumber {
	//백준 방번호 1475
	//6과 9가 중요하다
	//6과 9의 합을 2로 나눈 몫 + 6과 9의 합을 2로 나눈 나머지가 6과 9를 채우는데 필요한 세트개수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[10];
		String s = sc.nextLine();
		for(int i=0;i<s.length();i++) {
			int now = s.charAt(i)-'0';
			num[now]++;
		}
		int max = 0;
		int sn = (num[6]+num[9])/2 + (num[6]+num[9])%2; //6과 9를 채우는데 필요한 세트개수
		num[6] = sn; //num[6]은 6과 9를 채우는데 필요한 세트개수로 바뀌게 됨
		for(int i=0;i<9;i++) { //여기서 9는 안본다
			if(max<num[i])
				max = num[i];
			
		}
		System.out.println(max);
	}
}
