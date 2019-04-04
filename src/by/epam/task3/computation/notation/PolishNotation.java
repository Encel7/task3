package by.epam.task3.computation.notation;

import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolishNotation {

    private HashMap<String, Integer> priorities;

    public PolishNotation() {
        priorities = new HashMap<>();
        priorities.put("(", 0);
        priorities.put(")", -1);
        priorities.put("~", 4);
        priorities.put(">>", 3);
        priorities.put(">>>", 3);
        priorities.put("<<", 3);
        priorities.put("&", 2);
        priorities.put("|", 2);
        priorities.put("^", 1);
    }

    private static final String NUMBER = "[0-9]+";

    private static final String OPERATOR = "[<>~|&^]+";

    public String addWhiteSpaces(final String expression) {
        String[] tokens = expression.split("");
        Pattern pattern = Pattern.compile(NUMBER);
        Pattern pattern1 = Pattern.compile(OPERATOR);
        Matcher matcher;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tokens.length; i++) {
            matcher = pattern.matcher(tokens[i]);
            if (matcher.find() && i < tokens.length - 1) {
                Matcher matcher1 = pattern.matcher(tokens[i + 1]);
                if (matcher1.find()) {
                    stringBuilder.append(matcher.group());
                } else {
                    stringBuilder.append(matcher.group()).append(" ");
                }
            } else {
                matcher = pattern1.matcher(tokens[i]);
                if (matcher.find() && i < tokens.length - 1) {
                    Matcher matcher1 = pattern1.matcher(tokens[i + 1]);
                    if (matcher1.find()) {
                        stringBuilder.append(matcher.group());
                    } else {
                        stringBuilder.append(matcher.group()).append(" ");
                    }
                } else {
                    stringBuilder.append(tokens[i]).append(" ");
                }
            }
        }
        return stringBuilder.toString();
    }

    public String makeNotationString(final String expression) {
        Stack<String> bufferStack = new Stack<>();
        StringBuilder notationString = new StringBuilder();
        String[] tokens = addWhiteSpaces(expression).split(" ");
        Pattern pattern = Pattern.compile(NUMBER);

        for (int i = 0; i < tokens.length; i++) {
            Matcher matcher = pattern.matcher(tokens[i]);
            if (matcher.find()) {
                notationString.append(tokens[i]).append(" ");
            } else {
                 if (priorities.get(tokens[i]) == 0) {
                    bufferStack.push(tokens[i]);
                }
                if (priorities.get(tokens[i]) > 0) {
                    while (!bufferStack.empty()) {
                        if (priorities.get(bufferStack.peek())
                                >=
                                priorities.get(tokens[i])) {
                            notationString.append(bufferStack.pop()).
                                    append(" ");
                        } else {
                            break;
                        }
                    }
                    bufferStack.push(tokens[i]);
                }
                if (priorities.get(tokens[i]) == -1) {
                    while (priorities.get(bufferStack.peek()) != 0) {
                        notationString.append(bufferStack.pop()).append(" ");
                    }
                    bufferStack.pop();
                }
            }
        }
        while (!bufferStack.empty()) {
            notationString.append(bufferStack.pop()).append(" ");
        }
        return notationString.toString();
    }


}
