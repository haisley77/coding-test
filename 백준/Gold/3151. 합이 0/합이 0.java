import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];
        long[] person = new long[20001];  // +10000
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            person[score[i]+10000]++;
        }

        long resCnt = 0L;
        for (int i = 0; i < 20001; i++) {
            if (i == 10000) {
                if (person[i] >= 3) {
                    resCnt += (person[i] * (person[i]-1) * (person[i]-2) / 6);
                }
            } else {
                if (person[i] == 0) continue;

                for (int j = i+1; j < 20001; j++) {
                    if (person[j] == 0) continue;

                    int res = (i - 10000) + (j - 10000);
                    int index = -res + 10000;

                    if ((index >= 0) && (index <= 20000) && (person[index] != 0)) {
                        if (index == i) {
                            if (person[i] >= 2) {
                                resCnt += (person[j] * (person[i] * (person[i]-1) / 2));
                            }
                        } else if (index == j) {
                            if (person[j] >= 2) {
                                resCnt += (person[i] * (person[j] * (person[j]-1) / 2));
                            }
                        } else {
                            if (index > j) {
                                resCnt += (person[i] * person[j] * person[index]);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(resCnt);
    }

}
