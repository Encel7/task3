package by.epam.task3.components;

import by.epam.task3.parser.ParserCaller;
import by.epam.task3.type.TypeOfComponent;

import java.util.List;


public class Composite implements Component {

    private List<Component> components;

    private TypeOfComponent type;

    public Composite(final String text, final TypeOfComponent typeNew) {
        this.type = typeNew;
        ParserCaller parserCaller = new ParserCaller();
        this.components = parserCaller.callSpecificParser(text, type);
    }


    @Override
    public List<Component> getComponents() {
        return components;
    }

    @Override
    public TypeOfComponent getType() {
        return type;
    }
}
