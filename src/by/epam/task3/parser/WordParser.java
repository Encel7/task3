package by.epam.task3.parser;

import by.epam.task3.components.Component;
import by.epam.task3.components.Leaf;
import by.epam.task3.type.TypeOfComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class WordParser {

    private  static final String DIVIDE_BY_SYMBOLS = ".{1}";

    List<Component> parseData(final String text) {
        Pattern pattern = Pattern.compile(DIVIDE_BY_SYMBOLS);
        Matcher matcher = pattern.matcher(text);
        List<Component> componentList = new ArrayList<>();
        while (matcher.find()) {
            Component component = new Leaf(matcher.group(),
                    TypeOfComponent.SYMBOL);
            componentList.add(component);
        }
        return componentList;
    }
}
