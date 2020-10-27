
public class Programmers_멀쩡한사각형 {

	public static void main(String[] args) {
		int W = 8;
		int H = 12;
		
		System.out.println(solution(W, H));
	}

	private static long solution(int w, int h) {
        long answer = 1;
        
        // 정답 : w+h - gcd(w,h)
        
        if(w > h) {
        	int temp = w;
        	w = h;
        	h = temp;
        }
        
        answer = w + h - gcd(h,w);
        
        return w*h - answer;
    }
	
	private static int gcd(int a, int b) {
		if(b == 0) return a;
		
		return gcd(b, a%b);
	}
}
