import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	static String answer;
	static int[][][] memo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		answer = br.readLine();
		memo = new int[N][M][answer.length()];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Arrays.fill(memo[i][j], -1);
			}
		}

		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == answer.charAt(0)) {
					res += dfs(1,i,j,map);
				}
			}
		}

		System.out.println(res);

	}

	private static int dfs(int cnt, int x, int y, char[][] map) {

		if (cnt == answer.length()) {
			return 1;
		}
		if (memo[x][y][cnt] != -1) return memo[x][y][cnt];

		memo[x][y][cnt] = 0;

		for (int i = 0; i < dirs.length; i++) {
			for (int j = 1; j <= K; j++) {
				int nx = x + dirs[i][0] * j;
				int ny = y + dirs[i][1] * j;

				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if (map[nx][ny] != answer.charAt(cnt)) continue;
				memo[x][y][cnt] += dfs(cnt + 1, nx, ny, map);
			}
		}

		return memo[x][y][cnt];
	}

}
