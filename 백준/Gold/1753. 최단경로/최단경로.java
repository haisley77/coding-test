import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static class Edge {
		int vertex, weight;
		Edge next;
		Edge(int vertex, int weight, Edge next){
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(br.readLine());
		Edge[] graph = new Edge[V+1];
		int[] dist = new int[V+1];
		boolean[] visited = new boolean[V+1];
		Arrays.fill(dist, INF);
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u] = new Edge(v,w,graph[u]);			// 간선 추가
		}
		dist[S] = 0;	// 시작 정점 거리
		visited[S] = true;
		

		for (int t = 0; t < V; t++) {
			
			visited[S] = true;
			for (Edge temp = graph[S]; temp != null; temp = temp.next) {	// 인접정점 확인
				
				if (!visited[temp.vertex] && dist[temp.vertex] > (dist[S] + temp.weight)) {
					dist[temp.vertex] = dist[S] + temp.weight;		//갱신
				}
			}
			
			int min = Integer.MAX_VALUE;
			for (int i = 1; i < V+1; i++) {
				if (!visited[i] && min > dist[i]) {
					min = dist[i];
					S = i;	// 현재 정점 선택
				} 
			}
		}
			
		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF) {
				sb.append("INF").append("\n");
			} else {
				sb.append(dist[i]).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}