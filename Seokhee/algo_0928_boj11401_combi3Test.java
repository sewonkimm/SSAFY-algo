import java.util.Scanner;

public class algo_0928_boj11401_combi3Test  {

	final static int mod = 1000000007; //나눌 수
	public static void main(String[] args) throws Exception {
		
		//백준 11401 swex조합 문제랑 똑같음
		Scanner sc = new Scanner(System.in);
		long[] fac = new long[4000001]; //인풋 400만 까지
		long[] fac2 = new long[4000001]; //인풋 400만 까지
		fac[1] = 1;
		
		for(int i=2;i<=4000000;i++) {  //팩토리얼 채우기
			fac[i] = (fac[i-1]*i) % mod;
		}
		
		fac2[4000000] = power(fac[4000000], mod-2);	
		
		for(int i=4000000-1;i>0;i--){ //fac2 라고 이름짓긴했지만 팩토리얼 숫자에서 p-2의 지수를 가지는 수를 구함 
			fac2[i] = (fac2[i+1] * (i+1)) % mod;
		}
		
		int n = sc.nextInt();
		int r = sc.nextInt();

		long rr = (fac[n] * fac2[n-r]) % mod;
		long rrr = (rr * fac2[r]) % mod;

		if(n == r || r == 0) { //n=k이거나 k가 0이면 1이 나와야함
			System.out.println(1);
			return;
		}
		System.out.println(rrr);	
	}
	static long power(long x, long y) { //지수연산 빠르게 구하기
		long ret = 1;
		while(y>0) {
			if(y%2 != 0) {
				ret *= x;
				ret %= mod;
			}
			x *= x;
			x %= mod;
			y /= 2;
		}
		return ret;
	}
}
