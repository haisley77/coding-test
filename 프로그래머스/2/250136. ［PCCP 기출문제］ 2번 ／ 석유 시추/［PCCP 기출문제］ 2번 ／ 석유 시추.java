import java.util.*;

class Solution {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] newLand;
    static int n, m;
    static int[] groupSize;
    static boolean[][] visited;
    
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        newLand = new int[n][m];
        groupSize = new int[n * m + 1];
        visited = new boolean[n][m];
        
        int setNum = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 0 || visited[i][j]) continue;
                bfs(setNum, i, j, land);
                setNum++;
            }
        }
        
        int[] columnVisited = new int[n * m + 1]; 
        for (int j = 0; j < m; j++) {
            int size = 0;
            Arrays.fill(columnVisited, 0);
            for (int i = 0; i < n; i++) {
                if (newLand[i][j] == 0) continue;
                if (columnVisited[newLand[i][j]] == 1) continue;
                size += groupSize[newLand[i][j]];
                columnVisited[newLand[i][j]] = 1;
            }
            if (answer < size) answer = size;
        }
        
        return answer;
    }

    private void bfs(int num, int startX, int startY, int[][] land) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[startX][startY] = true;
        newLand[startX][startY] = num;

        q.offerLast(new int[]{startX, startY});
        
        int cnt = 0;
        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            cnt++;
            for (int[] dir : dirs) {
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || land[nx][ny] == 0) continue;
                newLand[nx][ny] = num;
                visited[nx][ny] = true;
                q.offerLast(new int[]{nx, ny});
            }
        }
        
        groupSize[num] = cnt;
    }
}
