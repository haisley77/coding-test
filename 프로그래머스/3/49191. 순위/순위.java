import java.util.*;

class Solution {
    class Node {
        int v;
        Node next;
        Node(int v, Node next) {
            this.v = v;
            this.next = next;
        }
    }
    public int solution(int n, int[][] results) {
        int answer = 0;
        Node[] graph1 = new Node[n+1];
        Node[] graph2 = new Node[n+1];
        for (int i = 0; i < results.length; i++) {
            graph1[results[i][0]] = new Node(results[i][1], graph1[results[i][0]]); 
            graph2[results[i][1]] = new Node(results[i][0], graph2[results[i][1]]);
        }
         
        for (int i = 1; i < n+1; i++) {
            int tmp = 0;
            tmp += bfs(graph1, n, i);
            tmp += bfs(graph2, n, i);
            if (tmp == n-1) answer++;
        }
        
        return answer;
    }
    
    private int bfs(Node[] graph, int n, int s) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        visited[s] = true;
        q.offer(s);
        
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            cnt++;
            
            for (Node node = graph[cur]; node != null; node = node.next) {
                if (visited[node.v]) continue;
                visited[node.v] = true;
                q.offer(node.v);
            }
        }
        return cnt-1;
    }
}