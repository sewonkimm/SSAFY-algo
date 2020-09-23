import java.util.*;
import java.io.*;

public class p10 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1[] = br.readLine().split(" ");
		String str2[] = br.readLine().split(" ");
		
		int w = Integer.parseInt(str1[0]);
		int h = Integer.parseInt(str1[1]);
		int x = Integer.parseInt(str2[0]);
		int y = Integer.parseInt(str2[1]);
	
		int N = Integer.parseInt(br.readLine());
		
		boolean maxW = (x + N) / w % 2 == 1;
		boolean maxH = (y + N) / h % 2 == 1;
		
		int ax = 0;
		int ay = 0;
		
		if (maxW) {
			ax = w - (x + N) % w;
		} else {
			ay = (x + N) % w;
		}
		if (maxH) {
			ax = h - (y + N) % h;
		} else {
			ay = (y + N) % h;
		}
		
		System.out.println(ax+" "+ay);
	}
}
