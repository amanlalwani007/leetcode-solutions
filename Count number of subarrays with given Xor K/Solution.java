import java.util.HashMap;
import java.util.*;

class Solution {
    public int solve(int[] A, int B) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int cnt = 0;
        int xorr = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            xorr = xorr ^ A[i];
            if (freq.get(xorr ^ B) != null) {
                cnt += freq.get(xorr ^ B);
            }
            if (xorr == B)
                cnt++;
            if (freq.get(xorr) != null) {
                freq.put(xorr, freq.get(xorr) + 1);
            } else {
                freq.put(xorr, 1);
            }
        }

        return cnt;
    }
}