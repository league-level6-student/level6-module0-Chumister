package _04_jeopardy_api;

import _04_jeopardy_api.data_transfer_objects.Clue;

import java.util.Iterator;

import javax.swing.*;

public class JeopardyRunner {

    public static void main(String[] args) {

        JeopardyApi jeopardyApi = new JeopardyApi();

        //1. Create a score variable
int score =0;
        //2. Add a for loop where:
        for(int i=100; i<=1000; i+=100){
if(i==700 || i==900){
    continue;
}
            Clue newClue = jeopardyApi.getClue(i);
String question = newClue.getQuestion();
String answer = newClue.getAnswer();
String title = newClue.getCategory().getTitle();
String userAnswer = JOptionPane.showInputDialog(null, question, title, JOptionPane.QUESTION_MESSAGE);
if(userAnswer.equals(answer)){
    System.out.println("Correct");
    score =score+i;

}
else{
    System.out.println("Incorrect");
}


        }
        JOptionPane.showMessageDialog(null, "Your score: " + score);
        //i starts at 100,
        //continues while i <= 1000
        //increments by 100

            //3. If i == 700 or i == 900, continue;
            //there are no questions for these values

            //4. Call the getClue() method with i

            //5. Save the question in a String variable

            //6. Save the answer in a String variable

            //7. Save the title in a String variable
            //note that this is part of the Category object

            //8. Use a JOptionPane to display the question.
            //You can set the title of the JOptionPane to the question title.

            //9. If they got the question correct, add the value of that question to their score

        //10. Tell the user their final score

    }

}