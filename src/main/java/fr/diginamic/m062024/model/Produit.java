package fr.diginamic.m062024.model;

import java.util.List;

/**
 * Represents a product with its attributes, including category, brand,
 * nutritional information, ingredients, allergens, and additives.
 */
public class Produit {
    private Categorie categorie; // The category of the product
    private Marque marque; // The brand of the product
    private String scoreNutritionnel; // Nutritional score of the product
    private int energie; // Energy content (in Joules per 100g)
    private double graisse; // Fat content (in grams per 100g)
    private List<Ingredient> ingredients; // List of ingredients
    private List<Allergene> allergenes; // List of allergens
    private List<Additif> additifs; // List of additives

    /**
     * Constructs a Produit with the specified attributes.
     *
     * @param categorie         The category of the product.
     * @param marque            The brand of the product.
     * @param scoreNutritionnel The nutritional score.
     * @param energie           The energy content.
     * @param graisse           The fat content.
     * @param ingredients       The list of ingredients.
     * @param allergenes        The list of allergens.
     * @param additifs          The list of additives.
     */
    public Produit(Categorie categorie, Marque marque, String scoreNutritionnel,
                   int energie, double graisse, List<Ingredient> ingredients,
                   List<Allergene> allergenes, List<Additif> additifs) {
        this.categorie = categorie;
        this.marque = marque;
        this.scoreNutritionnel = scoreNutritionnel;
        this.energie = energie;
        this.graisse = graisse;
        this.ingredients = ingredients;
        this.allergenes = allergenes;
        this.additifs = additifs;
    }

    // Getters and setters for all fields
    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public String getScoreNutritionnel() {
        return scoreNutritionnel;
    }

    public void setScoreNutritionnel(String scoreNutritionnel) {
        this.scoreNutritionnel = scoreNutritionnel;
    }

    public int getEnergie() {
        return energie;
    }

    public void setEnergie(int energie) {
        this.energie = energie;
    }

    public double getGraisse() {
        return graisse;
    }

    public void setGraisse(double graisse) {
        this.graisse = graisse;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Allergene> getAllergenes() {
        return allergenes;
    }

    public void setAllergenes(List<Allergene> allergenes) {
        this.allergenes = allergenes;
    }

    public List<Additif> getAdditifs() {
        return additifs;
    }

    public void setAdditifs(List<Additif> additifs) {
        this.additifs = additifs;
    }
}