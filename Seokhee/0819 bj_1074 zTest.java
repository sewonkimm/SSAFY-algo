package com.ssafy;
import java.util.*;
public class zTest {
	
	//수학적 사고를 요구하는 1074번 문제
	//이차원 배열을 만들 필요없이 사분면으로 나누어서 생각하면 편할 것이라고 판단
	static int n;
	static int r;
	static int c;
	static int size1;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		//최초의 배열 가로(세로)길이
		size1 = (int)Math.pow(2, n); 
		//배열 사이즈를 뜻하도록
		
		recursive(r,c,size1); //재귀반복
	}
	
	static void recursive(int x,int y,int size1) {
		
		if(size1 ==2) { //2*2배열의 상태가 되도록 계속 4분의 1 토막을 내주자
			cnt = cnt+x*2+y; //2*2일때는 공식으로 횟수를 구하여 출력
			System.out.println(cnt);
			return;
		}
		
		int wide = size1/2; //사분면 판단을 위한 wide
		int sum = (size1/2)*(size1/2); //현재 배열 크기에 4분의1 단위, 사분면을 나눴을 때 더하기쉽도록
		//많은 계산량을 skip하게 도와줌
		
		if(x<wide && y<wide) {
			cnt+=0;
			recursive(x,y,wide); //4분의1토막, 좌상분면으로 이동시키기 (이미 좌상분면)
		}
		else if(x<wide && y<2*wide) {
			cnt+=sum; //좌상분면 4분의1만큼만 더해주자
			recursive(x,y-wide,wide); //4분의1토막, 좌상분면으로 이동시키기
		}
		else if(x<2*wide && y<wide) {
			cnt+=2*sum; //좌하분면 4분의2만큼만 더해주자
			recursive(x-wide,y,wide); //4분의1토막, 좌상분면으로 이동시키기
		}
		else if(x<2*wide && y<2*wide) {
			cnt+=3*sum; //우하분면 4분의3만큼만 더해주자
			recursive(x-wide,y-wide,wide); //4분의1토막, 좌상분면으로 이동시키기
		}
	}
}
