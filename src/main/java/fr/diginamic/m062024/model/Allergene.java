package fr.diginamic.m062024.model;

/**
 * Represents an allergen with a name.
 */
public class Allergene {
    private String libelle; // Name of the allergen

    /**
     * Constructs an Allergene with the specified name.
     *
     * @param libelle The name of the allergen.
     */
    public Allergene(String libelle) {
        this.libelle = libelle;
    }

    /**
     * Gets the name of the allergen.
     *
     * @return The name of the allergen.
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Sets the name of the allergen.
     *
     * @param libelle The name to set.
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return libelle; // Returns the name of the allergen
    }
}