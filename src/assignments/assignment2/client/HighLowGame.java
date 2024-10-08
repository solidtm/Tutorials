package assignments.assignment2.client;

import BasicIO.*;

public class HighLowGame {
    private final BasicForm form;

    public HighLowGame(){
        form = new BasicForm();
        buildForm();             // Build the form with input fields
        form.accept();
    }

    public static void main(String[] args) {

    }

    private void buildForm() {
        form.setTitle("HighLow Game Simulation");

        form.addTextField("playGame", "Do you want to play game? (y/n)", 5, 10, 10);

        form.setLabel("selectPRNG", "Select a PRNG");
        form.addCheckBox("incrementingPRNG", "1. Incrementing PRNG", 10, 100);
        form.addCheckBox("timelyPRNG", "2. Timely PRNG", 10, 100);
        form.addCheckBox("basicPRNG", "3. Basic PRNG", 10, 100);

        form.addTextField("status", "Status", 30, 10, 190);
        form.setEditable("status", false); // Status field for validation errors or completion
    }
}
