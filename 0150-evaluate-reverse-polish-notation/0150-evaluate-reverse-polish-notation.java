class Solution {

    private boolean isDigit(String s) {
        if (Objects.equals(s, "+") || Objects.equals(s, "-")
                || Objects.equals(s, "/") || Objects.equals(s, "*")) return false;
        return true;
    }

    private Integer evalExp(Integer a, Integer b, String exp) {
        if (Objects.equals(exp, "+")) return a + b;
        else if (Objects.equals(exp, "-")) return a - b;
        else if (Objects.equals(exp, "*")) return a * b;
        return a / b;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String s : tokens) {
            if (isDigit(s)) {
                st.push(Integer.parseInt(s));
            } else {
                Integer b = st.pop();
                Integer a = st.pop();
                st.push(evalExp(a, b, s));
            }
        }
        return st.peek();
    }
}