import java.util.*;
public class p5 {
	static class Point {
	    int direction;
	    int y;
	    int x;
	 
	    Point(int direction, int distance, int c, int r) {
	        this.direction = direction;
	 
	        if (direction == 1) {
	            this.y = 0;
	            this.x = distance;
	        } else if (direction == 2) {
	            this.y = c;
	            this.x = distance;
	        } else if (direction == 3) {
	            this.y = distance;
	            this.x = 0;
	        } else {
	            this.y = distance;
	            this.x = r;
	        }
	    }
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
	    int c = sc.nextInt();
	    int n = sc.nextInt();
	    ArrayList<Point> list = new ArrayList<Point>();
	 
	    for (int i = 0; i < n; i++) {
	        int dir = sc.nextInt();
	        int dis = sc.nextInt();
	        Point p = new Point(dir, dis, c, r);
	        list.add(p);
	    }
	 
	    int d = sc.nextInt();
	    int v = sc.nextInt();
	    Point pp = new Point(d, v, c, r);
	    int temp = 0;
	    int ans = 0;
	 
	    if (d == 1) {
	        temp = 2;
	    } else if (d == 2) {
	        temp = 1;
	    } else if (d == 3) {
	        temp = 4;
	    } else {
	        temp = 3;
	    }
	 
	    for(Point p : list) {
	        if (p.direction == temp) {
	            if (p.direction == 1 || p.direction == 2) {
	                ans += Math.min(pp.y + p.y + pp.x + p.x, pp.y + p.y + r - pp.x + r - p.x);
	            } else {
	                ans += Math.min(c - pp.y + c - p.y + pp.x + p.x, pp.y + p.y + pp.x + p.x);
	            }
	        } else {
	            ans += Math.abs(pp.y - p.y) + Math.abs(pp.x - p.x);
	        }
	    }
	    System.out.println(ans);

	}
	
	


}
