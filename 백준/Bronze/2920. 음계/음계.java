import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean mixed = false;
        if (arr[0] < arr[1]) {
            for (int i = 2; i < 8; i++) {
                if (arr[i-1] > arr[i]) mixed = true;
            }
            if (mixed) System.out.println("mixed");
            else System.out.println("ascending");
        }
        if (arr[0] > arr[1]) {
            for (int i = 2; i < 8; i++) {
                if (arr[i-1] < arr[i]) mixed = true;
            }
            if (mixed) System.out.println("mixed");
            else System.out.println("descending");
        }
    }
}
