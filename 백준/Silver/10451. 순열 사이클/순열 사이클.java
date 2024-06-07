import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] graph;
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int res = 0;
            N = Integer.parseInt(br.readLine());
            graph = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 1; j <= N; j++) {
                graph[j] = Integer.parseInt(st.nextToken());
            }
            boolean[] visited = new boolean[N+1];
            for (int j = 1; j <= N; j++) {
                if (visited[j]) continue;
                res++;
                dfs(j, visited);
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
    private static void dfs(int v, boolean[] visited){
        if (visited[v]) return;
        visited[v] = true;
        dfs(graph[v], visited);
    }
}
