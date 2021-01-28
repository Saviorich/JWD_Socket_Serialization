package by.epam.tc.parser.impl;

import by.epam.tc.entity.Word;
import by.epam.tc.parser.TextParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordParser implements TextParser {
    @Override
    public List<Word> parse(String toParse) {
        List<Word> words = new ArrayList<>();
        for (String word : toParse.split("[,.!?:;]?[ ]+")){
            words.add(new Word(word));
        }
        return words;
    }
}
