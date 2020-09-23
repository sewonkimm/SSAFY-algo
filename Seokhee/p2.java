import java.io.*;
import java.util.*;
public class p2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//IM 대비 2605 줄세우기 뽑는대로 거기까지 자리 체인지
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int nowN = 1; //현재 인원수
		int[] h = new int[n];
		for(int i=0;i<n;i++) {
			h[i] = i+1;
		}
		int nn;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			nn = Integer.parseInt(st.nextToken());
			if(nn == 0) { 
				nowN++; 
				continue;
			}
			
			int temp = h[nowN-1];
			int nnT = 0;
			for(int j=nowN;j>0;j--) { //앞으로 가면서 자리 체인지
				if(nn == nnT) { //뽑은 자리 도달하면 그만 체인지
					nnT = j;
					break;
				}
				
				h[j-1] = h[j-2]; //체인지
				nnT++;
			}
			
			nowN++;
			h[nnT-1] = temp; //다 뒤로 당겨오고 그자리에 뽑은사람 넣기
		}
		
		for(int i=0;i<n;i++) {
			System.out.print(h[i]+" ");
		}

	}

}
