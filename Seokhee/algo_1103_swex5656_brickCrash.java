import java.util.*;
import java.io.*;

public class algo_1103_swex5656_brickCrash {
	
	static int n,w,h;
	static ArrayList<ArrayList<Brick>> map = new ArrayList<>();
	static class Brick{
		int info;
		boolean live;
		public Brick(int info, boolean live) {
			super();
			this.info = info;
			this.live = live;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			//Collections.reverse(arrayList);
			
			for(int i=0;i<w;i++) {
				map.add(new ArrayList<>());
			}
			
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					int num = Integer.parseInt(st.nextToken());
					if(num != 0)
						map.get(j).add(new Brick(num,true));
				}
			}
			
			for(int i=0;i<w;i++) {
				Collections.reverse(map.get(i));
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i=0;i<w;i++) {
			for(int j=0;j<w;j++) {
				for(int k=0;k<w;k++) {
					ArrayList<ArrayList<Brick>> list = crashBrick(k,crashBrick(j,crashBrick(i,map)));
					
					int sum = 0;
					for(int a=0;a<w;a++) {
						sum += list.get(a).size();
					}
					if(min > sum)
						min = sum;
					
				}
			}
		}
		System.out.println(min);
	}
	static ArrayList<ArrayList<Brick>> crashBrick(int ww, ArrayList<ArrayList<Brick>> map) {
		ArrayList<ArrayList<Brick>> copy = new ArrayList<>();
		for(int i=0;i<w;i++) {
			copy.add(new ArrayList<>());
		}
		copyMap(map, copy);
		
		if(copy.get(ww).size() != 0) {
			dfs(copy.get(ww).size()-1,ww,copy);
		
			for(int i=copy.size()-1;i>=0;i--) {
				int size = copy.get(i).size();
				for(int j=size-1;j>=0;j--) {
					if(copy.get(i).get(j).live == false) {
						copy.get(i).remove(j);
					}
				}
			}
		}
		
		return copy;
	}
	
	static void copyMap(ArrayList<ArrayList<Brick>> map1, ArrayList<ArrayList<Brick>> map2) {
		//map1이 원본, 깊은 복사
		for(int i=0;i<map1.size();i++) {
			map2.get(i).addAll(map1.get(i));
		}
	}
	
	static void dfs(int x, int y, ArrayList<ArrayList<Brick>> map) {
		if(map.get(y).get(x).live == true) {
			map.get(y).get(x).live = false;
			
			for(int i=1;i<=map.get(y).get(x).info-1;i++) {
				if(x+i>=0 && y>=0 &&  x+i<h && y<w && x+i<map.get(y).size() && map.get(y).get(x+i).live == true) {
					dfs(x+i,y,map);
				}
				if(x>=0 && y+i>=0 && x<h && y+i<w &&x<map.get(y+i).size() && map.get(y+i).get(x).live == true) {
					dfs(x,y+i,map);
				}
				if(x-i>=0 && y>=0 && x-i<h && y<w &&x-i<map.get(y).size() && map.get(y).get(x-i).live == true) {
					dfs(x-i,y,map);
				}
				if(x>=0 && y-i>=0 &&  x<h && y-i<w &&x<map.get(y-i).size() && map.get(y-i).get(x).live == true) {
					dfs(x,y-i,map);
				}
			}
		}
	}
	
}
