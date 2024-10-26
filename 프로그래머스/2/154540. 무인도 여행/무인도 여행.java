import java.util.*;

class Solution {
    boolean[][] visited;
    public int[] solution(String[] maps) {
        Queue<Integer> answer = new LinkedList<>();
        
        int n = maps.length;
        int m = maps[0].length();
        
        
        char[][] map = new char[n][m];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'X') continue;
                answer.offer(bfs(n,m,map,i,j));
            }
        }
        
        
        if (answer.isEmpty()) {
            return new int[]{-1};
        }
        
        int[] arr = new int[answer.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = answer.poll();
        }
        Arrays.sort(arr);
        
        return arr;
    }
    
    public int bfs(int n, int m, char[][] map, int startX, int startY) {
        int res = 0;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX,startY});
        res += map[startX][startY] - '1' + 1;
        map[startX][startY] = 'X';
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i = 0; i < dirs.length; i++) {
                int nx = cur[0] + dirs[i][0];
                int ny = cur[1] + dirs[i][1];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == 'X') continue;
                
                res += map[nx][ny] - '1' + 1;
                map[nx][ny] = 'X';
                q.offer(new int[]{nx,ny});
            }
        }
        
        return res;
    }
}