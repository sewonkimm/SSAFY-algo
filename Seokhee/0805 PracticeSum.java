import java.util.Scanner;


public class PracticeSum {

	static int[][] arr = new int[100][100];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1;t<=10;t++) {
			int num = sc.nextInt();
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int sum = 0;
			int max = -1;
			//���� ��
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					sum += arr[i][j];
				}
				if(max<sum)
					max = sum;
				sum = 0;
			}
			
			//���� ��
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					sum += arr[j][i];
				}
				if(max<sum)
					max = sum;
				sum = 0;
			}
			
			//������->�����Ʒ� �밢��
			for(int i=0,j=0;i<100 && j<100;i++,j++) {
					sum += arr[i][j];
			}
			if(max<sum)
				max = sum;
			sum = 0;
			
			//������->���ʾƷ� �밢��
			for(int i=0,j=99;i<100 && j>=0;i++,j--) {
					sum += arr[i][j];
			}
			if(max<sum)
				max = sum;
			sum = 0;
			
			System.out.println("#"+t+" "+max);	
		}
		
		
	}

}
