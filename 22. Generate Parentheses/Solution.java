import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<String>();
        calculate(list, n, new StringBuilder(), 0, 0);
        return list ;

    }

    public void calculate(List<String> result, int n, StringBuilder str, int open, int close) {
        if (open == n && close == n) {
            result.add(str.toString());
            return;
        }

        if (open > close) {
            str.append(')');
            calculate(result, n, str, open, close + 1);
            str.deleteCharAt(str.length() - 1);
        }
        if (open < n) {
            str.append('(');
            calculate(result, n, str, open + 1, close);
            str.deleteCharAt(str.length() - 1);
        }

    }
}