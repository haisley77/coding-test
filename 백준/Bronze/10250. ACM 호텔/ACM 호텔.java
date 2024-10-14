import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            if (H == 1) {
                int floor = H;
                int room = N;
                if (room < 10) {
                    sb.append(floor).append("0").append(room).append("\n");
                } else {
                    sb.append(floor).append(room).append("\n");
                }
            } else {
                int floor = 0, room = 0;
                if (N % H == 0) {
                    floor = (N-1)%H+1;
                    room = (N-1)/H+1;
                } else {
                    floor = N % H;
                    room = N / H + 1;
                }
                if (room < 10) {
                    sb.append(floor).append("0").append(room).append("\n");
                } else {
                    sb.append(floor).append(room).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
