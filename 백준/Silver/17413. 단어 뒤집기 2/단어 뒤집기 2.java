import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                arr1.add(i);
            }
            if (s.charAt(i) == '>'){
                arr2.add(i);
            }
        }

        int start = s.length() - 1;
        int end = 0;

        if (arr1.isEmpty()) {
            String sub = s.substring(end, start+1);
            StringTokenizer st = new StringTokenizer(sub," ");
            while (st.hasMoreTokens()) {
                sub = st.nextToken();
                start = sub.length() - 1;
                end = 0;
                while (start >= end) {
                    sb.append(sub.charAt(start--));
                }
                if (st.hasMoreTokens()) sb.append(" ");
            }
        } else {
            start = arr1.get(0) - 1;
            end = 0;

            String sub = s.substring(end, start+1);
            StringTokenizer st = new StringTokenizer(sub," ");
            while (st.hasMoreTokens()) {
                sub = st.nextToken();
                start = sub.length() - 1;
                end = 0;
                while (start >= end) {
                    sb.append(sub.charAt(start--));
                }
                if (st.hasMoreTokens()) sb.append(" ");
            }

            for (int i = 0; i < arr1.size(); i++){
                start = arr1.get(i);
                end = arr2.get(i);
                sb.append(s.substring(start,end+1));

                if (i != arr1.size()-1) {
                    start = arr1.get(i+1) - 1;
                    end = arr2.get(i) + 1;
                } else {
                    start = s.length() - 1;
                    end = arr2.get(i) + 1;
                }

                sub = s.substring(end, start+1);
                st = new StringTokenizer(sub," ");
                while (st.hasMoreTokens()) {
                    sub = st.nextToken();
                    start = sub.length() - 1;
                    end = 0;
                    while (start >= end) {
                        sb.append(sub.charAt(start--));
                    }
                    if (st.hasMoreTokens()) sb.append(" ");
                }
            }
        }
        System.out.println(sb);
    }
}
