import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        arr = new int[number.length()];

        boolean hasZero = false;
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            arr[i] = number.charAt(i) - '0';
            sum += arr[i];
            if (arr[i] == 0) hasZero = true;
        }

        if (sum % 3 != 0 || !hasZero) {
            System.out.println(-1);
        } else {
            Arrays.sort(arr);
            StringBuilder sb = new StringBuilder();
            for (int i = arr.length - 1; i >= 0; i--) sb.append(arr[i]);
            System.out.println(sb);
        }

    }

}
