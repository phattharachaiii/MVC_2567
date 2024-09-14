package mvc_1_67.Model;

public class Cow {
    private String idCow;
    private String breed;
    private int ageInMonths;

    /**
     * Constructor to initialize a Cow object.
     * @param idCow The ID of the cow.
     * @param breed The breed of the cow.
     * @param ageInMonths The age of the cow in months.
     */
    public Cow(String idCow, String breed, int ageInMonths) {
        this.idCow = idCow;
        this.breed = breed;
        this.ageInMonths = ageInMonths;
    }

    /**
     * Gets the ID of the cow.
     * @return The ID of the cow.
     */
    public String getIdCow() {
        return idCow;
    }

    /**
     * Gets the breed of the cow.
     * @return The breed of the cow.
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Gets the age of the cow in months.
     * @return The age of the cow in months.
     */
    public int getAgeInMonths() {
        return ageInMonths;
    }

    /**
     * Calculates the milk production based on the breed of the cow.
     * @param milkType The type of milk (e.g., "fresh", "chocolate", "strawberry").
     * @return The amount of milk produced.
     * @throws IllegalArgumentException If the milkType is invalid.
     */
    public int calculateMilkProduction(String milkType) {
        int milkProduced = 0;

        // Determine the milk production calculation based on the milk type
        switch (milkType.toLowerCase()) {
            case "fresh":
                FreshMilkCalculator freshMilkCalculator = new FreshMilkCalculator();
                milkProduced = freshMilkCalculator.calculateMilk(ageInMonths);
                break;
            case "chocolate":
                ChocolateMilkCalculator chocolateMilkCalculator = new ChocolateMilkCalculator();
                milkProduced = chocolateMilkCalculator.calculateMilk(ageInMonths);
                break;
            case "strawberry":
                StrawberryMilkCalculator strawberryMilkCalculator = new StrawberryMilkCalculator();
                milkProduced = strawberryMilkCalculator.calculateMilk(ageInMonths);
                break;
            default:
                throw new IllegalArgumentException("Invalid milk type: " + milkType);
        }

        return milkProduced;
    }

    /**
     * Determines the type of milk produced based on the breed of the cow.
     * @return The type of milk produced.
     */
    public String getMilkType() {
        switch (breed.toLowerCase()) {
            case "white":
                return "Fresh Milk";
            case "brown":
                return "Chocolate Milk";
            case "pink":
                return "Strawberry Milk";
            default:
                return "Unknown"; // Return "Unknown" if the breed is not recognized
        }
    }
}
