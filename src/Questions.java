import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// list of questions
// enable serialization
public class Questions  implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Question> questions = new ArrayList<>();

    // getters ans setters
    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    // add a question to list
    public void add(Question question) {
        this.questions.add(question);
    }
}
