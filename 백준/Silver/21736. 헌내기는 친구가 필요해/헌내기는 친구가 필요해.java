import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	static char[][] map;
	static int res, x, y, N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if (s.contains("I")) {
				x = i;
				y = s.indexOf("I");
			}
			map[i] = s.toCharArray();;
		}
		bfs();
		System.out.println(res == 0 ? "TT" : res);
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{x,y});
		map[x][y] = ' ';
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int px = cur[0] + dirs[i][0];
				int py = cur[1] + dirs[i][1];
				if (px < 0 || px >= N || py < 0 || py >= M) continue;
				if (map[px][py] == ' ') continue;
				if (map[px][py] == 'X') continue;
				if (map[px][py] == 'P') res++;
				map[px][py] = ' ';
				q.offer(new int[]{px,py});
			}
		}
	}
}
