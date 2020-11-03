package sliver;

import java.util.Scanner;

public class bj_14889_스타트와링크 {

    static int T,N;
    static int[][] map;
    static int min;
    static boolean[] choice;
    static int[] arrA, arrB;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

     //   T = sc.nextInt();
     //   for(int tc=1; tc<=T; tc++) {

        N = sc.nextInt();
        map = new int[N][N];
        
        arrA = new int[N/2];
        arrB = new int[N/2];
        
        for(int i=0; i<N; i++){                
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
            }
        }

        min = Integer.MAX_VALUE;
        choice = new boolean[N];
        
        comb(0, 0);
   //     System.out.println("#" + tc + " " + min);    
        System.out.println(min);
  //  }
                  
    sc.close();
}

public static void comb(int idx, int cnt){

    if(cnt == N/2){
        min = Math.min(min, check());
        return;
    }

    for( int i=idx; i<N; i++ ){
        choice[i] = true;
        comb(i+1, cnt+1);
        choice[i] = false;
    }
}

public static int check(){

    int sumA = 0;
    int sumB = 0;

    // 재료 분리 배열 인덱스
    int aIdx = 0;
    int bIdx = 0;
    
    for(int i=0; i<N; i++){
        if(choice[i]) arrA[aIdx++] = i;
        else arrB[bIdx++] = i;
    }
    
    for (int i = 0; i < N/2; i++) {
        for (int j = 0; j < N/2; j++) {
            if( j == i ) continue;
            sumA += map[arrA[i]][arrA[j]];
            sumB += map[arrB[i]][arrB[j]];
        }
        
    }
    
    return Math.abs(sumA-sumB);
}
}