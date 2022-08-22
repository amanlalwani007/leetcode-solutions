import java.util.HashMap;
import java.util.*;

public class Solution {
    int maxLen(int A[], int n) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxi = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            if (sum == 0) {
                maxi = i + 1;
            } else {
                if (map.get(sum) != null) {
                    maxi = Math.max(maxi, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }
        return maxi;
    }

}
