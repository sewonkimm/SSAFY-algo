import java.util.Scanner;

public class BJ_3036_Ring {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int first = sc.nextInt();
		int temp = 0;
		for (int i = 0; i < N-1; i++) {
			temp = sc.nextInt();
			System.out.println(first/gcd(first, temp) + "/" + temp/gcd(first, temp));
		}
		sc.close();
	}
	
	// 최대공약수 찾기 => 유클리드 호제법
	private static int gcd(int a, int b) {
		int temp, n;
		// 만약 입력되는 값이 더 큰 경우 -> Swap
		if(a<b) {
			temp = a;
			a = b;
			b = temp;
		}
		// b가 0이 될 때까지 반복
		while(b!=0) {
			n = a%b;
			a = b;
			b = n;
		}
		return a;
	}

}
