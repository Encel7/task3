package by.epam.task3.components;

import by.epam.task3.type.TypeOfComponent;

import java.util.List;


public class Leaf implements Component {

    private TypeOfComponent type;

    private String minimalComponent;

    public Leaf(final String minimalComponentNew,
                final TypeOfComponent typeNew) {
        this.type = typeNew;
        this.minimalComponent = minimalComponentNew;
    }

    public String getMinimalComponent() {
        return minimalComponent;
    }

    @Override
    public List<Component> getComponents() {
        return null;
    }

    @Override
    public TypeOfComponent getType() {
        return type;
    }

}
