import java.util.*;
public class p12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int max = 0;
		int nn = 0;
		int cnt = 2;
		
		for(int i=n;i>0;i--) {
			int f = n;
			List<Integer> list = new ArrayList<>();
			list.add(f); 
			list.add(i);
			int p = 0;
			while(true) {
				int num = list.get(p) - list.get(p+1);
				
				if(num >= 0) {
					list.add(num);
					cnt++;
					p++;
				}
				else {
					if(max < cnt) {
						max = cnt;
						nn = i;
					}
					cnt = 2;
					break;
				}
			}
		}
		
		List<Integer> list = new ArrayList<>();
		list.add(n); 
		list.add(nn);
		
		int p = 0;
		while(true) {
			int num = list.get(p) - list.get(p+1);
			
			if(num >= 0) {
				list.add(num);
				cnt++;
				p++;
			}
			else {
				System.out.println(max);
				for(int i=0;i<list.size();i++) {
					System.out.print(list.get(i)+" ");
				}
				return;
			}
		}
		
		
		
	}
}
