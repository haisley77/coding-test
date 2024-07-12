import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String command = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String tmpArr = br.readLine();

            ArrayDeque<Integer> ad = new ArrayDeque<>();
            if (tmpArr.length() != 2) {
                StringTokenizer st = new StringTokenizer(tmpArr.substring(1, tmpArr.length() - 1), ",");
                for (int i = 0; i < N; i++) {
                    ad.addLast(Integer.parseInt(st.nextToken()));
                }
            }
            int front = 0;
            boolean flag = true;
            for (int i = 0; i < command.length(); i++) {
                char cur = command.charAt(i);

                if (cur == 'R') {
                    front = (front + 1) % 2;
                }

                if (cur == 'D') {
                    if (ad.isEmpty()) {
                        sb.append("error").append("\n");
                        flag = false;
                        break;
                    }
                    if (front == 0) {
                        ad.pollFirst();
                    }
                    if (front == 1) {
                        ad.pollLast();
                    }
                }
            }

            if (!flag) continue;
            int size = ad.size();
            sb.append("[");
            if (front == 0) {
                for (int i = 0; i < size; i++) {
                    sb.append(ad.pollFirst());
                    if (i == size-1) break;
                    sb.append(",");
                }
            }
            if (front == 1) {
                for (int i = 0; i < size; i++) {
                    sb.append(ad.pollLast());
                    if (i == size-1) break;
                    sb.append(",");
                }
            }
            sb.append("]").append("\n");

        }

        System.out.println(sb);
    }

}
