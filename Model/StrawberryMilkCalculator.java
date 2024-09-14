package mvc_1_67.Model;

public class StrawberryMilkCalculator {
    // Method to calculate strawberry milk production
    public int calculateMilk(int ageInMonths) {
        return 30 - (ageInMonths % 12);
    }
}
