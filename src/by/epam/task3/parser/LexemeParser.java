package by.epam.task3.parser;

import by.epam.task3.components.Component;
import by.epam.task3.components.Composite;
import by.epam.task3.components.Leaf;
import by.epam.task3.computation.calculation.StringCalculator;
import by.epam.task3.computation.notation.PolishNotation;
import by.epam.task3.type.TypeOfComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class LexemeParser {

    private  static final String DIVIDE_BY_WORDS = "\\w+|[-]";

    private static final String PUNCTUATION_MARK = "([?!]{1,2}|([.]{3})|[.,])";

    private static final String MATH_EXPRESSION = "[~<>&|^()0-9]+";

    List<Component> parseData(final String text) {
        Pattern pattern = Pattern.compile(DIVIDE_BY_WORDS);
        Pattern pattern1 = Pattern.compile(PUNCTUATION_MARK);
        Pattern pattern2 = Pattern.compile(MATH_EXPRESSION);
        Matcher matcher = pattern.matcher(text);
        Matcher matcher1 = pattern1.matcher(text);
        Matcher matcher2 = pattern2.matcher(text);
        List<Component> componentList = new ArrayList<>();
        if (matcher2.find()) {
            PolishNotation polishNotation = new PolishNotation();
            StringCalculator stringCalculator = new StringCalculator();
            Leaf leaf = new Leaf(Integer.toString((int) stringCalculator.
                    makeCalculations(polishNotation.makeNotationString(matcher2.group()))),
                    TypeOfComponent.SYMBOL);
            componentList.add(leaf);
        } else {
            while (matcher.find()) {
                Component component = new Composite(matcher.group(),
                        TypeOfComponent.WORD);
                componentList.add(component);
            }
        }
        if (matcher1.find()) {
            Leaf leaf = new Leaf(matcher1.group(), TypeOfComponent.SYMBOL);
            componentList.add(leaf);
        }
        return componentList;
    }
}
