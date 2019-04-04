package by.task.tests.sorttest;


import by.epam.task3.components.Component;
import by.epam.task3.components.Composite;
import by.epam.task3.reader.FileReader;
import by.epam.task3.restoration.TextRecovery;
import by.epam.task3.sort.SortWords;
import by.epam.task3.type.TypeOfComponent;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordTest {

    @Test
    public void parseTest() throws IOException {
        FileReader fileReader = new FileReader();
        String str = fileReader.readData(new File("data/input.txt"));
        Composite composite = new Composite(str, TypeOfComponent.TEXT);
        TextRecovery textRecovery = new TextRecovery();
        SortWords sortWords = new SortWords();
        List<Component> componentList2 = sortWords.sortWordsByLength(composite);
        List<String> actual = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        expected.add("Sobaka Koshka Kartoshka. ");
        actual.add(textRecovery.recovery(componentList2.get(0)));
        Assert.assertEquals(actual, expected);
    }
}

