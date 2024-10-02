import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static class Node {
        int type;
        int to;
        Node(int type, int to) {
            this.type = type;
            this.to = to;
        }
    }
    static Node[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new Node[101];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x] = new Node(1, y);
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u] = new Node(2, v);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[101];
        visited[1] = 1;
        q.offer(1);

        ww:
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int i = 1; i <= 6; i++) {
                int nx = cur + i;
                if (nx > 100) continue;

                if (graph[nx] != null) {
                    nx = graph[nx].to;
                }
                
                if (visited[nx] == 0) {
                    visited[nx] = visited[cur] + 1;
                    q.offer(nx);
                }
                
                if (nx == 100) {
                    System.out.println(visited[100] - 1);
                    break ww;
                }
            }
        }
    }
}
