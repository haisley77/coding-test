import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[9];
        while (N > 0) {
            if (N % 10 == 9) arr[6]++;
            else arr[N % 10]++;
            N /= 10;
        }

        if (arr[6] % 2 == 0) {
            arr[6] /= 2;
        } else {
            arr[6] /= 2;
            arr[6]++;
        }
        
        int max = 1;
        for (int i = 0; i < 9; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);

    }
}
