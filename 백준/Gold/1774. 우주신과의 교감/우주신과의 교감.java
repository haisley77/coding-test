import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static Point[] points, selected;
    static ArrayList<Edge> graph;
    static int[] parent;
    static int N, M;
    static double res;
    static class Point {
        int num;
        int x;
        int y;
        Point(int x, int y, int num){
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
    static class Edge {
        Point p1;
        Point p2;
        double w;
        Edge(Point p1, Point p2, double w) {
            this.p1 = p1;
            this.p2 = p2;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        points = new Point[N+1];
        graph = new ArrayList<>();
        selected = new Point[2];
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x,y,i);
        }
        makeGraph(1,0);
        Collections.sort(graph, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Double.compare(o1.w, o2.w);
            }
        });
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            union(p1,p2);
        }
        kruskal();
        System.out.println(String.format("%.2f",res));
    }

    private static void kruskal() {
        for (int i = 0; i < graph.size(); i++) {
            Edge edge = graph.get(i);
            if (find(edge.p1.num) == find(edge.p2.num)) continue;
            res += edge.w;
            union(edge.p1.num, edge.p2.num);
        }
    }

    private static void makeGraph(int start, int cnt) {
        if (cnt == 2) {
            graph.add(new Edge(selected[0], selected[1], getDist(selected[0],selected[1])));
            return;
        }

        for (int i = start; i <= N; i++) {
            selected[cnt] = points[i];
            makeGraph(i+1,cnt+1);
        }
    }

    private static double getDist(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x-p2.x,2) + Math.pow(p1.y-p2.y,2));
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) parent[b] = a;
        if (a > b) parent[a] = b;
    }

    private static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}
