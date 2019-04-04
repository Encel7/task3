 package by.epam.task3.sort;

import by.epam.task3.components.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

 public class SortParagraphs {
     private static final Comparator<Component> COMPARATOR =
             Comparator.comparingInt(o -> o.getComponents().size());

     public List<Component> sortParagraphsBySentences(final Component root) {
        List<Component> componentList = new ArrayList<>(root.getComponents());
        componentList.sort(COMPARATOR);
        return componentList;
     }
}
