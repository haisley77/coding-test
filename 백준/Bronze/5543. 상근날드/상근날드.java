import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int burger = a;
        if (burger > b) burger = b;
        if (burger > c) burger = c;
        int d = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        int drink = d;
        if (drink > e) drink = e;
        System.out.println(burger + drink - 50);
    }
}
