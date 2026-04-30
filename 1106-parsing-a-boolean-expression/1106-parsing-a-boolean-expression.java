class Solution {
    int idx = 0;

    public boolean parseBoolExpr(String exp) {
        return solve(exp);
    }

    private boolean solve(String exp) {
        char ch = exp.charAt(idx++);

        if (ch == 't') return true;
        if (ch == 'f') return false;

        char op = ch;
        idx++; // skip '('

        List<Boolean> list = new ArrayList<>();

        while (exp.charAt(idx) != ')') {
            if (exp.charAt(idx) == ',') {
                idx++;
            } else {
                list.add(solve(exp));
            }
        }

        idx++; // skip ')'

        if (op == '!') return !list.get(0);

        if (op == '&') {
            for (boolean b : list)
                if (!b) return false;
            return true;
        }

        if (op == '|') {
            for (boolean b : list)
                if (b) return true;
            return false;
        }

        return false;
    }
}