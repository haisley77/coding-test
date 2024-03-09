import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int M, N;
	private static final int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	private static boolean[][] arr;
	private static ArrayList<Integer> res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		res = new ArrayList<>();
		arr = new boolean[M][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			for (int y = sy; y < ey; y++) {
				for (int x = sx; x < ex; x++) {
					arr[y][x] = true;
				}
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j]) continue;
				bfs(i,j);
			}
		}
		Collections.sort(res);
		sb.append(res.size()).append("\n");
		for (int num : res) {
			sb.append(num).append(" ");
		}
		System.out.println(sb);
	}
	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{x,y});
		arr[x][y] = true;
		int size = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			size++;
			for (int i = 0; i < 4; i++) {
				int px = cur[0] + dirs[i][0];
				int py = cur[1] + dirs[i][1];
				if (px < 0 || px >= M || py < 0 || py >= N || arr[px][py]) continue;
				arr[px][py] = true;
				q.offer(new int[] {px,py});
			}
		}
		res.add(size);
	}
}
