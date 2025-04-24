import java.util.*;

class Solution {
    class Edge {
        int v;
        Edge next;
        Edge(int v, Edge next) {
            this.v = v;
            this.next = next;
        } 
    }
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        Edge[] graph = new Edge[n+1];
        for (int i = 0; i < wires.length; i++) {
            int[] cur = wires[i];
            graph[cur[0]] = new Edge(cur[1],graph[cur[0]]);
            graph[cur[1]] = new Edge(cur[0],graph[cur[1]]);
        }
        
        for (int i = 0; i < wires.length; i++) {
            int cnt1 = bfs(n, wires[i][0], wires[i][1], graph);
            
            int cnt2 = n - cnt1;
            
            if (Math.abs(cnt1 - cnt2) < answer) answer = Math.abs(cnt1 - cnt2);
        }
        
        
        return answer;
    }
    
    private int bfs(int n, int v1, int v2, Edge[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.offer(1);
        visited[1] = true;
        
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            cnt++;
            for (Edge edge = graph[cur]; edge != null; edge = edge.next) {
                if (cur == v1 && edge.v == v2) continue;
                if (cur == v2 && edge.v == v1) continue;
                
                if (visited[edge.v]) continue;
                visited[edge.v] = true;
                q.offer(edge.v);
            }
        }
        
        return cnt;
        
    }
}