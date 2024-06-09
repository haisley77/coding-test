import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        int num;
        double x;
        double y;
        Point(int num, double x, double y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
    static class Edge {
        Point p1;
        Point p2;
        double dist;
        Edge(Point p1, Point p2, double dist) {
            this.p1 = p1;
            this.p2 = p2;
            this.dist = dist;
        }
    }
    private static ArrayList<Point> points;
    private static ArrayList<Edge> graph;
    private static Point[] selected;
    private static boolean[] visited;
    private static int[] parent;
    private static double res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        points = new ArrayList<>();
        graph = new ArrayList<>();
        selected = new Point[2];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            points.add(new Point(i,x,y));
        }
        visited = new boolean[points.size()];

        makeGraph(0,0);
        Collections.sort(graph, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Double.compare(o1.dist, o2.dist);
            }
        });

        for (int i = 0; i < graph.size(); i++) {
            Edge edge = graph.get(i);
            if (find(edge.p1.num) == find(edge.p2.num)) continue;
            res += edge.dist;
            union(edge.p1.num, edge.p2.num);
        }

        System.out.println(res);
    }

    private static void makeGraph(int start, int cnt) {
        if (cnt == 2) {
            graph.add(new Edge(selected[0], selected[1], calcDist(selected[0], selected[1])));
            return;
        }
        for (int i = start; i < points.size(); i++) {
            Point point = points.get(i);
            visited[i] = true;
            selected[cnt] = point;
            makeGraph(start + 1, cnt + 1);
            visited[i] = false;
        }
    }

    private static double calcDist(Point p1, Point p2) {
        double tempX = Math.pow(p1.x - p2.x, 2);
        double tempY = Math.pow(p1.y - p2.y, 2);
        return Math.sqrt(tempX + tempY);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) parent[a] = b;
        if (a < b) parent[b] = a;
    }
    private static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}
