import java.util.*;

class Solution {
    int n, m;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        int answer = bfs(maps);
        return answer;
    }
    
    private int bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], 1);
        }
        q.offer(new int[]{0,0});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == n && cur[1] == m) break;
            
            for (int i = 0; i < dirs.length; i++) {
                int nx = cur[0] + dirs[i][0];
                int ny = cur[1] + dirs[i][1];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] > 1 || maps[nx][ny] == 0) continue;
            
                visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
        
        if (visited[n-1][m-1] == 1) return -1;
        return visited[n-1][m-1];
    }
}