package by.epam.tc.service;

import by.epam.tc.entity.Sentence;
import by.epam.tc.entity.SentenceType;
import by.epam.tc.entity.Text;
import by.epam.tc.entity.Word;
import by.epam.tc.parser.impl.ProgrammingBookParser;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TextService {
    private Text text;

    public TextService(Text text) {
        this.text = text;
    }

    // Task 1
    public List<Sentence> findSentencesWithRepeatingWords() {
        List<Sentence> sentencesWithRepeatingWords = new ArrayList<>();

        for (Sentence sentence : text.getSentences()) {
            SentenceService service = new SentenceService(sentence);
            if (service.hasDuplicateWords()) {
                sentencesWithRepeatingWords.add(sentence);
            }
        }

        return sentencesWithRepeatingWords;
    }

    // Task 2
    public List<Sentence> sortByWordAmount() {
        List<Sentence> sentences = new ArrayList<>(text.getSentences());
        sentences.sort(new Comparator<Sentence>() {
            @Override
            public int compare(Sentence o1, Sentence o2) {
                int compareResult = 0;
                if (o1.getWords().size() > o2.getWords().size()) {
                    compareResult = -1;
                } else if (o1.getWords().size() < o2.getWords().size()) {
                    compareResult = 1;
                }
                return compareResult;
            }
        });

        return sentences;
    }

    // Task 3
    public Word findWordThatNotInOtherSentences() {
        List<Sentence> sentences = text.getSentences();
        Word fitsWord = null;

        for (Word word : sentences.get(0).getWords()) {
            for (int i = 1; i < sentences.size(); i++) {
                boolean fits = true;
                for (Word sentenceWord : sentences.get(i).getWords()){
                    if (sentenceWord.equals(word)) {
                        fits = false;
                    }
                }
                if (fits) {
                    fitsWord = word;
                }
            }
        }

        return fitsWord;
    }

    // Task 4
    public List<Word> findRepeatingWordsWithLength(int length, SentenceType type) {
        List<Word> words = new ArrayList<>();

        for (Sentence sentence : text.getSentences()) {
            if (sentence.getSentenceType() == type) {
                for (Word word : sentence.getWords()) {
                    if (!words.contains(word) && word.length() == length) {
                        words.add(word);
                    }
                }
            }
        }
        return words;
    }

    // Task 5
    public List<Sentence> changeWordsInSomePlace(int i1, int i2) {
        List<Sentence> sentences = new ArrayList<>(text.getSentences());

        for (Sentence sentence : sentences) {
            Word temp = sentence.getWords().get(i1);
            sentence.getWords().set(i1, sentence.getWords().get(i2));
            sentence.getWords().set(i2, temp);
        }
        return sentences;
    }

    // Task 6
    public List<Word> sortByAlphabet() {
        List<Word> words = new ArrayList<>();
        for (Sentence sentence : text.getSentences()) {
            words.addAll(sentence.getWords());
        }
        words.sort(new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                int result = 0;
                if (o1.charAt(0) > o2.charAt(0)){
                    result = -1;
                } else if (o1.charAt(0) < o2.charAt(0)) {
                    result = 1;
                }
                return result;
            }
        });
        return words;
    }

    // Task 7
    public List<Word> sortByVowelsProportion() {
        List<Word> words = new ArrayList<>();
        for (Sentence sentence : text.getSentences()) {
            words.addAll(sentence.getWords());
        }
        words.sort(new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                WordService wordService1 = new WordService(o1);
                WordService wordService2 = new WordService(o2);

                int proportionResult = 0;
                if (wordService1.vowelsProportion() > wordService2.vowelsProportion()){
                    proportionResult = -1;
                } else if (wordService1.vowelsProportion() < wordService2.vowelsProportion()) {
                    proportionResult = 1;
                }
                return proportionResult;
            }
        });
        return words;
    }

    // Task 8
    public List<Word> sortByFirstConsonant() {
        List<Word> words = new ArrayList<>();
        for (Sentence sentence : text.getSentences()) {
            words.addAll(sentence.getWords());
        }
        words.sort(new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                WordService wordService1 = new WordService(o1);
                WordService wordService2 = new WordService(o2);

                int result = 0;
                if (o1.charAt(wordService1.indexOfFirstConsonant()) > o2.charAt(wordService2.indexOfFirstConsonant())) {
                    result = -1;
                } else if (o1.charAt(wordService1.indexOfFirstConsonant()) < o2.charAt(wordService2.indexOfFirstConsonant())) {
                    result = 1;
                }
                return result;
            }
        });
        return words;
    }

    // Task 9
    public List<Word> sortByLetterAppearance(char letter) {
        return sortByLetterAppearance(letter, false);
    }

    // Task 13
    public List<Word> sortByLetterAppearance(char letter, boolean reverse) {
        List<Word> words = new ArrayList<>();
        for (Sentence sentence : text.getSentences()) {
            words.addAll(sentence.getWords());
        }
        words.sort(new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                WordService wordService1 = new WordService(o1);
                WordService wordService2 = new WordService(o2);

                int countResult = 0;
                if (wordService1.count(letter) > wordService2.count(letter)) {
                    countResult = -1;
                } else if (wordService1.count(letter) > wordService2.count(letter)) {
                    countResult = 1;
                }
                return reverse ? -countResult : countResult;
            }
        });
        return words;
    }

    // Task 10
    public List<Word> sortByWordAppearanceInSentences() {
        List<Word> words = new ArrayList<>();
        for (Sentence sentence : text.getSentences()) {
            words.addAll(sentence.getWords());
        }
        words.sort(new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                int firstWordCount = 0;
                int secondWordCount = 0;

                for (Sentence sentence : text.getSentences()) {
                    for (Word word : sentence.getWords()) {
                        if (word.equals(o1)) {
                            firstWordCount++;
                        }
                    }
                }

                for (Sentence sentence : text.getSentences()) {
                    for (Word word : sentence.getWords()) {
                        if (word.equals(o2)) {
                            secondWordCount++;
                        }
                    }
                }

                int countResult = 0;
                if (firstWordCount > secondWordCount) {
                    countResult = -1;
                } else if (firstWordCount < secondWordCount) {
                    countResult = 1;
                }
                return countResult;
            }
        });
        return words;
    }

    // Task 11
    public List<Sentence> deleteSubstring(String start, String end) {
        List<Sentence> sentences = new ArrayList<>();
        for (Sentence s : text.getSentences()) {
            final String sentence = s.toString();
            if (sentence.contains(start) && sentence.contains(end)) {
                int startIndex = sentence.indexOf(start);
                int endIndex = sentence.indexOf(end);

                StringBuilder sb = new StringBuilder()
                        .append(sentence, 0, startIndex)
                        .append(sentence, endIndex, sentence.length()-1);

                sentences.add(new Sentence(sb.toString()));
            }
        }
        return sentences;
    }

    // Task 12
    public Text deleteWordsStartsWithConsonant() {
        List<Sentence> sentences = new ArrayList<>(text.getSentences());

        for (Sentence sentence : sentences) {
            List<Word> words = sentence.getWords();
            for (int i = 0; i < words.size(); i++) {
                WordService wordService = new WordService(words.get(i));
                if (wordService.startsWithConsonant()) {
                    words.remove(words.get(i));
                }
            }
            sentence.setWords(words);
        }

        Text text = new Text();
        text.setSentences(sentences);

        return text;
    }

    // Task 14
    public String findPalindrome() {
        for (Sentence sentence : text.getSentences()) {
            SentenceService sentenceService = new SentenceService(sentence);
            if (!sentenceService.isPalindrome()) {
                for (Word word : sentence.getWords()) {
                    WordService wordService = new WordService(word);
                    if (wordService.isPalindrome()) {
                        return word.toString();
                    }
                }
            } else {
                return sentence.toString();
            }
        }
        return null;
    }

    // Task 15
    public List<Word> transformWordByDeleteLetter(char letter) {
        List<Word> words = new ArrayList<>();

        for (Sentence sentence : new ArrayList<>(text.getSentences())) {
            for (Word word : sentence.getWords()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) != letter) {
                        sb.append(word.charAt(i));
                    }
                }
                words.add(new Word(sb.toString()));
            }
        }
        return words;
    }

    // Task 16
    public Sentence replaceWord(int sentenceNumber, int wordLength, String replacement) {
        List<Sentence> sentences = new ArrayList<>(text.getSentences());

        Sentence sentence = sentences.get(sentenceNumber);
        List<Word> words = sentence.getWords();
        for (Word word : words) {
            if (word.length() == wordLength) {
                words.set(words.indexOf(word), new Word(replacement));
            }
        }
        sentence.setWords(words);
        return sentence;
    }

    public Text getText() {
        return text;
    }
}
