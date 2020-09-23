import java.util.*;
public class p13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int bNum = sc.nextInt();
		int[] bulb = new int[bNum+1];
		for(int i=1;i<=bNum;i++) {
			bulb[i] = sc.nextInt();
		}
		
		int sNum = sc.nextInt();
		
		int s;
		int std;
		for(int i=0;i<sNum;i++) {
			s = sc.nextInt();
			std = sc.nextInt();
			
			//남자
			if(s == 1) {
				int ss = std;
				while(std<=bNum) {
					if(bulb[std] == 1)
						bulb[std] = 0;
					else if(bulb[std] == 0)
						bulb[std] = 1;
					std = std+ss;
				}
			}
			//여자
			else if(s == 2){ 
				int w = 1;

				if(bulb[std] == 1)
					bulb[std] = 0;
				else if(bulb[std] == 0)
					bulb[std] = 1;
				
				while(true) {
					if(std+w >=1 && std-w >=1 && std+w <= bNum && std-w <= bNum) {
						if(bulb[std+w] == bulb[std-w]) {
							if(bulb[std+w] == 1) {
								bulb[std+w] = 0; bulb[std-w] = 0; 
							}
							else if(bulb[std+w] == 0) {
								bulb[std+w] = 1; bulb[std-w] = 1;
							}
							w++;
						}
						else {
							break;
						}
					}else {
						break;
					}
				}
			}
		}
		
		for(int i=1;i<=bNum;i++) {
			if(i%20 == 0)
				System.out.print(bulb[i]+"\n");
			else System.out.print(bulb[i]+" ");
		}
	}

}
