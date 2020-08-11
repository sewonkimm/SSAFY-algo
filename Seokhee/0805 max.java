
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		int a;
		for(int t = 1; t <= T; t++)
		{
            int max = -1;
            
            for(int i=0;i<10;i++){
                a = sc.nextInt();
                if(max<a){
                    max = a;
                }
            }
			System.out.println("#"+t+" "+max);
		}
	}
}