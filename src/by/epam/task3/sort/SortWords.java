package by.epam.task3.sort;

import by.epam.task3.components.Component;
import by.epam.task3.type.TypeOfComponent;

import java.util.Comparator;
import java.util.List;

public class SortWords {

    private static final Comparator<Component> COMPARATOR =
            Comparator.comparingInt(o -> takeWord(o).getComponents().size());

    private static Component takeWord(final Component cmp) {
        for (Component component : cmp.getComponents()) {
            if (component.getType() == TypeOfComponent.WORD) {
                return component;
            }
        }
        return cmp;
    }

    public List<Component> sortWordsByLength(final Component root) {
        ComponentsReceiver componentsReceiver = new ComponentsReceiver();
        componentsReceiver.receiveComponents(root, TypeOfComponent.SENTENCE);
        List<Component> componentList;
        componentList = componentsReceiver.getComponentList();
        for (Component component : componentList) {
            component.getComponents().sort(COMPARATOR);
        }


        return componentList;
    }
}
