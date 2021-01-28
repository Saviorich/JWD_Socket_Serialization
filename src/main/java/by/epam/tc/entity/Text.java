package by.epam.tc.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Text implements Serializable {

    private String text;

    private List<Sentence> sentences;
    private List<Word> words;

    {
        sentences = new ArrayList<>();
        words = new ArrayList<>();
    }

    public Text() {}

    public Text(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Text text1 = (Text) o;

        if (text != null ? !text.equals(text1.text) : text1.text != null) return false;
        if (sentences != null ? !sentences.equals(text1.sentences) : text1.sentences != null) return false;
        return words != null ? words.equals(text1.words) : text1.words == null;
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (sentences != null ? sentences.hashCode() : 0);
        result = 31 * result + (words != null ? words.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return text;
    }
}
