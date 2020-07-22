import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class SurveyTest {

    static Scanner scanner = new Scanner(System.in);

    static Questions questionList = new Questions();

    // display menu1
    public static String menu1(){
        String userInput;
        while(true) {
            System.out.println("Please select: ");
            System.out.println("1. Survey");
            System.out.println("2. Test");
            System.out.println("3. Quit");
            userInput = scanner.nextLine();

            // keep looping till you user gives valid input
            if(!Arrays.asList("1", "2", "3").contains(userInput)){
                System.out.println("Please enter a valid option[1-3]");
                continue;
            }
            break;
        }
        return userInput;
    }

    // display menu2 for survey
    public static String menu2Survey(){
        String userInput;
        while(true) {
            System.out.println("Please select: ");
            System.out.println("1. Create a new Survey");
            System.out.println("2. Display a survey");
            System.out.println("3. Load a survey");
            System.out.println("4. Save a survey");
            System.out.println("5. Quit");
            userInput = scanner.nextLine();

            // keep looping till you user gives valid input
            if(!Arrays.asList("1", "2", "3", "4", "5").contains(userInput)){
                System.out.println("Please enter a valid option[1-5]");
                continue;
            }
            break;
        }
        return userInput;
    }

    // display menu2 for test
    public static String menu2Test(){
        String userInput;
        while(true) {
            System.out.println("Please select: ");
            System.out.println("1. Create a new Test");
            System.out.println("2. Display the Test");
            System.out.println("3. Load a Test");
            System.out.println("4. Save the Test");
            System.out.println("5. Quit");
            userInput = scanner.nextLine();

            // keep looping till you user gives valid input
            if(!Arrays.asList("1", "2", "3", "4", "5").contains(userInput)){
                System.out.println("Please enter a valid option[1-5]");
                continue;
            }
            break;
        }
        return userInput;
    }

    // display menu3
    public static String menu3(){
        String userInput;
        while(true) {
            System.out.println("1) Add a new T/F question ");
            System.out.println("2) Add a new multiple choice question ");
            System.out.println("3) Add a new short answer question");
            System.out.println("4) Add a new essay question");
            System.out.println("5) Add a new ranking question");
            System.out.println("6) Add a new matching question");
            System.out.println("7) Done with questions");
            userInput = scanner.nextLine();

            // keep looping till you user gives valid input
            if(!Arrays.asList("1", "2", "3", "4", "5", "6", "7").contains(userInput)){
                System.out.println("Please enter a valid option[1-7]");
                continue;
            }
            break;
        }
        return userInput;
    }

    // create and add new questions to questions object till user selects 7 (Exit)
    public static void createNew(boolean test){
        String option;
        while(!(option = menu3()).equals("7")){
            switch (option){
                case "1":
                    questionList.add(TFQuestion.create(test));
                    break;
                case "2":
                    questionList.add(MultipleChoiceQuestion.create(test));
                    break;
                case "3":
                    questionList.add(ShortAnswer.create(test));
                    break;
                case "4":
                    questionList.add(EssayQuestion.create());
                    break;
                case "5":
                    questionList.add(RankingQuestion.create(test));
                    break;
                case "6":
                    questionList.add(MatchQuestion.create(test));
                    break;
            }
        }
    }

    // method to call display method of all questions in questions object
    public static void print(){
        int i = 1;
        for(Question question : questionList.getQuestions()){
            System.out.print("" + i + ") ");
            question.display();
            i = i + 1;
        }
    }

    // save the current questions object in user defined file
    public static void save(){
        System.out.println("Please enter the filename: ");
        String filename = scanner.next();
        try {
            FileOutputStream f = new FileOutputStream(new File("./storage/" +filename));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(questionList);
        } catch (Exception e){
            System.out.println("There was error saving to file");
        }
    }

    // load the data from user specified file
    public static void load(){
        File folder = new File("./storage");
        String[] listOfFiles = folder.list();
        if(listOfFiles == null){
            System.out.println("Error reading the storage folder.");
            return;
        }
        System.out.println("Please choose the file to load (select a number): ");
        int i = 1;
        for(String filename : listOfFiles){
            System.out.println("" + i + ") " + filename);
            i = i +1;
        }

        // get a valid input from the user
        int selection;
        while(true) {
            try {
                selection = scanner.nextInt();
                if(selection >= i){
                    throw new Exception();
                }
                break;
            } catch (Exception e){
                System.out.println("Enter a valid input");
                continue;
            }
        }

        // try to read the file and deserialize the object
        try {
            FileInputStream fi = new FileInputStream(new File("./storage/" + listOfFiles[selection-1]));
            ObjectInputStream oi = new ObjectInputStream(fi);
            questionList = (Questions) oi.readObject();
        } catch (Exception e){
            System.out.println("There was error loading from file");
        }
    }

    // switch for survey
    public static void survey(){
        String option;
        while(!(option = menu2Survey()).equals("5")){ // display menu till user selects 5
            switch (option){
                case "1":
                    questionList = new Questions();
                    createNew(false);
                    break;
                case "2":
                    print();
                    break;
                case "3":
                    load();
                    break;
                case "4":
                    save();
                    break;
            }
        }
    }

    // switch for test
    public static void test(){
        String option;
        while(!(option = menu2Test()).equals("5")){ // display menu till user selects 5
            switch (option){
                case "1":
                    questionList = new Questions();
                    createNew(true);
                    break;
                case "2":
                    print();
                    break;
                case "3":
                    load();
                    break;
                case "4":
                    save();
                    break;
            }
        }
    }

    public static void main(String[] args){
        boolean again = true;
        while(again){
            switch(menu1()){ // call menu1
                case "1":
                    survey();
                    break;
                case "2":
                    test();
                    break;
                case "3":
                    again = false;
                    break;
            }
        }

    }
}
