import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchQuestion extends Question {
    List<String> optionsA; // column A
    List<String> optionsB; // column B
    Map<Integer, Integer> answer;

    // constructor
    MatchQuestion(String question, List<String> optionsA, List<String> optionsB, Map<Integer, Integer> answer){
        super(question);
        this.optionsA = optionsA;
        this.optionsB = optionsB;
        this.answer = answer;
    }

    // getters and setters
    public List<String> getOptionsA() {
        return optionsA;
    }

    public List<String> getOptionsB() {
        return optionsB;
    }

    public Map<Integer, Integer> getAnswer() {
        return answer;
    }

    public void setOptionsA(List<String> optionsA) {
        this.optionsA = optionsA;
    }

    public void setOptionsB(List<String> optionsB) {
        this.optionsB = optionsB;
    }

    public void setAnswer(Map<Integer, Integer> answer) {
        this.answer = answer;
    }

    // static create method
    public static MatchQuestion create(boolean test){
        // get question from user
        System.out.println("Please enter the question: ");
        String question = scanner.nextLine();

        // get number of pairs from user
        int num = 0;
        while(true){
            System.out.println("Enter number of pairs: ");
            try{
                num = scanner.nextInt();
            } catch (Exception e){
                System.out.println("Please enter a valid number.");
                continue;
            }
            break;
        }

        // get list of columnA elements
        List<String> optionsA = new ArrayList<>();
        optionsA.add(null); // making element 0 null

        for(int i = 0; i < num ; i++) {
            String userInput;
            System.out.println("Enter ItemA #" + (i + 1));
            userInput = scanner.next();
            optionsA.add(userInput);
        }

        // get a list of columnB elements
        List<String> optionsB = new ArrayList<>();
        optionsB.add(null); // making element 0 null

        for(int i = 0; i < num ; i++) {
            String userInput;
            System.out.println("Enter ItemB #" + (i + 1));
            userInput = scanner.next();
            optionsB.add(userInput);
        }

        // if its a test
        if(test) {
            Map<Integer, Integer> correct = new HashMap<>();
            // get correct matches for all elements in column A
            for(int i = 0; i < num ; i++) {
                System.out.println("Enter the correct match for itemA" + (i+1));
                while(true) {
                    try {
                        correct.put(i+1, scanner.nextInt());
                    } catch (Exception e) {
                        System.out.println("Please enter a valid number.");
                        continue;
                    }
                    break;
                }
            }
            return new MatchQuestion(question, optionsA, optionsB, correct);
        }

        return new MatchQuestion(question, optionsA, optionsB, null);
    }

    // display the question
    public void display(){
        System.out.println(getQuestion());

        // print out options
        for(int i = 1; i < optionsA.size(); i++){
            System.out.println(optionsA.get(i) + "   ---------    " + optionsB.get(i));
        }

        // print out the answer
        if(answer != null) {
            System.out.println("The correct answer is ");
            for(Integer key : answer.keySet()){
                System.out.println(key + "   ---------    " + answer.get(key));
            }
        }
    }
}
