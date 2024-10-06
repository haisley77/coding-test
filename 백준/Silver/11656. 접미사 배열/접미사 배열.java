import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        ArrayList<String> al = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            al.add(s.substring(i));
        }
        Collections.sort(al);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(al.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}
