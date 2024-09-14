package mvc_1_67.Controller;

import mvc_1_67.Model.ConnectCSV;
import mvc_1_67.Model.Cow;
import mvc_1_67.View.MilkProductCal_View;

public class MilkProductCal_Controller {
    private MilkProductCal_View view;
    private ConnectCSV model;
    private int totalFreshMilk = 0;
    private int totalChocolateMilk = 0;
    private int totalStrawberryMilk = 0;

    public MilkProductCal_Controller(MilkProductCal_View view, ConnectCSV model) {
        this.view = view;
        this.model = model;
    }

    /**
     * Processes the cow data based on the provided cow ID.
     * 
     * @param idCow The ID of the cow to process.
     */
    public void processCow(String idCow) {
        // Validate the cow ID
        if (!idCow.matches("\\d{8}")) {
            // Check if the ID is numeric but not 8 digits
            if (idCow.matches("\\d+")) {
                view.displayResult("Please enter 8 numbers.");
            } else {
                // Non-numeric ID
                view.displayResult("Invalid Data !!!");
            }
            return;
        }

        // Find the cow by ID
        Cow cow = model.findCowById(idCow);

        if (cow != null) {
            // Initialize milk production for this round
            int freshMilkThisRound = 0;
            int chocolateMilkThisRound = 0;
            int strawberryMilkThisRound = 0;
            String milkTypeProduced = "";

            // Determine the type of milk produced based on breed
            switch (cow.getBreed().toLowerCase()) {
                case "white":
                    freshMilkThisRound = cow.calculateMilkProduction("fresh");
                    totalFreshMilk += freshMilkThisRound;
                    milkTypeProduced = "Fresh Milk";
                    break;
                case "brown":
                    chocolateMilkThisRound = cow.calculateMilkProduction("chocolate");
                    totalChocolateMilk += chocolateMilkThisRound;
                    milkTypeProduced = "Chocolate Milk";
                    break;
                case "pink":
                    strawberryMilkThisRound = cow.calculateMilkProduction("strawberry");
                    totalStrawberryMilk += strawberryMilkThisRound;
                    milkTypeProduced = "Strawberry Milk";
                    break;
                default:
                    view.displayResult("Invalid breed.");
                    return;
            }

            // Calculate total milk produced this round and overall total
            int totalMilkThisRound = freshMilkThisRound + chocolateMilkThisRound + strawberryMilkThisRound;
            int totalMilk = totalFreshMilk + totalChocolateMilk + totalStrawberryMilk;

            // Prepare the result message
            String result = String.format(
                    "Cow ID: %s\nBreed: %s\n" +
                            "Milk Produced This Round: %d (%s)\n" +
                            "Total Milk Produced:\n" +
                            "  Fresh Milk: %d liters\n" +
                            "  Chocolate Milk: %d liters\n" +
                            "  Strawberry Milk: %d liters\n" +
                            "  Total: %d liters",
                    cow.getIdCow(), cow.getBreed(),
                    totalMilkThisRound, milkTypeProduced,
                    totalFreshMilk, totalChocolateMilk, totalStrawberryMilk, totalMilk);

            // Display the result
            view.displayResult(result);
        } else {
            // Handle case where the cow ID is not found
            view.displayResult("Cow ID not found in the database.");
        }

        // Clear input field after processing
        view.clearInput();
    }
}
