import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    private static class Player implements Comparable<Player> {
        int index;
        int type;
        Player(int index, int type) {
            this.index = index;
            this.type = type;
        }

        @Override
        public int compareTo(Player p) {
            return Integer.compare(this.type, p.type);
        }
    }

    private static class Node {
        int player;
        int status;

        Node(int player, int status) {
            this.player = player;
            this.status = status;
        }
    }
    private static int N, res;
    private static boolean[] selected;
    private static int[] order;
    private static int[][] innings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        innings = new int[N][9];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                innings[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        order = new int[9];
        selected = new boolean[9];
        selected[0] = true;     // 0번 선수 순서 이미 결정 됨
        order[3] = 0;

        makeOrder(0);
        System.out.println(res);

    }

    private static void makeOrder(int cnt) {
        if (cnt == 9) {
            res = Math.max(res, playGame());
            return;
        }
        if (cnt == 3) {
            makeOrder(cnt+1);
            return;
        }

        for (int i = 1; i < 9; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            order[cnt] = i;
            makeOrder(cnt+1);
            selected[i] = false;
        }
    }
    private static int playGame() {
        int hitter = 0;
        int score = 0;


        for (int inn = 0; inn < N; inn++) {
            int out = 0;
            boolean[] bases = new boolean[3];

            while (out < 3) {
                int canMove = innings[inn][order[hitter]];
                if (canMove == 0) {
                    out++;
                } else if (canMove == 1) {
                    score += bases[2] ? 1 : 0;
                    bases[2] = bases[1];
                    bases[1] = bases[0];
                    bases[0] = true;
                } else if (canMove == 2) {
                    score += bases[2] ? 1 : 0;
                    score += bases[1] ? 1 : 0;
                    bases[2] = bases[0];
                    bases[1] = true;
                    bases[0] = false;
                } else if (canMove == 3) {
                    score += bases[2] ? 1 : 0;
                    score += bases[1] ? 1 : 0;
                    score += bases[0] ? 1 : 0;
                    bases[2] = true;
                    bases[1] = false;
                    bases[0] = false;
                } else {
                    score += bases[2] ? 1 : 0;
                    score += bases[1] ? 1 : 0;
                    score += bases[0] ? 1 : 0;
                    score += 1;
                    Arrays.fill(bases, false);
                }
                hitter = (hitter + 1) % 9;
            }
        }

        return score;
    }

}
