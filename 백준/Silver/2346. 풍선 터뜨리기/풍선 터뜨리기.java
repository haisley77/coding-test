import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayDeque<int[]> ad = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for (int i = 1; i <= N; i++) {
            ad.offerLast(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        while (!ad.isEmpty()) {
            int[] cur = ad.pollFirst();
            int curIndex = cur[0];
            int curPaper = cur[1];
            sb.append(curIndex).append(" ");

            if (ad.isEmpty()) break;

            int step = curPaper;
            if (step < 0) {
                step *= -1;
                for (int i = 0; i < step; i++) {
                    ad.addFirst(ad.pollLast());
                }
            } else {
                for (int i = 0; i < step-1; i++) {
                    ad.addLast(ad.pollFirst());
                }
            }
        }
        System.out.println(sb);
    }
}
