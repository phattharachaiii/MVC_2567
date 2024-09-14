package mvc_1_67.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mvc_1_67.Controller.MilkProductCal_Controller;

public class MilkProductCal_View extends JFrame {
    private JTextField idField;
    private JTextArea resultArea;
    private JButton submitButton;
    private MilkProductCal_Controller controller;

    public MilkProductCal_View() {
        // Set up the JFrame properties
        setTitle("Cow Milk Production"); // Title of the window
        setSize(300, 300); // Window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation
        setLayout(null); // Use absolute positioning

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Initialize and add components to the JFrame

        // Label for Cow ID input
        JLabel idLabel = new JLabel("Enter Cow ID:");
        idLabel.setBounds(10, 10, 100, 25); // Set position and size
        add(idLabel);

        // TextField for user to enter Cow ID
        idField = new JTextField();
        idField.setBounds(120, 10, 150, 25); // Set position and size
        add(idField);

        // Button to submit Cow ID
        submitButton = new JButton("Submit");
        submitButton.setBounds(10, 50, 100, 25); // Set position and size
        add(submitButton);

        // TextArea to display results
        resultArea = new JTextArea();
        resultArea.setBounds(10, 90, 260, 150); // Set position and size
        resultArea.setEditable(false); // Make the text area read-only
        add(resultArea);

        // Add action listener to handle button clicks
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText(); // Get text from the input field
                if (controller != null) {
                    controller.processCow(id); // Process the Cow ID with the controller
                }
            }
        });
    }

    /**
     * Displays the result in the result area.
     * 
     * @param result The result string to display.
     */
    public void displayResult(String result) {
        resultArea.setText(result); // Update the result area with the result string
    }

    /**
     * Clears the input field.
     */
    public void clearInput() {
        idField.setText(""); // Clear the text in the input field
    }

    /**
     * Sets the controller for the view.
     * 
     * @param controller The controller to set.
     */
    public void setController(MilkProductCal_Controller controller) {
        this.controller = controller; // Assign the controller to the view
    }
}
