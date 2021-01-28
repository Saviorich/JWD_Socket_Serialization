package by.epam.tc.parser.impl;

import by.epam.tc.entity.Text;
import by.epam.tc.entity.Sentence;
import by.epam.tc.entity.Word;
import by.epam.tc.parser.TextParser;

import java.util.List;

public class ProgrammingBookParser implements TextParser {

    @Override
    public Text parse(String toParse) {
        Text parsedText = new Text(toParse);

        SentenceParser sentenceParser = new SentenceParser();
        WordParser wordParser = new WordParser();

        List<Sentence> sentences = sentenceParser.parse(toParse);
        for (Sentence sentence : sentences){
            sentence.setWords(wordParser.parse(sentence.toString()));
        }
        parsedText.setSentences(sentences);
        return parsedText;
    }
}
