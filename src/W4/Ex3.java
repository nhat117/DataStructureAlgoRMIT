package W4;

import java.util.Stack;

public class Ex3 {

    public static void main(String[] args) {
        System.out.println(chkBalance("{}"));
    }

    public static boolean chkBalance(String str) {
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < str.length(); i ++) {
            if(str.charAt(i) =='(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                s.push(str.charAt(i));
            } else {
                if(s.isEmpty()) return false;
                char chk;
                switch (str.charAt(i)) {
                    case ')' :
                        chk = s.pop();
                        if(chk =='{' || chk == '[') return false;
                        break;
                    case ']' :
                        chk = s.pop();
                        if(chk =='{' || chk == '(') return false;
                        break;
                    case '}' :
                        chk = s.pop();
                        if(chk =='(' || chk == '[') return false;
                        break;
                }
            }
        }
        return s.isEmpty();
    }
}
