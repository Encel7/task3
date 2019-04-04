package by.epam.task3.sort;

import by.epam.task3.components.Component;
import by.epam.task3.components.Leaf;
import by.epam.task3.restoration.TextRecovery;
import by.epam.task3.type.TypeOfComponent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class SortLexemes {

    private String symbol;

    private final Comparator<Component> COMPARATOR =
            new Comparator<>() {
        @Override
        public int compare(final Component o1, final Component o2) {
            if (getNumberOfSymbolInLexeme(o1, symbol)
                    <
                    getNumberOfSymbolInLexeme(o2, symbol)) {
                return -1;
            }
            if (getNumberOfSymbolInLexeme(o1, symbol)
                    >
                    getNumberOfSymbolInLexeme(o2, symbol)) {
                return 1;
            } else {
                TextRecovery textRecovery = new TextRecovery();
                return textRecovery.recovery(o1).
                        compareTo(textRecovery.recovery(o2));
            }
        }
    };

    private int getNumberOfSymbolInLexeme(final Component lexeme,
                                          final String symbolNew) {
        int number = 0;
        ComponentsReceiver componentsReceiver = new ComponentsReceiver();
        componentsReceiver.receiveComponents(lexeme, TypeOfComponent.SYMBOL);
        List<Component> componentList = new ArrayList<>(componentsReceiver.
                getComponentList());
        for (Component component : componentList) {
            Leaf leaf = (Leaf) component;
            if (Objects.equals(leaf.getMinimalComponent(), symbolNew)) {
                number++;
            }
        }
        return number;
    }

    public List<Component> sortLexemesBySymbol(final Component root,
                                               final String symbolNew) {
        this.symbol = symbolNew;
        ComponentsReceiver componentsReceiver = new ComponentsReceiver();
        componentsReceiver.receiveComponents(root, TypeOfComponent.LEXEME);
        List<Component> componentList = new ArrayList<>(componentsReceiver.
                getComponentList());
        componentList.sort(COMPARATOR);
        return componentList;
    }
}
