import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int index;
        int s1;
        int s2;
        Node(int index, int s1, int s2) {
            this.index = index;
            this.s1 = s1;
            this.s2 = s2;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Node> graph = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s1 = Integer.parseInt(st.nextToken());
                int s2 = Integer.parseInt(st.nextToken());
                graph.add(new Node(i,s1,s2));

            }
            Collections.sort(graph, Comparator.comparingInt(o -> o.s2));
            int standard = graph.get(0).s1;
            int total = 1;
            for (int j = 1; j < N; j++) {
                Node cur = graph.get(j);
                if (cur.s1 < standard) {
                    total++;
                    standard = cur.s1;
                }
            }
            sb.append(total).append("\n");
        }
        System.out.println(sb);
    }

}
