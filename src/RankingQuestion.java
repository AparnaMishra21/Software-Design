import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// class for ranking question
public class RankingQuestion extends Question{
    List<String> options;

    List<Integer> answer;

    // constructor
    RankingQuestion(String question, List<String> options, List<Integer> answer){
        super(question);
        this.options = options;
        this.answer = answer;
    }

    // getters and setters
    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    // static create method
    public static RankingQuestion create(boolean test){
        System.out.println("Please enter the question: ");
        String question = scanner.nextLine();

        // get number of items
        int num;
        while(true){
            System.out.println("Enter number of options: ");
            try{
                num = scanner.nextInt();
            } catch (Exception e){
                System.out.println("Please enter a valid number.");
                continue;
            }
            break;
        }

        // ask user to input all the options
        List<String> options = new ArrayList<>();
        options.add(null);

        for(int i = 0; i < num ; i++) {
            String userInput;
            System.out.println("Enter Item #" + (i + 1));
            userInput = scanner.next();
            options.add(userInput);
        }

        // if test mode, get the correct answer
        if(test) {
            List<Integer> correct = new ArrayList<>();
            Set<Integer> unique = new HashSet<>();
            System.out.println("Enter the correct sequence of items. ");
            for(int i = 0; i < num ; i++) {
                while(true) {
                    try {
                        int val = scanner.nextInt();
                        if(val > num || val <= 0){ // verify that user entered a number between 0 and num
                            throw new Exception();
                        }
                        if(!unique.add(val)){ // value should not be present in set already
                            throw new Exception();
                        }
                        correct.add(val);
                    } catch (Exception e) {
                        System.out.println("Please enter a valid number.");
                        continue;
                    }
                    break;
                }
            }
            return new RankingQuestion(question, options, correct);
        }

        return new RankingQuestion(question, options, null);
    }

    // display method
    public void display(){
        System.out.println(getQuestion());

        // print all options
        for(int i = 1; i < options.size(); i++){
            System.out.println("Item #" + i + " " + options.get(i));
        }

        // if test, print correct sequence
        if(answer != null)
            System.out.println("The correct sequence is " + answer);
    }
}
