import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static HashMap<String, Integer> map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			 map = new HashMap<>();
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine()," ");
				String a = st.nextToken();
				String b = st.nextToken();
				if (map.containsKey(b)) map.replace(b, map.get(b) + 1);
				else map.put(b, 1);
			}
			int c = countCase();
			sb.append(c).append("\n");
		}
		System.out.println(sb);

	}
	private static int countCase() {
		Set<String> set = map.keySet();
		int res = 1;
		for (String s : set) {
			res *= (map.get(s) + 1);
		}
		return res -1;
	}
}
