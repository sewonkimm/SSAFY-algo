import java.io.*;
import java.util.*;
public class algo_0912_boj17143_fishingKingTest {
	//백준 17143 낚시왕
	//1. 다섯가지 정보를 어떻게 저장하고 사용할 것인가 -> 리스트 활용
	//2. 이동하고 겹쳤을 때의 결과 처리방법? -> map과 크기가 동일한 2번째 배열을 활용해서 이동결과만 모아놓은 뒤, map에 복사해주는 식
	static int r,c,m;
	static int[][] map;
	static int[][] after;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1}; //1 위 2아래 3 오른쪽 4왼쪽
	static int fishMan;
	static int result;
	static List<Shark> list = new ArrayList<>();
	static class Shark{ //5가지 정보
		int x;
		int y;
		int s;
		int d;
		int z;
		public Shark(int x, int y, int s, int d, int z) {
			super();
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
		
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int sx,sy,ss,sd,sz;
			
			sx = Integer.parseInt(st.nextToken())-1;
			sy = Integer.parseInt(st.nextToken())-1;
			ss = Integer.parseInt(st.nextToken());
			sd = Integer.parseInt(st.nextToken())-1;
			sz = Integer.parseInt(st.nextToken());
			
			map[sx][sy] = sz;
			list.add(new Shark(sx,sy,ss,sd,sz)); //리스트에 추가
		}
		
		fishMan = -1; //-1자리부터 시작(첫번째는 0)
		result = 0; //결과값 저장
		while(fishMan!=c-1) { //끝에 도착하면 끝
			fishMan++;
			
			loop:
			for(int i=0;i<r;i++) {
				if(map[i][fishMan]!=0) { //낚시왕이 발견하면
					result +=map[i][fishMan];  //결과에 포함시키고
					map[i][fishMan] = 0; //0으로 만들고
					for(int j=0;j<list.size();j++) { //리스트를 뒤져서 해당 상어 정보 삭제
						if(list.get(j).x == i && list.get(j).y == fishMan) {
							list.remove(j);
							break loop;
						}
					}
					
				}
			}
			
			after = new int[r][c]; //0으로 초기화 
			//r,c가 작으면 선언으로 초기화하는게 시간줄이는데 도움이 됨, 반면에 메모리는 좀 더 사용
			
			int size = list.size();
			int size2 = list.size();
			for(int i=0;i<size;i++) {
				int x = list.get(0).x;
				int y = list.get(0).y;
				int s = list.get(0).s;
				int d = list.get(0).d;
				int z = list.get(0).z;
				
				list.remove(0);
				
				size2--; //1개 사용할 때마다 기존의 리스트가 몇개 남았나 알기위해서
				//(list의 개수는 줄었다가 늘어났다의 반복이라서 그걸론 정보가 부족함)
				
				if(d==0 || d==1)  //위아래로 움직일 때는 해당 방식으로 이동거리 압축가능
					s = s%(2*r-2);
				else if(d==2 || d==3) //좌우로 움직일 때는 해당 방식으로 이동거리 압축가능
					s = s%(2*c-2);
				
				for(int a=0;a<s;a++) {  //끝에 가면 반대 숫자(방향숫자)로 바꿔주고 좌표도 반대부호로 연산
					if(d==0) {
						if(x==0) { 
							d=1;
							x+=1;
						}
						else x-=1;
					}
					else if(d==1) {
						if(x==r-1) {
							d=0;
							x-=1;
						}
						else x+=1;
					}
					else if(d==2) {
						if(y==c-1) {
							d=3;
							y-=1;
						}
						else y+=1;
					}
					else if(d==3) {
						if(y==0) {
							d=2;
							y+=1;
						}
						else y-=1;
					}
				}
				
				int nx = x;
				int ny = y;
				
				
				if(after[nx][ny] == 0){ //해당자리가 비었으면 
					list.add(new Shark(nx,ny,s,d,z));
					after[nx][ny] = z;
				}
				else if(after[nx][ny]<z) { //해당 자리가 있었는데 잡아먹는다면
					
					for(int k=size2;k<list.size();k++) { //기존 남은 리스트는 거르고 새로 추가된 애들부터 검색
						if(list.get(k).x == nx && list.get(k).y == ny) { //같은 애 삭제 = 먹혔다
							if(z != list.get(k).z)
								list.remove(k);
						}
					}

					list.add(new Shark(nx,ny,s,d,z));
					after[nx][ny] = z;
				}	
			}
			
			for(int i=0;i<r;i++) { //map에 복사
				for(int j=0;j<c;j++) {
					map[i][j] = after[i][j];
				}
			}

		}	
		System.out.println(result);
	}
}
