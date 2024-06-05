import java.util.List;

public class Question {
    private String questiontext;
    private List<String> Options;
    private int correctnswerindex;

    public Question(String questionText, List<String> options, int correctanswerindex) {
        this.questiontext = questionText;
        this.Options = options;
        this.correctnswerindex = correctanswerindex;
    }

    public String getquestiontext() {
        return questiontext;
    }

    public List<String> getoptions() {
        return Options;
    }

    public int getcorrectanswerindex() {
        return correctnswerindex;
    }

}
