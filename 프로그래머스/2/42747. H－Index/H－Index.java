import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        int hIndex = 0;
        Arrays.sort(citations);
        for (int i = 0; i < n; i++){
            int h = n - i;
            if (citations[i] >= h) {
                hIndex = h;
                break;
            }
        }
        return hIndex;
    }
}