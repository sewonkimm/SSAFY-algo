package gold ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_14890_경사로 {
    static int[][] map;
    static int n;
    static int l;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (go(i, 0, 0)) {
                count++;
            }

            if (go(0, i, 1)) {
                count++;
            }
        }
        System.out.println(count);
    }

    static boolean go(int x, int y, int dir) {
        boolean[] visited = new boolean[n];
        int[] height = new int[n];

        for (int i = 0; i < n; i++) {
            height[i] = (dir == 0) ? map[x][y + i] : map[x + i][y];
        }

        for (int i = 0; i < n - 1; i++) {
            if (height[i] == height[i + 1]) {
                continue;
            }

            if (Math.abs(height[i] - height[i + 1]) > 1) {
                return false;
            }

            if (height[i] - 1 == height[i + 1]) {
                for (int j = i + 1; j <= i + l; j++) {
                    if (j >= n || visited[j] || height[j] != height[i + 1]) {
                        return false;
                    }
                    visited[j] = true;
                }
            } else if (height[i] + 1 == height[i + 1]) {
                for (int j = i; j > i - l; j--) {
                    if (j < 0 || visited[j] || height[j] != height[i]) {
                        return false;
                    }
                    visited[j] = true;
                }
            }

        }
        return true;
    }
}