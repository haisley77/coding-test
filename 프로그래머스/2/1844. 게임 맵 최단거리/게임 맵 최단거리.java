import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        return bfs(maps, maps.length, maps[0].length);
    }
    private int bfs(int[][] maps, int h, int w) {
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    
        int[][] visited = new int[h][w];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0] = 1;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i = 0; i < dirs.length; i++) {
                int nx = cur[0] + dirs[i][0];
                int ny = cur[1] + dirs[i][1];
                
                if (nx < 0 || nx >= h || ny < 0 || ny >= w || visited[nx][ny] > 1) continue;
                if (maps[nx][ny] == 0) continue;
                
                visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                q.offer(new int[]{nx,ny});
            }
        }
        
        if (visited[h-1][w-1] == 0) return -1;
        else return visited[h-1][w-1];
    }
}