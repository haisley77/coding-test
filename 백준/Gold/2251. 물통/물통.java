import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashSet<Integer> set = new HashSet<>();
    static int[] volume;
    static boolean[][][] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        volume = new int[3];
        for (int i = 0; i < 3; i++) {
            volume[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[201][201][201];

        dfs(0,0,volume[2]);

        List<Integer> result = new ArrayList<>(set);
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append(" ");
        }
        System.out.println(sb);
    }
    private static void dfs(int a, int b, int c) {

        if (visited[a][b][c]) return;
        visited[a][b][c] = true;

        if (a == 0) set.add(c);

        play(a,b,c,0,1); // A -> B
        play(a,b,c,0,2); // A -> C
        play(a,b,c,1,0); // B -> A
        play(a,b,c,1,2); // B -> C
        play(a,b,c,2,0); // C -> A
        play(a,b,c,2,1); // C -> B
        
    }

    private static void play(int a, int b, int c, int from, int to) {
        int[] cur = {a,b,c};
        if (cur[from] == 0 || cur[to] == volume[to]) return;

        int amount = Math.min(cur[from], volume[to] - cur[to]);
        cur[from] -= amount;
        cur[to] += amount;

        dfs(cur[0],cur[1],cur[2]);
    }

}
