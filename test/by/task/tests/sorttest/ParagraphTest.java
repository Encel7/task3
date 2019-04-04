package by.task.tests.sorttest;


import by.epam.task3.components.Component;
import by.epam.task3.components.Composite;
import by.epam.task3.reader.FileReader;
import by.epam.task3.restoration.TextRecovery;
import by.epam.task3.sort.SortParagraphs;
import by.epam.task3.type.TypeOfComponent;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParagraphTest {

    @Test
    public void parseTest() throws IOException {
        FileReader fileReader = new FileReader();
        String str = fileReader.readData(new File("data/input.txt"));
        Composite composite = new Composite(str, TypeOfComponent.TEXT);
        TextRecovery textRecovery = new TextRecovery();
        SortParagraphs sortParagraphs = new SortParagraphs();
        List<Component> componentList = sortParagraphs.sortParagraphsBySentences(composite);
        List<String> actual = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        expected.add("Ssd. ");
        expected.add("Ne ponyal. ");
        expected.add("Sobaka Koshka Kartoshka. Vot. Tak. ");
        for (Component cmp : componentList) {
            actual.add(textRecovery.recovery(cmp));
        }
        Assert.assertEquals(actual, expected);
    }
}

