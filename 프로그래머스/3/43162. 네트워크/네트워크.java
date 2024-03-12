import java.util.*;

class Solution {
    static int answer = 0;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            bfs(computers, visited, i);
            answer++;
        }
        return answer;
    }
    private void bfs(int[][] computers, boolean[] visited, int s) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited[s] = true;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int i = 0; i < computers.length; i++) {
                if (visited[i]) continue;   // 이미 방문한 점은 건너뛰기
                if (computers[cur][i] == 1) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        
    }
    
}