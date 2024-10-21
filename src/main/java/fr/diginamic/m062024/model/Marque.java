package fr.diginamic.m062024.model;

/**
 * Represents a brand of products.
 */
public class Marque {
    private String nom; // Name of the brand

    /**
     * Constructs a Marque with the specified name.
     *
     * @param nom The name of the brand.
     */
    public Marque(String nom) {
        this.nom = nom;
    }

    /**
     * Gets the name of the brand.
     *
     * @return The name of the brand.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets the name of the brand.
     *
     * @param nom The name to set.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom; // Returns the name of the brand
    }
}