import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j < N - 1) swapAndFindMax(arr, i, j, i, j + 1);
                if (i < N - 1) swapAndFindMax(arr, i, j, i + 1, j);
            }
        }

        System.out.println(res);

    }

    private static void swapAndFindMax(char[][] arr, int x1, int y1, int x2, int y2) {
        char temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;

        countMaxCandies(arr);

        temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    private static void countMaxCandies(char[][] arr) {

        for (int i = 0; i < N; i++) {
            int maxR = 1;
            int maxC = 1;

            for (int j = 1; j < N; j++) {
                if (arr[i][j - 1] == arr[i][j]) { // i행
                    maxR++;
                } else {
                    res = Integer.max(res, maxR);
                    maxR = 1;
                }

                if (arr[j][i] == arr[j - 1][i]) { // i열
                    maxC++;
                } else {
                    res = Integer.max(res, maxC);
                    maxC = 1;
                }
            }

            res = Integer.max(res, maxR);
            res = Integer.max(res, maxC);
        }

    }

}
