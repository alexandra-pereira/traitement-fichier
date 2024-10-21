package fr.diginamic.m062024.model;

/**
 * Represents a category of products.
 */
public class Categorie {
    private String libelle; // Name of the category

    /**
     * Constructs a Categorie with the specified name.
     *
     * @param libelle The name of the category.
     */
    public Categorie(String libelle) {
        this.libelle = libelle;
    }

    /**
     * Gets the name of the category.
     *
     * @return The name of the category.
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Sets the name of the category.
     *
     * @param libelle The name to set.
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return libelle; // Returns the name of the category
    }
}