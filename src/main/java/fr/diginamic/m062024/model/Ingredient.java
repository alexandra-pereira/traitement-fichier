package fr.diginamic.m062024.model;

/**
 * Represents an ingredient in a product.
 */
public class Ingredient {
    private String libelle; // Name of the ingredient

    /**
     * Constructs an Ingredient with the specified name.
     *
     * @param libelle The name of the ingredient.
     */
    public Ingredient(String libelle) {
        this.libelle = libelle;
    }

    /**
     * Gets the name of the ingredient.
     *
     * @return The name of the ingredient.
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Sets the name of the ingredient.
     *
     * @param libelle The name to set.
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return libelle; // Returns the name of the ingredient
    }
}