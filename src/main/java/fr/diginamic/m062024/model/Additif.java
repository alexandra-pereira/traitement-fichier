package fr.diginamic.m062024.model;

/**
 * Represents a food additive.
 */
public class Additif {
    private String libelle; // Name of the additive

    /**
     * Constructs an Additif with the specified name.
     *
     * @param libelle The name of the additive.
     */
    public Additif(String libelle) {
        this.libelle = libelle;
    }

    /**
     * Gets the name of the additive.
     *
     * @return The name of the additive.
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Sets the name of the additive.
     *
     * @param libelle The name to set.
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return libelle; // Returns the name of the additive
    }
}