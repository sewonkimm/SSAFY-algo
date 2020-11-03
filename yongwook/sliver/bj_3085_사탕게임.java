package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_3085_사탕게임 {
	static char map[][];
	static int dx[] = {-1,1,0,0};//상하좌우
	static int dy[] = {0,0,-1,1};
	static int t ;
	static int result=1;
 	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(br.readLine());
		map = new char[t][t];
		for (int i = 0; i < t; i++) {
			String input = br.readLine();
			for (int j = 0; j < t; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		//////////////////////////////////
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				swap(i,j);
			}
		}
		System.out.println(result);
	}
	public static void swap(int x , int y) {
		cnt(x,y);
		for (int i = 0; i < 4; i++) {
			int nx = dx[i]+ x;
			int ny = dy[i]+ y;
			if(nx>=0 && ny>=0 && nx<t && ny <t) {
				char temp = map[x][y];
				map[x][y] = map[nx][ny];
				map[nx][ny] = temp;
				
				cnt(nx,ny);
				
				temp = map[x][y];
				map[x][y]= map[nx][ny];
				map[nx][ny]= temp;
			}
		}
	}
	public static void cnt(int x, int y) {
		char temp = map[x][y];
		int cnt = 1;
		for (int i = y; i < t; i++) { /// 우
			if( (i+1)<t &&map[x][i+1]== temp) {
				cnt++;
			}else {
				break;
			}
		}
		for (int i = y; i >=0; i--) { //좌
			if(i-1>=0 && map[x][i-1] == temp) {
				cnt++;
			}else {
				break;
			}
		}
		if(cnt >=result){
			result= cnt;
		}
		cnt=1;
		for (int i = x; i < t; i++) { /// 하
			if( (i+1)<t &&map[i+1][y]== temp) {
				cnt++;
			}else {
				break;
			}
		}
		for (int i = x; i >=0; i--) { //상
			if(i-1>=0 && map[i-1][y] == temp) {
				cnt++;
			}else {
				break;
			}
		}
		if(cnt >=result){
			result= cnt;
		}
	}
}
