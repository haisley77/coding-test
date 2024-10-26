import java.util.*;

class Solution {
    
    int sx = 0, sy = 0, ex = 0, ey = 0;
    char[][] map;
    boolean[][] visited;
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    
    public int solution(String[] board) {
        
        int n = board.length;
        int m = board[0].length();
        
        map = new char[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = board[i].charAt(j);
                if (map[i][j] == 'R') {
                    sx = i;
                    sy = j;
                }
                if (map[i][j] == 'G') {
                    ex = i;
                    ey = j;
                }
            }
        }
        
        return bfs(n, m);
    }
    
    public int bfs(int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {sx, sy, 0});
        visited[sx][sy] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0], curY = current[1], cnt = current[2];
            
            if (curX == ex && curY == ey) {
                return cnt;
            }
            
            for (int[] dir : dirs) {
                int nx = curX, ny = curY;
                
                while (true) {
                    nx += dir[0];
                    ny += dir[1];
                    
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == 'D') {
                        nx -= dir[0];
                        ny -= dir[1];
                        break;
                    }
                }
                
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny, cnt + 1});
                }
            }
        }
        
        return -1;
    }
}
