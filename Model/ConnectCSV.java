package mvc_1_67.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConnectCSV {
    private String filePath;

    public ConnectCSV(String filePath) {
        this.filePath = filePath;
    }

    // Method to read all cow data from the CSV file
    public List<Cow> readCowData() {
        List<Cow> cows = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true; // Flag to skip the header line

            while ((line = br.readLine()) != null) {
                // Skip header line
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] cowData = line.split(",");
                if (cowData.length == 4) {
                    try {
                        String idCow = cowData[0].trim();
                        String breed = cowData[1].trim();
                        int ageYears = Integer.parseInt(cowData[2].trim());
                        int ageMonths = Integer.parseInt(cowData[3].trim());
                        int ageInMonths = (ageYears * 12) + ageMonths;

                        // Validate the data
                        if (validateCowData(idCow, breed, ageYears, ageMonths)) {
                            cows.add(new Cow(idCow, breed, ageInMonths));
                        } else {
                            System.out.println("Invalid data for Cow ID: " + idCow);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing age data: " + e.getMessage());
                    }
                } else {
                    System.out.println("Invalid data format: " + line); // For debugging
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }

        return cows;
    }

    // Method to validate cow data
    private boolean validateCowData(String idCow, String breed, int ageYears, int ageMonths) {
        // Check if ID is 8 digits and does not start with '0'
        if (idCow.length() != 8 || idCow.startsWith("0")) {
            return false;
        }

        // Check if breed is one of the allowed values
        if (!breed.equalsIgnoreCase("White") && !breed.equalsIgnoreCase("Brown") && !breed.equalsIgnoreCase("Pink")) {
            return false;
        }

        // Check if age is within valid range
        if (ageYears < 0 || ageMonths < 0 || ageMonths >= 12) {
            return false;
        }

        return true;
    }

    // Method to find a cow by ID
    public Cow findCowById(String idCow) {
        List<Cow> cows = readCowData();
        System.out.println("Searching for Cow ID: " + idCow); // Debugging line
        for (Cow cow : cows) {
            System.out.println("Found Cow ID: " + cow.getIdCow()); // Debugging line
            if (cow.getIdCow().equals(idCow.trim())) {
                return cow;
            }
        }
        return null; // Return null if the cow is not found
    }
}
