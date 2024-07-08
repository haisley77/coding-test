import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    private static int N, C, res;
    private static class Edge implements Comparable<Edge>{
        int p1;
        int p2;
        int c;

        Edge(int p1, int p2, int c){
            this.p1 = p1;
            this.p2 = p2;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.c, o.c);
        }
    }
    private static class Point {
        int index;
        int x;
        int y;
        Point(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }
    }
    private static Point[] graph;
    private static int[] selected;
    private static int[] parent;
    private static ArrayList<Edge> edgeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new Point[N];
        selected = new int[2];
        parent = new int[N];
        edgeList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            parent[i] = i;
         }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[i] = new Point(i,x,y);
        }
        combination(0,0);
        Collections.sort(edgeList);

        if (edgeList.size() >= N-1) getMinCost();
        else res = -1;
        System.out.println(res);
    }

    private static void getMinCost() {
        int vCnt = 0;
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            if (find(edge.p1) == find(edge.p2)) continue;
            union(edge.p1, edge.p2);
            res += edge.c;
            vCnt++;
            if (vCnt == N-1) return;
        }
        res = -1;
    }

    private static void combination(int start, int cnt) {
        if (cnt == 2) {
            int dist = getDist(graph[selected[0]], graph[selected[1]]);
            if (dist < C) return;
            Edge edge = new Edge(selected[0], selected[1], dist);
            edgeList.add(edge);
            return;
        }

        for (int i = start; i < N; i++) {
            selected[cnt] = i;
            combination(i+1,cnt+1);
        }
    }

    private static int getDist(Point p1, Point p2) {
        int a = p1.x - p2.x;
        int b = p1.y - p2.y;
        return a * a + b * b;
    }

    private static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parent[b] = a;
        }
        if (b < a) {
            parent[a] = b;
        }
    }

}
