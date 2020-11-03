import java.io.*;
import java.util.*;
public class bj_17069_파이프옮기기2 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n+1][n+1];
        long[][][] dp = new long[3][n+1][n+1];
        //0 가로, 1 세로, 2 대각선 + 좌표
        dp[0][0][1] = 1;
        StringTokenizer st;
        
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(map[i][j+1] != 1) 
                    dp[0][i][j+1] += dp[0][i][j] + dp[2][i][j]; 
                if(map[i+1][j] != 1) 
                    dp[1][i+1][j] += dp[1][i][j] + dp[2][i][j];
                if(map[i+1][j+1] != 1 && map[i+1][j] != 1 && map[i][j+1] != 1)
                    dp[2][i+1][j+1] += dp[0][i][j] + dp[1][i][j] + dp[2][i][j];    
            }
        }
        
        System.out.println(dp[0][n-1][n-1] + dp[1][n-1][n-1] + dp[2][n-1][n-1]);
        
    }

}