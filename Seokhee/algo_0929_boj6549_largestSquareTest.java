import java.io.*;
import java.util.*;

public class algo_0929_boj6549_largestSquareTest {

	//백준 6549 히스토그램에서 가장 큰 직사각형
	//세그먼트 트리를 이용해서 부분합을 빠르게 구하고 그 중 가장 큰 값을 찾아내자
	//부분합을 구하는 과정은 그냥 더하는게 아니라 그 범위에서 가장 작은수 기준으로 해야함
	//작은수의 "인덱스"를 세그먼트 트리에 넣어주자, 그 다음 부분합 구하기 -> 구하는 즉시 비교하며 max 바로 갱신
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		SegmentTree segmentTree;
		StringBuilder sb = new StringBuilder("");
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			if(n == 0) break;
			
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			segmentTree = new SegmentTree(arr);
		    sb.append(segmentTree.getMaxWidth(0, n-1)+"\n");
		}
		
		System.out.println(sb);
	}
}

class SegmentTree {
	private int n, arr[], rangeMinIndex[], INF = 0x7fffffff; //int 끝수, 이거 아니면 3f3f3f3f 해도 무관, 큰 수 아무거나 넣자
	
	public SegmentTree(int arr[]) {
		n = arr.length;
		this.arr = arr.clone();
		rangeMinIndex = new int[n<<2];
		
		init(0, n-1, 1);
	}

	// 세그먼트 트리엔 구간별 최소값의 인덱스를 저장한다. 
	private int init(int left, int right, int node) {
	    // 인덱스가 저장됨에 유의 
		if(left == right) return rangeMinIndex[node] = left;
		
		int mid = (left + right) >>> 1;
		int leftMinIndex = init(left, mid, node<<1);
		int rightMinIndex = init(mid+1, right, (node<<1)+1);

	    //arr[인덱스]를 통해 배열을 탐색하여 '값 비교',, 반환은 '인덱스' 
		return rangeMinIndex[node] = 
			arr[leftMinIndex] < arr[rightMinIndex] ? leftMinIndex : rightMinIndex;
	}
	
	private int query(int left, int right, int node, int nodeLeft, int nodeRight) {
		if(nodeRight<left || right<nodeLeft) return INF;
		
		if(left<=nodeLeft && nodeRight<=right) return rangeMinIndex[node];
		
		int mid = (nodeLeft + nodeRight) >>> 1;
		int leftMinIndex = query(left, right, node<<1, nodeLeft, mid);
		int rightMinIndex = query(left, right, (node<<1)+1, mid+1, nodeRight);
		
	    // 잘못된 범위로 진입하면 INF를 반환하기에 Index에러를 방지하기 위한 조건문 
		if(leftMinIndex == INF) return rightMinIndex;
		else if(rightMinIndex == INF) return leftMinIndex;
		else return arr[leftMinIndex] < arr[rightMinIndex] ? leftMinIndex : rightMinIndex;
	}
	
	public long getMaxWidth(int left, int right) {
		long maxWidth, tmpWidth;
		int minIndex = query(left, right, 1, 0, n-1);
		
		//최소 높이를 바탕으로 넓이 계산
		maxWidth = (long)(right - left + 1) * (long)arr[minIndex];
		
		//왼쪽 존재하는가?
		if(left<=minIndex-1) {
			tmpWidth = getMaxWidth(left, minIndex-1);
			//왼쪽의 넓이를 가지고 최대값 비교
			maxWidth = Math.max(maxWidth, tmpWidth);
		}
		
		//우측 존재하는가?
		if(minIndex+1<=right) {
			tmpWidth = getMaxWidth(minIndex+1, right);
			//오른쪽의 넓이를 가지고 최대값 비교
			maxWidth = Math.max(maxWidth, tmpWidth);
		}
		return maxWidth;
	}
}
