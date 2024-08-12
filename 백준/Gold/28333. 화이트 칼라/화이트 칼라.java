import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class City {
        int v;
        City next;

        City(int v, City next) {
            this.v = v;
            this.next = next;
        }
    }

    static class Node {
        int v;
        int dist;
        Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
    }

    static int min = Integer.MAX_VALUE;
    static int[] visited1, visited2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            City[] graph = new City[N + 1];
            City[] reverseGraph = new City[N + 1];  // 그래프를 역방향으로 저장
            visited1 = new int[N+1];
            visited2 = new int[N+1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a] = new City(b, graph[a]);
                reverseGraph[b] = new City(a, reverseGraph[b]);
            }

            bfs(1, N, graph, visited1);
            bfs(N, N, reverseGraph, visited2);

            for (int i = 1; i <= N; i++) {
                if (i != 1 && i != N && (visited1[i] == 0 || visited2[i] == 0)) continue;
                if (visited1[i] + visited2[i] - 1 == visited1[N]) {
                    sb.append(i).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static void bfs(int s, int N, City[] graph, int[] visited) {
        Queue<Node> q = new LinkedList<>();
        visited[s] = 1;
        q.offer(new Node(s, visited[s]));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (City city = graph[cur.v]; city != null; city = city.next) {
                if (visited[city.v] != 0) continue;
                visited[city.v] = visited[cur.v] + 1;
                q.offer(new Node(city.v, visited[city.v]));
            }
        }

    }
}
