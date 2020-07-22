import java.io.Serializable;
import java.util.Scanner;

// abstract class for Questions
public abstract class Question implements Serializable { // implements serializable to serialize
    private static final long serialVersionUID = 1L;
    private String question;
    static Scanner scanner = new Scanner(System.in);

    // constructor
    Question(String question){
        this.question = question;
    }

    // getters and setters
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    abstract public void display();
}
