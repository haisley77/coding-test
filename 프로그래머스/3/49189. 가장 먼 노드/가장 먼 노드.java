import java.util.*;
class Node {
    int v;
    Node next;
    Node(int v, Node next) {
        this.v = v;
        this.next = next;
    }
}
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        Node[] graph = new Node[n+1];
        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            graph[a] = new Node(b,graph[a]);
            graph[b] = new Node(a,graph[b]);
        }
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n+1];
        visited[1] = 1;
        q.offer(1);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (Node node = graph[cur]; node != null; node = node.next) {
                if (visited[node.v] > 0) continue;
                visited[node.v] = visited[cur] + 1;
                q.offer(node.v);
            }
        }
        
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (max < visited[i]) max = visited[i];
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i] == max) answer++;
        }
        return answer;
    }
}