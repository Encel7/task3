package by.epam.task3.parser;

import by.epam.task3.components.Component;
import by.epam.task3.type.TypeOfComponent;

import java.util.ArrayList;
import java.util.List;

public class ParserCaller {

    public List<Component> callSpecificParser(final String text,
                                               final TypeOfComponent type) {
        List<Component> componentList = new ArrayList<>();

        switch (type) {
            case TEXT:
                TextParser textParser = new TextParser();
                componentList = textParser.parseData(text);
                break;
            case PARAGRAPH:
                ParagraphParser paragraphParser = new ParagraphParser();
                componentList = paragraphParser.parseData(text);
                break;
            case SENTENCE:
                SentenceParser sentenceParser = new SentenceParser();
                componentList = sentenceParser.parseData(text);
                break;
            case LEXEME:
                LexemeParser lexemeParser = new LexemeParser();
                componentList = lexemeParser.parseData(text);
                break;
            case WORD:
                WordParser wordParser = new WordParser();
                componentList = wordParser.parseData(text);
                break;
            default:
                System.out.println("Wrong type of component");
        }
        return componentList;
    }
}
