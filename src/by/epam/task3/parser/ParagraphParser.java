package by.epam.task3.parser;

import by.epam.task3.components.Component;
import by.epam.task3.components.Composite;
import by.epam.task3.type.TypeOfComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ParagraphParser {
    private  static final String DIVIDE_BY_SENTENCES =
            "[^.!?]*([!?]|\\.{3}|\\.)";

    List<Component> parseData(final String text) {
        Pattern pattern = Pattern.compile(DIVIDE_BY_SENTENCES);
        Matcher matcher = pattern.matcher(text);
        List<Component> componentList = new ArrayList<>();
        while (matcher.find()) {
            Component component = new Composite(matcher.group(),
                    TypeOfComponent.SENTENCE);
            componentList.add(component);
        }
        return componentList;
    }
}
