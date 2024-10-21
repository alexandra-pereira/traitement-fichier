package fr.diginamic.m062024.utils;

import fr.diginamic.m062024.model.*;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to read product data from a CSV file and convert it into a Stock object.
 */
public class CSVFileReader {

    /**
     * Loads products from a CSV file located in the resources.
     *
     * @param fileName The name of the CSV file.
     * @return A Stock object containing the products loaded from the CSV file.
     * @throws IOException If an error occurs while reading the file.
     */
    public Stock loadProductsFromCSV(String fileName) throws IOException {
        Stock stock = new Stock();

        // Load file from resources
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("File not found! " + fileName);
        }

        // Read lines from the CSV file
        List<String> lines = IOUtils.readLines(inputStream, StandardCharsets.UTF_8);

        // Skip the header row and parse each line
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            Produit produit = parseLineToProduit(line);
            stock.addProduit(produit);
        }

        return stock;
    }

    /**
     * Parses a line of CSV into a Produit object.
     *
     * @param line A single line from the CSV file.
     * @return A Produit object populated with the parsed data.
     * @throws IllegalArgumentException If the CSV line format is invalid.
     */
    private Produit parseLineToProduit(String line) {
        String[] tokens = line.split("\\|");

        // Check if tokens have the expected length
        if (tokens.length < 10) {
            throw new IllegalArgumentException("Invalid CSV line format: " + line);
        }

        // Parse each column from the CSV file
        Categorie categorie = new Categorie(tokens[0].trim());
        Marque marque = new Marque(tokens[1].trim());
        String scoreNutritionnel = tokens[3].trim();
        int energie = parseEnergie(tokens[5]);
        double graisse = parseGraisse(tokens[6]);

        List<Ingredient> ingredients = parseIngredients(tokens[4].trim());
        List<Allergene> allergenes = parseAllergenes(tokens[7].trim());
        List<Additif> additifs = parseAdditifs(tokens[8].trim());

        boolean presenceHuilePalme = parseBoolean(tokens[9]);

        return new Produit(categorie, marque, scoreNutritionnel, energie, graisse, ingredients, allergenes, additifs);
    }

    // Helper methods to parse CSV fields

    /**
     * Parses the energy content from a string.
     *
     * @param energieStr The string containing the energy content.
     * @return The parsed energy content, or 0 if invalid.
     */
    private int parseEnergie(String energieStr) {
        try {
            return Integer.parseInt(energieStr.trim());
        } catch (NumberFormatException e) {
            return 0; // Return default value if invalid
        }
    }

    /**
     * Parses the fat content from a string.
     *
     * @param graisseStr The string containing the fat content.
     * @return The parsed fat content, or 0.0 if invalid.
     */
    private double parseGraisse(String graisseStr) {
        try {
            return Double.parseDouble(graisseStr.trim());
        } catch (NumberFormatException e) {
            return 0.0; // Return default value if invalid
        }
    }

    /**
     * Parses a string of ingredients into a list of Ingredient objects.
     *
     * @param ingredientsStr The string containing the ingredients.
     * @return A list of Ingredient objects.
     */
    private List<Ingredient> parseIngredients(String ingredientsStr) {
        if (ingredientsStr.isEmpty()) {
            return new ArrayList<>(); // Return empty list if no ingredients
        }

        String[] ingredientTokens = ingredientsStr.split(",");
        List<Ingredient> ingredients = new ArrayList<>();
        for (String token : ingredientTokens) {
            ingredients.add(new Ingredient(token.trim()));
        }
        return ingredients;
    }

    /**
     * Parses a string of allergens into a list of Allergene objects.
     *
     * @param allergenesStr The string containing the allergens.
     * @return A list of Allergene objects.
     */
    private List<Allergene> parseAllergenes(String allergenesStr) {
        if (allergenesStr.isEmpty()) {
            return new ArrayList<>(); // Return empty list if no allergens
        }

        String[] allergeneTokens = allergenesStr.split(",");
        List<Allergene> allergenes = new ArrayList<>();
        for (String token : allergeneTokens) {
            allergenes.add(new Allergene(token.trim()));
        }
        return allergenes;
    }

    /**
     * Parses a string of additives into a list of Additif objects.
     *
     * @param additifsStr The string containing the additives.
     * @return A list of Additif objects.
     */
    private List<Additif> parseAdditifs(String additifsStr) {
        if (additifsStr.isEmpty()) {
            return new ArrayList<>(); // Return empty list if no additives
        }

        String[] additifTokens = additifsStr.split(",");
        List<Additif> additifs = new ArrayList<>();
        for (String token : additifTokens) {
            additifs.add(new Additif(token.trim()));
        }
        return additifs;
    }

    /**
     * Parses a boolean value from a string.
     *
     * @param boolStr The string containing the boolean value.
     * @return True if the string is "true" (case-insensitive), otherwise false.
     */
    private boolean parseBoolean(String boolStr) {
        return boolStr.equalsIgnoreCase("true");
    }
}
