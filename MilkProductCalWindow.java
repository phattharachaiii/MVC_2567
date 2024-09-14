package mvc_1_67;

import mvc_1_67.Controller.MilkProductCal_Controller;
import mvc_1_67.Model.ConnectCSV;
import mvc_1_67.View.MilkProductCal_View;

public class MilkProductCalWindow {

    public static void main(String[] args) {
        // Define the path to the CSV file containing cow data
        String filePath = "mvc_1_67\\database.csv";

        // Initialize the model with the CSV file path
        ConnectCSV model = new ConnectCSV(filePath);

        // Create an instance of the view
        MilkProductCal_View view = new MilkProductCal_View();

        // Create the controller, passing in the view and model
        MilkProductCal_Controller controller = new MilkProductCal_Controller(view, model);

        // Set the controller in the view
        view.setController(controller);

        // Make the view visible to the user
        view.setVisible(true);
    }
}
