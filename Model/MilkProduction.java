package mvc_1_67.Model;

public class MilkProduction {
    public int calculateMilk(int ageInMonths, String breed) {
        int milkProduced = 0;

        switch (breed) {
            case "White":
                milkProduced = 120 - ageInMonths;
                break;
            case "Brown":
                milkProduced = 40 - (ageInMonths / 12);
                break;
            case "Pink":
                milkProduced = 30 - ageInMonths;
                break;
            default:
                throw new IllegalArgumentException("Unknown breed: " + breed);
        }

        return Math.max(milkProduced, 0); // Ensure milk production is not negative
    }
}
