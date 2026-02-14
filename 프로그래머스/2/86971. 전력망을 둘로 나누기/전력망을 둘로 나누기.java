import java.util.*;

class Solution {
    class Node{
        int v;
        Node next;
        Node(int v, Node next) {
            this.v = v;
            this.next = next;
        }
    }
    public int solution(int n, int[][] wires) {
        int answer = n+1;
        Node[] graph = new Node[n+1];
        for (int i = 0; i < n-1; i++) {
            graph[wires[i][0]] = new Node(wires[i][1], graph[wires[i][0]]);
            graph[wires[i][1]] = new Node(wires[i][0], graph[wires[i][1]]);
        }
        for (int i = 0; i < n-1; i++) {
            int a = bfs(wires[i][0], wires[i][1], n, graph);
            int b = bfs(wires[i][1], wires[i][0], n, graph);
            if (Math.abs(a-b) < answer) answer = Math.abs(a-b);
        }
        return answer;
    }
    
    public int bfs(int s, int x, int n, Node[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        visited[s] = true;
        q.offer(s);
        
        int num = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            num++; 
            for (Node node = graph[cur]; node != null; node = node.next) {
                if (visited[node.v]) continue;
                if (node.v == x) continue;
                visited[node.v] = true;
                q.offer(node.v);
            }
        }
        return num;
    }
}