import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String name = br.readLine();
        int[] arr = new int[26];
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < name.length(); i++) {
            arr[name.charAt(i) - 'A'] += 1;
        }

        char c = 0;
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] % 2 != 0) {
                cnt++;
                c = (char) (i + 'A');
            }
            for (int j = 0; j < arr[i] / 2; j++) {
                list.add((char) (i + 'A'));
            }
        }
        if (cnt > 1) {
            sb.append("I'm Sorry Hansoo");
        } else {
            Collections.sort(list);
            int i;
            for (i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
            }
            if (cnt == 1) {
                sb.append(c);
            }
            for (i = list.size()-1; i >= 0; i--) {
                sb.append(list.get(i));
            }
        }

        System.out.println(sb);
    }
}
