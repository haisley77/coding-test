import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        int[][] map = new int[101][101];
        for (int i = 0; i < rectangle.length; i++) {
            int[] cur = rectangle[i];
            for (int j = 0; j < 4; j++) {
                cur[j] *= 2;
            }
            
            for (int j = cur[1]; j <= cur[3]; j++) {
                for (int k = cur[0]; k <= cur[2]; k++) {
                    if (j == cur[1] || j == cur[3] || k == cur[0] || k == cur[2]) {
                        if (map[j][k] != -1) map[j][k] = 1;
                    } else {
                        map[j][k] = -1;
                    }
                }
            }
            
        }
        
        answer = bfs(characterY*2, characterX*2, itemY*2, itemX*2, map);
        return answer;
    }
    
    private int bfs(int sx, int sy, int ex, int ey, int[][] map) {
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int[][] visited = new int[101][101];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy});
        visited[sx][sy] = 1;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i = 0; i < dirs.length; i++) {
                int nx = cur[0] + dirs[i][0];
                int ny = cur[1] + dirs[i][1];
                if (nx < 2 || nx > 100 || ny < 2 || ny > 100 || visited[nx][ny] > 0) continue;
                if (map[nx][ny] <= 0) continue;
                visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                q.offer(new int[]{nx,ny});
            }
            
        }
        
        return visited[ex][ey]/2;
    }
}