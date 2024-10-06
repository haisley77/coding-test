import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();

        int max = 0;
        for (int i = 0; i < N; i++) {
            String book = br.readLine();
            hm.put(book, hm.getOrDefault(book, 0) + 1);
            max = Math.max(max, hm.get(book));
        }
        ArrayList<String> al = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            if (entry.getValue() == max) al.add(entry.getKey());
        }
        Collections.sort(al);
        System.out.println(al.get(0));
    }
}
