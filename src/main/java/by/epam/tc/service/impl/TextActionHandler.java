package by.epam.tc.service.impl;

import by.epam.tc.entity.SentenceType;
import by.epam.tc.service.ActionHandler;
import by.epam.tc.service.TextService;

public class TextActionHandler implements ActionHandler {

    private TextService service;

    public TextActionHandler(TextService service) {
        this.service = service;
    }

    @Override
    public Object getActionResult() {
        return getActionResult(0);
    }

    @Override
    public Object getActionResult(int actionNumber) {
        Object actionResult;
        switch (actionNumber) {
            case 0:
                actionResult = service.getText();
                break;
            case 1:
                actionResult = service.findSentencesWithRepeatingWords();
                break;
            case 2:
                actionResult = service.sortByWordAmount();
                break;
            case 3:
                actionResult = service.findWordThatNotInOtherSentences();
                break;
            case 4:
                actionResult = service.findRepeatingWordsWithLength(5, SentenceType.INTERROGATIVE);
                break;
            case 5:
                actionResult = service.changeWordsInSomePlace(0, 10);
                break;
            case 6:
                actionResult = service.sortByAlphabet();
                break;
            case 7:
                actionResult = service.sortByVowelsProportion();
                break;
            case 8:
                actionResult = service.sortByFirstConsonant();
                break;
            case 9:
                actionResult = service.sortByLetterAppearance('t');
                break;
            case 10:
                actionResult = service.sortByWordAppearanceInSentences();
                break;
            case 11:
                actionResult = service.deleteSubstring("Теперь", "автомат");
                break;
            case 12:
                actionResult = service.deleteWordsStartsWithConsonant();
                break;
            case 13:
                actionResult = service.sortByLetterAppearance('т', true);
                break;
            case 14:
                actionResult = service.findPalindrome();
                break;
            case 15:
                actionResult = service.transformWordByDeleteLetter('т');
                break;
            case 16:
                actionResult = service.replaceWord(2, 5, "замена");
                break;
            default:
                actionResult = null;
        }
        return actionResult;
    }
}
