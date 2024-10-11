import java.util.*;

class Solution {
    
    char[][] map;
    int w, h;
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    public int solution(String[] maps) {
        int answer = -1;
        w = maps[0].length();
        h = maps.length;
        map = new char[h][w];
        
        int startX = 0, startY = 0;
        int leverX = 0, leverY = 0;
        int endX = 0, endY = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                map[i][j] = maps[i].charAt(j);
                if (map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
                if (map[i][j] == 'L') {
                    leverX = i;
                    leverY = j;
                }
                if (map[i][j] == 'E') {
                    endX = i;
                    endY = j;
                }
            }
        }
        int term1 = bfs(startX, startY, leverX, leverY);
        int term2 = bfs(leverX, leverY, endX, endY);
        if (term1 == 0 || term2 == 0) answer = -1;
        else answer = term1 + term2;
        return answer;
    }
    
    public int bfs(int startX, int startY, int endX, int endY) {
        int[][] visited = new int[h][w];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
        visited[startX][startY] = 1;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == endX && cur[1] == endY) {
                return visited[endX][endY] - 1;
            }
            
            for (int i = 0; i < dirs.length; i++) {
                int nx = cur[0] + dirs[i][0];
                int ny = cur[1] + dirs[i][1];
                if (nx < 0 || nx >= h || ny < 0 || ny >= w || visited[nx][ny] > 0) continue;
                if (map[nx][ny] == 'X') continue;
                visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                q.offer(new int[]{nx,ny});
            }
            
        }
    
        
        return visited[startX][startY] - 1;
    }
}