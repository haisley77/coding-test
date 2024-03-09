import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	private static int res;
	private static int[][] map;
	private static int n, m, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) continue;
				cnt++;
				bfs(i,j);
			}
		}
		System.out.println(cnt);
		System.out.println(res);
	}
	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x,y});
		map[x][y] = 0;
		int width = 1;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int i = 0; i < 4; i++) {
				int px = curr[0] + dirs[i][0];
				int py = curr[1] + dirs[i][1];
				if (px < 0 || px >= n || py < 0 || py >= m || map[px][py] == 0) continue;
				width += 1;
				q.offer(new int[] {px,py});
				map[px][py] = 0;
			}
		}
		if (res < width) res = width;
	}
}
