public class EssayQuestion extends Question{
    String answer;

    EssayQuestion(String question){
        super(question);
    }

    // getters and setters
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    // static method to create essayQuestion element with user input
    public static EssayQuestion create(){
        // get the question
        System.out.println("Please enter the question: ");
        String question = scanner.nextLine();

        return new EssayQuestion(question);
    }

    // method to display the question and answer
    public void display(){
        System.out.println(getQuestion());
    }
}
