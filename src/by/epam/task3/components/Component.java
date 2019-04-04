package by.epam.task3.components;

import by.epam.task3.type.TypeOfComponent;

import java.util.List;

public interface Component {

    List<Component> getComponents();


    TypeOfComponent getType();
}
