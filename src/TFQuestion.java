import java.util.Arrays;

// class for True/False questions
public class TFQuestion extends Question{
    String answer;

    // constructor
    TFQuestion(String question, String answer){
        super(question);
        this.answer = answer;
    }

    // getters and setters
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    // static create method
    public static TFQuestion create(boolean test){
        System.out.println("Please enter the question: ");
        String question = scanner.nextLine();

        // if test, get correct answer
        if(test) {
            String userInput;
            while (true) {
                System.out.println("Please enter the answer(T/F): ");
                userInput = scanner.nextLine();
                if (!Arrays.asList("t", "true", "f", "false").contains(userInput.toLowerCase())) { // verify answer
                    System.out.println("Please enter a valid answer(T/F)");
                    continue;
                }
                break;
            }
            return new TFQuestion(question, userInput.substring(0,1).toUpperCase());
        }
        return new TFQuestion(question, "");
    }


    // display the question and answer
    public void display(){
        System.out.println(getQuestion());
        System.out.println("T/F");
        if(!answer.isEmpty()) // if test
            System.out.println("The correct answer is " + answer);
    }
}
