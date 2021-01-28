package by.epam.tc.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sentence implements Serializable {
    private String sentence;
    private List<Word> words;

    private SentenceType sentenceType;

    {
        words = new ArrayList<>();
    }

    public Sentence() {}

    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    public Sentence(String sentence, List<Word> words) {
        this.sentence = sentence;
        this.words = words;
    }

    public void setWords(List<Word> words) {this.words = words;}

    public List<Word> getWords() {
        return words;
    }

    public void setSentenceType(SentenceType sentenceType) {
        this.sentenceType = sentenceType;
    }

    public SentenceType getSentenceType() {
        return sentenceType;
    }

    public int length() {return sentence.length();}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sentence sentence1 = (Sentence) o;

        if (sentence != null ? !sentence.equals(sentence1.sentence) : sentence1.sentence != null) return false;
        return words != null ? words.equals(sentence1.words) : sentence1.words == null;
    }

    @Override
    public int hashCode() {
        int result = sentence != null ? sentence.hashCode() : 0;
        result = 31 * result + (words != null ? words.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return sentence;
    }
}
