import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int star = N * 2 - 1;
        int gap = 0;
        for (int t = 0; t < N * 2 - 1; t++) {
            for (int i = 0; i < gap; i++) sb.append(" ");
            for (int i = 0; i < star - gap * 2; i++) sb.append("*");

            if (t < N-1) gap++;
            else gap--;

            sb.append("\n");
        }
        System.out.println(sb);
    }
}
