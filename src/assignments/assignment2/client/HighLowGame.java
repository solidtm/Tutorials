package assignments.assignment2.client;

import BasicIO.*;
import assignments.assignment2.chaotic.*;

public class HighLowGame {
    private final BasicForm form;

    public HighLowGame(){
        form = new BasicForm();
        buildForm();             // Build the form with input fields
        form.accept();

        String playGame = form.readString("playGame");
        boolean incrementingPRNG = form.readBoolean("incrementingPRNG");
        boolean timelyPRNG = form.readBoolean("timelyPRNG");
        boolean basicPRNG = form.readBoolean("basicPRNG");
        PRNG prng = null;

        if(incrementingPRNG && timelyPRNG && basicPRNG){
            form.writeString("status", "Please select only one PRNG type.");
        }else if((incrementingPRNG && timelyPRNG) || (timelyPRNG && basicPRNG) || (incrementingPRNG && basicPRNG)){
            form.writeString("status", "Please select only one PRNG type.");
        }else{
            if(incrementingPRNG){
                prng = new IncrementingPRNG();
            }else if(timelyPRNG){
                prng = new TimelyPRNG();
            }else{
                prng = new BasicPRNG();
            }
        }

        if(playGame.equals("y") || playGame.equals("yes")){
            if(prng != null){
                playGame(prng, form);
            }else {
                form.close();
            }
        }else if(playGame.equals("n") || playGame.equals("no")) {
            form.close();
        }else {
            form.writeString("status", "Please enter a valid answer.");
        }
    }

    private void playGame(PRNG prng, BasicForm form) {
        try{
            int target = prng.nextInt(1, 101);
            int guess;

            form.addTextField("guessGame", "Guess a number between 1 and 100", 5, 10, 140);
            do{
                form.accept();
                guess = form.readInt("guessGame");

                if(guess > target){
                    form.writeString("status", "Guess lower!");
                }else if(guess < target){
                    form.writeString("status", "Guess higher!");
                }
            }while(guess != target);

            form.writeString("status", "Congratulations, You guessed the game right!");
            form.addLabel("guessedRight", "Congratulations, You guessed the game right!");
        }catch(PRNGException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new HighLowGame();
    }

    private void buildForm() {
        form.setTitle("HighLow Game Simulation");

        form.addTextField("playGame", "Do you want to play game? (y/n)", 5, 10, 10);

        form.addLabel("selectPRNG", "Select a PRNG:");
        form.addCheckBox("incrementingPRNG", "1. Incrementing PRNG", 10, 70);
        form.addCheckBox("timelyPRNG", "2. Timely PRNG", 10, 90);
        form.addCheckBox("basicPRNG", "3. Basic PRNG", 10, 110);

        form.addTextField("status", "Status", 30, 10, 170);
        form.setEditable("status", false);
    }
}
