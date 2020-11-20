import java.io.*;
import java.util.*;

public class algo_1118_boj13335_트럭 {

	static int n,w,L;
	static int time;
	static Queue<Truck> queue = new LinkedList<>();
	static int[] tInfo;
	static class Truck{
		int weight;
		int dist;
		public Truck(int weight, int dist) {
			this.weight = weight;
			this.dist = dist;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    n = Integer.parseInt(st.nextToken()); //트럭의 수
	    w = Integer.parseInt(st.nextToken()); //다리의 길이
	    L = Integer.parseInt(st.nextToken()); //다리의 최대하중
	    
	    tInfo = new int[n];
	    
	    st = new StringTokenizer(br.readLine());
	    
	    for(int i=0;i<n;i++) {
	    	tInfo[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    int totalT = n;
	    int nowWeight = 0;
	    int ans = 0;
	    int flag;
	    
	    while(true) {
	    	if(ans == totalT)
	    		break;
	    	time++;
	    	Iterator<Truck> iter = queue.iterator();
	    	flag = 0;
	    	while(iter.hasNext()) {
	    		int now = ++iter.next().dist;
	    		if(now == w) {
	    			flag = 1;
	    		}
	    	}
	    	if(flag == 1) {
	    		Truck t = queue.poll();
    			ans++;
    			nowWeight -= t.weight;
	    	}
	    	if(n != 0 && nowWeight + tInfo[totalT-n] <= L) {
	    		queue.add(new Truck(tInfo[totalT-n],0));
	    		nowWeight += tInfo[totalT-n];
	    		n--;
	    	}
	    }
	    System.out.println(time);
	}
}
