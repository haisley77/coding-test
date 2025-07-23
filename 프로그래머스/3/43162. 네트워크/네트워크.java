import java.util.*;

class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            bfs(i, computers, n);
            answer++;
        }
        return answer;
    }
    
    private void bfs(int s, int[][] computers, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited[s] = true;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for (int i = 0; i < n; i++) {
                if (computers[cur][i] == 0) continue;
                if (visited[i]) continue;
                
                visited[i] = true;
                q.offer(i);
            }
        } 
    }
}