import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        int[][] map = new int[101][101];    // 50 * 2
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        for (int[] cur: rectangle) {
            cur[0] *= 2;
            cur[1] *= 2;
            cur[2] *= 2;
            cur[3] *= 2;
            
            for (int i = cur[0]; i <= cur[2]; i++) {
                for (int j = cur[1]; j <= cur[3]; j++) {
                    if (i == cur[0] || i == cur[2] || j == cur[1] || j == cur[3]) {
                        if (map[i][j] == -1) continue;
                        map[i][j] = 1;
                    } else {
                        map[i][j] = -1;
                    }
                }
            }
        }
        
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[101][101];
        
        q.offer(new int[]{characterX, characterY});
        visited[characterX][characterY] = 1;
    
        ww:
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i = 0; i < dirs.length; i++) {
                int nx = cur[0] + dirs[i][0];
                int ny = cur[1] + dirs[i][1];
                
                if (nx < 2 || nx > 100 || ny < 2 || ny > 100 || visited[nx][ny] > 0) continue;
                if (map[nx][ny] != 1) continue; 
                
                q.offer(new int[]{nx,ny});
                visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                if (nx ==  itemX && ny == itemY) {
                    break ww;
                }
                
            }
        
        }
        
        return visited[itemX][itemY] / 2;
    }
}