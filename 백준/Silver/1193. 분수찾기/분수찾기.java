import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        int n = 1;
        while (true) {
            int sum = n * (n + 1) / 2;
            if (sum >= a) {
                int diff = sum - a;
                if (n % 2 == 0) {
                    System.out.println((n-diff)+"/"+(diff+1));
                } else {
                    System.out.println((diff+1)+"/"+(n-diff));
                }
                break;
            }
            n++;
        }
    }
}
