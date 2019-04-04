package by.epam.task3.computation.calculation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringCalculator {

    private static final String NUMBER = "[0-9]+";

    private static final Logger LOGGER = LogManager.getLogger("print");

    private boolean isNumber(final String str) {
        Pattern pattern = Pattern.compile(NUMBER);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    public double makeCalculations(final String notatedExpression) {
        StringBuilder operand = new StringBuilder();
        String[] tokens = notatedExpression.split(" ");
        Deque<Integer> stack =  new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            if (isNumber(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                switch (tokens[i]) {
                    case ">>":
                        RightShift rightShift = new RightShift();
                        stack.push(rightShift.makeRightShift(stack.pop(),
                                stack.pop()));
                        break;
                    case "<<":
                        LeftShift leftShift = new LeftShift();
                        stack.push(leftShift.makeLeftShift(stack.pop(),
                                stack.pop()));
                        break;
                    case "|":
                        Or or = new Or();
                        stack.push(or.makeOrOperation(stack.pop(),
                                stack.pop()));
                        break;
                    case "&":
                        And and = new And();
                        stack.push(and.makeAndOperation(stack.pop(),
                                stack.pop()));
                        break;
                    case "^":
                        XOR xor = new XOR();
                        stack.push(xor.makeXOR(stack.pop(),
                                stack.pop()));
                        break;
                    case ">>>":
                        LogicRightShift logicRightShift = new LogicRightShift();
                        stack.push(logicRightShift.
                                makeLogicRightShift(stack.pop(),
                                stack.pop()));
                        break;
                    case "~":
                        Negation negation = new Negation();
                        stack.push(negation.makeNegation(stack.pop()));
                        break;
                    default:
                        LOGGER.error("not logic operand");
                }
            }
        }
        return stack.pop();
    }
}
