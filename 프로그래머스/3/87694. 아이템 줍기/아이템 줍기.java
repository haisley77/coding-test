import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map = new int[101][101];
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 0; j < 4; j++) {
                rectangle[i][j] *= 2;
            }
            for (int j = rectangle[i][1]; j <= rectangle[i][3]; j++) {
                for (int k = rectangle[i][0]; k <= rectangle[i][2]; k++) {
                    if (j == rectangle[i][1] || j == rectangle[i][3] || k == rectangle[i][0] || k == rectangle[i][2]) {
                        if (map[j][k] != -1) map[j][k] = 1; // 테두리가 다른 직사각형에 포함되지 않으면
                        else map[j][k] = -1;
                    } else {
                        map[j][k] = -1; // 다른 직사각형 테두리는 현재 직사각형 내부로 표현 가능
                    }
                }
            }
        }
        answer = bfs(characterY*2, characterX*2, itemY*2, itemX*2, map);
        return answer;
    }
    
    private int bfs(int sx, int sy, int ex, int ey, int[][] map) {
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int[][] visited = new int[map.length][map[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx,sy});
        visited[sx][sy] = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == ex && cur[1] == ey) {
                break;
            }
            for (int i = 0; i < dirs.length; i++) {
                int nx = cur[0] + dirs[i][0];
                int ny = cur[1] + dirs[i][1];
                if (nx < 2 || nx > 100 || ny < 2 || ny > 100 || visited[nx][ny] > 0) continue;
                if (map[nx][ny] == 1) {
                    visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        return visited[ex][ey]/2;
    }
}