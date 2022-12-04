public class Solution {
    private static double multiple(double number, int n) {
        double ans = 1.0;
        for (int i = 1; i <= n; i++) {
            ans = ans * number;
        }
        return ans;
    }

    private static void getNthRoot(int n, int m) {
        double low = 1;
        double high = m;
        double eps = 1e-7;
        while (high - low > eps) {
            double mid = (low + high) / 2;
            if (multiple(mid, n) < m) {
                low = mid;
            } else {
                high = mid;
            }
        }

        System.out.println(n + "th root of" + m + "is" + low);

    }

}
