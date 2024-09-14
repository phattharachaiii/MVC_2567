package mvc_1_67.Model;

public class ChocolateMilkCalculator {
    // Method to calculate chocolate milk production
    public int calculateMilk(int ageInMonths) {
        int ageInYears = ageInMonths / 12;
        return 40 - ageInYears;
    }
}
