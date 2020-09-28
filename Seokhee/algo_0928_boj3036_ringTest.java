import java.util.Scanner;

public class algo_0928_boj3036_ringTest {

	//백준 3036 링
	//기약분수 = 최대공약수 = gcd, 반복문보다는 재귀가 코드는 간단하다
	//gcd메소드를 만들고 활용하자
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		arr[0] = sc.nextInt();
		for(int i=1;i<n;i++) {
			arr[i] = sc.nextInt();
			System.out.println(arr[0]/gcd(arr[0],arr[i])+"/"+arr[i]/gcd(arr[0],arr[i]));
		}
		
		
	}

	static int gcd(int a, int b){  //a와 b의 최대공약수를 구해주는 gcd메소드
	    if(b == 0){
	        return a;
	    }else{
	        return gcd(b, a%b); //재귀형식으로 최대공약수를 찾는다
	    }
	}

}
