package finalOop;

public class NegativeTextAnalyzer extends KeywordAnalyzer {
    private String[] keywords = new String[]{":(", "=(", ":|"};
    @Override
    public String[] getKeywords() {
        return keywords;
    }

    @Override
    public Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }


}
