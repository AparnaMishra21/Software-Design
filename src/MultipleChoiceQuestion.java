import java.util.ArrayList;
import java.util.List;

// class for MCQs
public class MultipleChoiceQuestion extends Question{
    List<Integer> answer;
    List<String> options;

    // constructor
    MultipleChoiceQuestion(String question, List<String> options, List<Integer> answer){
        super(question);
        this.answer = answer;
        this.options = options;
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
    public static MultipleChoiceQuestion create(boolean test){
        System.out.println("Please enter the question: ");
        String question = scanner.nextLine();

        // get number of options
        int num = 0;
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

        // get the list of options
        List<String> options = new ArrayList<>();
        options.add("");

        for(int i = 0; i < num ; i++) {
            String userInput;
            System.out.println("Enter choice #" + (i + 1));
            userInput = scanner.next();
            options.add(userInput);
        }

        // if test mode, get the corrext choices
        if(test) {
            // get number of correct options
            int correct_num = 0;
            while(true){
                System.out.println("Enter number of correct answers: ");
                try{
                    correct_num = scanner.nextInt();
                } catch (Exception e){
                    System.out.println("Please enter a valid number.");
                    continue;
                }
                break;
            }

            // get the correct options
            List<Integer> correct = new ArrayList<>();
            for(int i = 0; i < correct_num; i++) {
                while (true) {
                    System.out.println("Enter the number of correct choice. ");
                    try {
                        correct.add(scanner.nextInt());
                    } catch (Exception e) {
                        System.out.println("Please enter a valid number.");
                        continue;
                    }
                    break;
                }
            }
            return new MultipleChoiceQuestion(question, options, correct);
        }

        return new MultipleChoiceQuestion(question, options, null);
    }

    public void display(){
        System.out.println(getQuestion());

        // print out options
        for(int i = 1; i < options.size(); i++){
            System.out.println("Choice #" + i + " " + options.get(i));
        }

        // print out the answer
        if(answer != null) {
            for(Integer op : answer) {
                System.out.println("The correct answer is " + op + ") " + options.get(op));
            }
        }
    }
}
