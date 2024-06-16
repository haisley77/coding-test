import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        int num = 1;
        int size = 1;
        arr[N/2][N/2] = num++;
        int ansi = N/2;
        int ansj = N/2;

        while (size <= N / 2) {
            for (int i = N/2-size+1; i <= N/2+size; i++) {
                if (num == M) {
                    ansi = N/2-size;
                    ansj = i;
                }
                arr[N/2-size][i] = num++;
            }
            for (int i = N/2-size+1; i <= N/2+size; i++){
                if (num == M) {
                    ansi = i;
                    ansj = N/2+size;
                }
                arr[i][N/2+size] = num++;
            }
            for (int i = N/2+size-1; i >= N/2-size; i--) {
                if (num == M) {
                    ansi = N/2+size;
                    ansj = i;
                }
                arr[N/2+size][i] = num++;
            }
            for (int i = N/2+size-1; i >= N/2-size; i--) {
                if (num == M) {
                    ansi = i;
                    ansj = N/2-size;
                }
                arr[i][N/2-size] = num++;
            }
            size++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(ansi+1).append(" ").append(ansj+1);
        System.out.println(sb);
    }
}
