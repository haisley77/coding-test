import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int startX;
        int startY;
        int curX;
        int curY;
        Node(int startX, int startY, int curX, int curY) {
            this.startX = startX;
            this.startY = startY;
            this.curX = curX;
            this.curY = curY;
        }
    }
    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    static int[][] map;
    static int N, M, res = Integer.MAX_VALUE;
    static ArrayList<int[]> chicken, homes;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        arr = new int[M];
        chicken = new ArrayList<>();
        homes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) chicken.add(new int[]{i,j});
                if (map[i][j] == 1) homes.add(new int[]{i,j});
            }
        }

        combination(0,0);
        System.out.println(res);


    }


    private static void combination(int start, int cnt) {
        if (cnt == M) {
            res = Math.min(res, calculateTotal());
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            arr[cnt] = i;
            combination(i+1, cnt+1);
        }
    }

    private static int calculateTotal(){
        int totalDist = 0;

        for (int[] home: homes) {
            int minDist = Integer.MAX_VALUE;

            for (int i = 0; i < M; i++) {
                int[] cur = chicken.get(arr[i]);
                int dist = getDist(home[0], home[1], cur[0], cur[1]);
                minDist = Math.min(minDist, dist);
            }

            totalDist += minDist;
        }

        return totalDist;
    }

    private static int getDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
}
