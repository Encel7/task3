package by.task.tests.compositeTest;


import by.epam.task3.components.Composite;
import by.epam.task3.reader.FileReader;
import by.epam.task3.restoration.TextRecovery;
import by.epam.task3.type.TypeOfComponent;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class CompositeTest {

    @Test
    public void parseTest() throws IOException {
        FileReader fileReader = new FileReader();
        String str = fileReader.readData(new File("data/input.txt"));
        Composite composite = new Composite(str, TypeOfComponent.TEXT);
        TextRecovery textRecovery = new TextRecovery();
        String actual = textRecovery.recovery(composite);
        String expected = "    Sobaka Koshka Kartoshka. Vot. Tak. \n" +
                "    Ssd. \n";
        Assert.assertEquals(actual, expected);


    }
}

