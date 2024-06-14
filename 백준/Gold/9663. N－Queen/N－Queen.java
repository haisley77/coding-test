import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int res, N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        setQueen(0);
        System.out.println(res);
    }
    private static void setQueen(int row) {
        if (row == N) {
            res++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[row] = i;
            if (possible(row)) setQueen(row + 1);
            
        }
    }

    private static boolean possible(int row) {
        for (int i = 0; i < row; i++) {
            if (arr[i] == arr[row]) return false;
            if (Math.abs(row - i) == Math.abs(arr[row] - arr[i])) return false;
        }
        return true;
    }
}
