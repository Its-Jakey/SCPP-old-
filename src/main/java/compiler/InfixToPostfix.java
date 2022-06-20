package compiler;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixToPostfix {
    private static int precedence(ValueOrOperatorOrID op){
        if (op.operator() == null)
            return -1;
        String x = op.operator();

        return switch (x) {
            case "^", "|", "&", "==", "!=", "<", ">", ">=", "<=" -> 2;
            case "*", "/", "%" -> 1;
            case "+", "-", "<<", ">>", "&&", "||" -> 0;
            default -> -1;
        };
    }

    public static List<ValueOrOperatorOrID> infixToPostfix(List<ValueOrOperatorOrID> input){
        Stack<ValueOrOperatorOrID> stk = new Stack<>();
        List<ValueOrOperatorOrID> ret = new ArrayList<>();

        for (ValueOrOperatorOrID x : input) {
            if (x.value() == null && x.operator() == null)
                continue;

            if (x.value() != null)
                ret.add(x);
            else if (x.operator().equals("("))
                stk.push(x);
            else if (x.operator().equals(")")) {

                while (!stk.isEmpty() && stk.peek().operator() != null && !stk.peek().operator().equals("("))
                    ret.add(stk.pop());
                if (!stk.isEmpty())
                    stk.pop();
            } else {
                while (!stk.isEmpty() && precedence(stk.peek()) >= precedence(x))
                    ret.add(stk.pop());
                stk.push(x);
            }
        }
        while(!stk.isEmpty())
            ret.add(stk.pop());
        return ret;
    }
}
