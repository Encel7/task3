package by.epam.task3.sort;

import by.epam.task3.components.Component;
import by.epam.task3.type.TypeOfComponent;

import java.util.ArrayList;
import java.util.List;

public class ComponentsReceiver {
    private List<Component> componentList = new ArrayList<>();

    public List<Component> getComponentList() {
        return componentList;
    }

    void receiveComponents(final Component root,final TypeOfComponent type) {
        if (root.getType() == type) {
            componentList.add(root);
        } else {
            for (Component cmp : root.getComponents()) {
                receiveComponents(cmp, type);
            }
        }
    }
}
