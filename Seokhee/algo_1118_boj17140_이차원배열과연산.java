import java.util.*;
import java.io.*;

public class algo_1118_boj17140_이차원배열과연산 {
	
	static int r,c,k, nowR, nowC;
	static int[][] map;
	static int flag;
	static int time;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		k = sc.nextInt();
		
		nowR = 3; nowC = 3;
		
		map = new int[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		while(true) {
			if(time>100) {
				time = -1;
				break;
			}
			if(nowR >= r && nowC >= c && map[r-1][c-1] == k) {
				break;
			}
			int max = 0;
			int[][] temp = new int[100][100]; //0으로 채워져있음
			if(nowR>=nowC) { //R연산
				for(int i=0;i<nowR;i++) {
					List<int[]> list = new ArrayList<>();
					for(int j=0;j<nowC;j++) {
						flag = 0;
						for(int k=0;k<list.size();k++) {
							if(list.get(k)[0] == map[i][j]) {
								list.get(k)[1]++;
								
								flag = 1;
								break;
							}
						}
						if(flag == 0) {
							if(map[i][j] == 0)
								continue;
							list.add(new int[] {map[i][j],1});
						}
						if(list.size()*2>max)
							max = list.size()*2;
					}
					Collections.sort(list, new Comparator<int[]>() {
						@Override
						public int compare(int[] o1, int[] o2) {
							if(o1[1] < o2[1]) {
								return -1;
							}
							else if(o1[1] > o2[1]) {
								return 1;
							}
							else {
								if(o1[0] < o2[0]) {
									return -1;
								}
								else if(o1[0] > o2[0]) {
									return 1;
								}
								else {
									return 0;
								}
							}
						}
					});
					for(int j=0;j<list.size();j++) {
						temp[i][j*2] = list.get(j)[0];
						temp[i][j*2+1] = list.get(j)[1];
					}
				}
				map = new int[nowR][max];
				
				//System.out.println();
				for(int a=0;a<nowR;a++) {
					for(int b=0;b<max;b++) {
						map[a][b] = temp[a][b];
						//System.out.print(map[a][b]+" ");
					}
					//System.out.println();
				}
				//System.out.println();
				time++;
				
				//nowR = nowR;
				nowC = max;
			}
			else if(nowR<nowC) { //C연산
				for(int i=0;i<nowC;i++) {
					List<int[]> list = new ArrayList<>();
					for(int j=0;j<nowR;j++) {
						flag = 0;
						for(int k=0;k<list.size();k++) {
							if(list.get(k)[0] == map[j][i]) {
								list.get(k)[1]++;
								
								flag = 1;
								break;
							}
						}
						if(flag == 0) {
							if(map[j][i] == 0)
								continue;
							list.add(new int[] {map[j][i],1});
						}
						if(list.size()*2>max)
							max = list.size()*2;
					}
					
					Collections.sort(list, new Comparator<int[]>() {
						@Override
						public int compare(int[] o1, int[] o2) {
							if(o1[1] < o2[1]) {
								return -1;
							}
							else if(o1[1] > o2[1]) {
								return 1;
							}
							else {
								if(o1[0] < o2[0]) {
									return -1;
								}
								else if(o1[0] > o2[0]) {
									return 1;
								}
								else {
									return 0;
								}
							}
						}
					});
					
					for(int j=0;j<list.size();j++) {
						temp[j*2][i] = list.get(j)[0];
						temp[j*2+1][i] = list.get(j)[1];
					}
				}
				map = new int[max][nowC];
				
				//System.out.println();
				for(int a=0;a<max;a++) {
					for(int b=0;b<nowC;b++) {
						map[a][b] = temp[a][b];
						//System.out.print(map[a][b]+" ");
					}
					//System.out.println();
				}
				//System.out.println();
				time++;
				
				nowR = max;
				//nowC = nowC;
			}	
		}
		

		System.out.println(time);
	}	
}
