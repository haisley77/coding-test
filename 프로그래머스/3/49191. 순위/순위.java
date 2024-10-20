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
        Node[] graph1 = new Node[n+1];  // win
        Node[] graph2 = new Node[n+1]; 
        for (int i = 0; i < results.length; i++) {
            int a = results[i][0];
            int b = results[i][1];
            // a가 b를 이김
            graph1[a] = new Node(b,graph1[a]);
            graph2[b] = new Node(a,graph2[b]);
        }
        
        for (int i = 1; i <= n; i++) {
            int cnt1 = bfs(i,n,graph1); // 이긴 사람 수
            int cnt2 = bfs(i,n,graph2); // 진 사람 수
            if (cnt1+cnt2 == n-1) answer++;
        }
        
        return answer;
    }
    
    int bfs(int s, int n, Node[] graph) {
        int cnt = 0;
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        visited[s] = true;
        q.offer(s);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            cnt++;
            for (Node node = graph[cur]; node != null; node = node.next) {
                if (visited[node.v]) continue;
                visited[node.v] = true;
                q.offer(node.v);
            }
        }
        
        return cnt - 1;
    }

}