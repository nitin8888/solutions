package designpatterns.interpreter;

import java.util.ArrayDeque;
import java.util.Map;

public class Interpreter {
    @FunctionalInterface
    public interface Expr {
        int interpret(Map<String, Integer> context);

        static Expr number(int number) {
            return context -> number;
        }

        static Expr plus(Expr left, Expr right) {
            return context -> left.interpret(context) + right.interpret(context);
        }

        static Expr minus(Expr left, Expr right) {
            return context -> left.interpret(context) - right.interpret(context);
        }

        static Expr variable(String name) {
            return context -> context.getOrDefault(name, 0);
        }
    }

    private static Expr parseToken(String token, ArrayDeque<Expr> stack) {
        Expr left, right;
        switch(token) {
            case "+":
                // it's necessary to remove first the right operand from the stack
                right = stack.pop();
                // ..and then the left one
                left = stack.pop();
                return Expr.plus(left, right);
            case "-":
                right = stack.pop();
                left = stack.pop();
                return Expr.minus(left, right);
            default:
                return Expr.variable(token);
        }
    }
    public static Expr parse(String expression) {
        var stack = new ArrayDeque<Expr>();
        for (var token : expression.split(" ")) {
            stack.push(parseToken(token, stack));
        }
        return stack.pop();
    }

    public static void main(final String[] args) {
        var expr = parse("w x z - +");
        var context = Map.of("w", 5, "x", 10, "z", 42);
        var result = expr.interpret(context);
        System.out.println(result);    // -27
    }
}
