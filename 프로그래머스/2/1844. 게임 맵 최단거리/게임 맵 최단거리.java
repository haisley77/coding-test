import java.util.*;

class Solution {
    static int n, m;
    static int[][] visited;
    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new int[n][m];
        bfs(maps);
        return visited[n-1][m-1] != 0 ? visited[n-1][m-1] : -1;
    }
    
    private void bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0] = 1;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int px = cur[0] + dirs[i][0];
                int py = cur[1] + dirs[i][1];
                if (px < 0 || px >= n || py < 0 || py >= m || visited[px][py] != 0 || maps[px][py] == 0) continue;
                visited[px][py] = visited[cur[0]][cur[1]] + 1;
                q.offer(new int[]{px, py});
            }
        }
    }
}