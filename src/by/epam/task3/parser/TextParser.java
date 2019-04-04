package by.epam.task3.parser;

import by.epam.task3.components.Component;
import by.epam.task3.components.Composite;
import by.epam.task3.type.TypeOfComponent;

import java.util.ArrayList;
import java.util.List;
class TextParser {

    List<Component> parseData(final String text) {
        String divideByParagraphs = "[ ]{4}";
        String[] array = text.split(divideByParagraphs);

        List<Component> componentList = new ArrayList<>();
        for (int i = 1; i < array.length; i++) {
            Component component = new Composite(array[i],
                    TypeOfComponent.PARAGRAPH);
            componentList.add(component);
        }
        return componentList;
    }
}
