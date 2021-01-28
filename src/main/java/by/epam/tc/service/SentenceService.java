package by.epam.tc.service;

import by.epam.tc.entity.Sentence;
import by.epam.tc.entity.Word;

import java.util.ArrayList;
import java.util.List;

public class SentenceService {
    private Sentence sentence;

    public SentenceService(Sentence sentence) {
        this.sentence = sentence;
    }

    public boolean hasDuplicateWords() {
        List<Word> words = new ArrayList<>();
        for (Word word : sentence.getWords()) {
            if (!words.contains(word)) {
                words.add(word);
            }
        }
        return words.size() == sentence.getWords().size();
    }

    public boolean isPalindrome() {
        int n = sentence.length();
        String stringSentence = sentence.toString();
        for (int i = 0; i < (n/2); ++i) {
            if (stringSentence.toString().charAt(i) != stringSentence.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
