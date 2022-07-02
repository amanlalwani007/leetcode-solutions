class Solution {
    public int myAtoi(String s) {

        int i = 0;
        int no = 0;
        boolean neg = false;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i < s.length() && s.charAt(i) == '-') {
            neg = true;
            i++;
        } else if (i < s.length() && s.charAt(i) == '+') {
            i++;
        }

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int c = s.charAt(i) - '0';
            if ((Integer.MAX_VALUE - c) / 10 < no) {
                if (neg) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            no = no * 10 + c;
            i++;

        }

        if (no == 0) {
            return 0;
        } else {
            if (neg) {
                return -no;
            } else {
                return no;
            }
        }

    }
}

//time  complexity :- o(n)