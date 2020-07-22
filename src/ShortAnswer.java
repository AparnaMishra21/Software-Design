// class for short answers
public class ShortAnswer extends Question{
    String answer;

    // get question and answer
    ShortAnswer(String question, String answer){
        super(question);
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    // static method to create ShortAnswer element with user input
    public static ShortAnswer create(boolean test){
        // get question from user
        System.out.println("Please enter the question: ");
        String question = scanner.nextLine();

        // get answer from user
        String answer = "";
        if(test) {
            System.out.println("Please enter the answer : ");
            answer = scanner.nextLine();
        }
        return new ShortAnswer(question,answer);
    }

    // method to display the question and answer
    public void display(){
        System.out.println(getQuestion());
        if(!answer.isEmpty())
            System.out.println("The correct answer is " + answer);
    }
}
