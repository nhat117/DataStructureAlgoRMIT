package W4;
//Convert Infix to postfix
public class StackApplication {
    static String infix2Postfix(String inp) {
        StringBuilder tmp = new StringBuilder();
        LinkedListStack <Character> operator = new LinkedListStack<>();
        for(int i = 0; i < inp.length(); i ++) {
            char c = inp.charAt(i);
            if (c == '(') {
                operator.push(c);
                continue;
            }
            if (c == ')') {
                char op;
                op = operator.peek();
                while (op != '(') {
                    tmp.append(op);
                    operator.pop();
                    op = operator.peek();
                }
                operator.pop();
                continue;
            }
            if (c == '*' || c == '/') {
                char op;
                if (!operator.isEmpty()) {
                    op = operator.peek();
                    while (op == '*' || op == '/') {
                        tmp.append(op);
                        operator.pop();
                        if (operator.isEmpty()) {
                            break;
                        }
                        op = operator.peek();
                    }
                }
                operator.push(c);
                continue;
            }
            if (c == '+' || c == '-') {
                char op;
                if (!operator.isEmpty()) {
                    op = operator.peek();
                    while (op != '(') {
                        tmp.append(op);
                        operator.pop();
                        if (operator.isEmpty()) {
                            break;
                        }
                        op = operator.peek();
                    }
                }
                operator.push(c);
                continue;
            }
            tmp.append(c);
        }
        while (!operator.isEmpty()) {
            char op = operator.peek();
            tmp.append(op);
            operator.pop();
        }
        return tmp.toString();
    }
    public static void main(String[] args) {
        System.out.println("a+b: " + infix2Postfix("a+b"));
        System.out.println("a+b*c: " + infix2Postfix("a+b*c"));
        System.out.println("a/b+c*d: " + infix2Postfix("a/b+c*d"));
        System.out.println("a*(b+c-(d+e)/f)*g: " + infix2Postfix("a*(b+c-(d+e)/f)*g"));
    }
}
