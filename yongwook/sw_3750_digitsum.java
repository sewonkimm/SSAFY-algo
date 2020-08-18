package practice;
import java.io.IOException;
import java.util.Scanner;

public class sw_3750_digitsum {
	static int sum =0;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in) ;
		
		int tc = sc.nextInt();
				
		for (int i = 0; i < tc; i++) {
			
		
			String number = sc.next();
		
			check(number);
			
			System.out.println("#"+(i+1)+" "+sum);
		}
		
		
	}
	
	public static void check(String n){
		sum=0;
		char n1[] = new char[n.length()] ;
		for (int j = 0; j < n.length(); j++) {
			 n1[j] = (char) (n.charAt(j)-48);
		}
		for (int i = 0; i < n1.length; i++) {
			 sum += (int)n1[i];
		}
		
	
		if(sum>=10) check(Integer.toString(sum));
		else if(sum<10) {
			return;
		}
		
	}
}
	