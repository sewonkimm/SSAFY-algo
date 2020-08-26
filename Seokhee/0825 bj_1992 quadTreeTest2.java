import java.io.*;
import java.util.*;

public class quadTreeTest2 {
	//쿼드트리 백준 1992번
	//4분면으로 나눠서 접근하자 그대신 0000과 1111은 각각 0과 1로 나올수 있도록하자
	static int n;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for(int i=0;i<n;i++) {
			s = br.readLine();
			for(int j=0;j<n;j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		quadTree(0,0,n);	
	}
	
	static void quadTree(int x,int y,int w) {
		
		int flag_0 = 0,flag_1=0, flag_2=0, flag_3=0, flag_4=0;
		StringBuilder sb = new StringBuilder(""); //0000,1111판정을 위한 sb
		
		if(w==n) {  //제일 처음에(w==n) 전체가 다같은지 한번봐도 될 여유는 있음.
					//압축을 안할경우 괄호가 없어야되서 불가피했다.
			for(int i=x;i<x+w;i++) {
				for(int j=y;j<y+w;j++) {
					if(map[x][y] != map[i][j]) {
						flag_0=1;
						i=n;j=n;
					}
				}
			}
			if(flag_0 ==0) {
				System.out.println(map[x][y]);
				return;
			}
		}
		
		System.out.print("("); //괄호출력
		
		for(int i=x;i<x+w/2;i++) { //좌상
			for(int j=y;j<y+w/2;j++) {
				if(map[x][y] != map[i][j]) {
					flag_1=1;
					System.out.print(sb.toString());//다른게 있으면 sb출력하고 비우고 쿼드트리 시작
					sb = new StringBuilder("");
					quadTree(x,y,w/2);
					i=n;j=n;
				}
			}
		}
		if(flag_1 ==0) { //다른게없다 확인
			if(map[x][y]==0) //System.out.print(0);
				sb.append("0");				
			else if(map[x][y]==1) //System.out.print(1);
				sb.append("1");		
		}				
		
		
		
		for(int i=x;i<x+w/2;i++) {
			for(int j=y+w/2;j<(y+w/2)+w/2;j++) {
				if(map[x][y+w/2] != map[i][j]) {
					flag_2=1;
					System.out.print(sb.toString()); //다른게 있으면 sb출력하고 비우고 쿼드트리 시작
					sb = new StringBuilder("");
					quadTree(x,y+w/2,w/2);					
					i=n;j=n;
				}
			}
		}
		if(flag_2 ==0) { //다른게없다 확인
			if(map[x][y+w/2]==0) //System.out.print(0);
				sb.append("0");					
			else if(map[x][y+w/2]==1) //System.out.print(1);
				sb.append("1");		
		}
		
		
		
		for(int i=x+w/2;i<(x+w/2)+w/2;i++) {
			for(int j=y;j<y+w/2;j++) {
				if(map[x+w/2][y] != map[i][j]) {
					flag_3=1;
					System.out.print(sb.toString());//다른게 있으면 sb출력하고 비우고 쿼드트리 시작
					sb = new StringBuilder("");
					quadTree(x+w/2,y,w/2);
					i=n;j=n;
				}
			}
		}
		if(flag_3 ==0) { //다른게없다 확인
			if(map[x+w/2][y]==0)//System.out.print(0);
				sb.append("0");	
			else if(map[x+w/2][y]==1) //System.out.print(1);
				sb.append("1");					
		}
		
		
		for(int i=x+w/2;i<(x+w/2)+w/2;i++) {
			for(int j=y+w/2;j<(y+w/2)+w/2;j++) {
				if(map[x+w/2][y+w/2] != map[i][j]) {
					flag_4=1;	
					System.out.print(sb.toString());//다른게 있으면 sb출력하고 비우고 쿼드트리 시작
					sb = new StringBuilder("");
					quadTree(x+w/2,y+w/2,w/2);
					i=n;j=n;
				}
			}
		}
		if(flag_4 ==0) { //다른게없다 확인
			if(map[x+w/2][y+w/2]==0) //System.out.print(0);
				sb.append("0");	
			else if(map[x+w/2][y+w/2]==1) //System.out.print(1);
				sb.append("1");				
		}		
		
		//0000 / 1111 변환
		if(sb.toString().equals("0000"))
			sb = new StringBuilder("0");
		else if(sb.toString().equals("1111"))
			sb = new StringBuilder("1");		
		System.out.print(sb.toString());
			
		System.out.print(")");
	}
}









