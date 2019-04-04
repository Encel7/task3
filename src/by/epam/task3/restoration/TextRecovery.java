package by.epam.task3.restoration;

import by.epam.task3.components.Component;
import by.epam.task3.components.Leaf;
import by.epam.task3.type.TypeOfComponent;

public class TextRecovery {

    public String recovery(final Component cmp) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : cmp.getComponents()) {
            switch (component.getType()) {
                case PARAGRAPH:
                    stringBuilder.append("    ".concat(recovery(component).concat("\n")));
                    break;
                case SENTENCE:
                    stringBuilder.append(recovery(component));
                    break;
                case LEXEME:
                    stringBuilder.append(recovery(component));
                    break;
                case WORD:
                    if (cmp.getComponents().indexOf(component) + 1
                                            <
                                            cmp.getComponents().size()
                            &&
                            cmp.getComponents().get(cmp.getComponents().
                                    indexOf(component) + 1).getType()
                                    ==
                                    TypeOfComponent.SYMBOL) {
                        stringBuilder.append(recovery(component));
                        break;
                    } else {
                        stringBuilder.append(recovery(component).concat(" "));
                        break;
                    }
                case SYMBOL:
                    if (cmp.getComponents().size() == 1 && cmp.getType() != TypeOfComponent.WORD) {
                        Leaf leaf = (Leaf) component;
                        stringBuilder.append(leaf.getMinimalComponent()
                                .concat(" "));
                        break;
                    }
                    if (cmp.getComponents().indexOf(component) - 1 >= 0
                            &&
                            cmp.getType() == TypeOfComponent.LEXEME) {
                        Leaf leaf = (Leaf) component;
                        stringBuilder.append(leaf.getMinimalComponent()
                                .concat(" "));
                        break;
                    } else {
                        Leaf leaf = (Leaf) component;
                        stringBuilder.append(leaf.getMinimalComponent());
                        break;
                    }
                default:
                    System.out.println("incorrect type of component");
            }
        }
        return stringBuilder.toString();
    }
}
