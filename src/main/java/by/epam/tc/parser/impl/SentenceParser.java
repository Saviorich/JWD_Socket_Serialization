package by.epam.tc.parser.impl;

import by.epam.tc.entity.Sentence;
import by.epam.tc.parser.TextParser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SentenceParser implements TextParser {
    @Override
    public List<Sentence> parse(String toParse) {
        List<Sentence> sentences = new ArrayList<>();
        for(String sentence : toParse.split("[.][ ]?")) {
            sentences.add(new Sentence(sentence));
        }
        return sentences;
    }
}
