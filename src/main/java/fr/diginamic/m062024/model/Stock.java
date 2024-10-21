package fr.diginamic.m062024.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a stock of products.
 */
public class Stock {
    private List<Produit> produits = new ArrayList<>(); // List of products

    /**
     * Adds a product to the stock.
     *
     * @param produit The product to add.
     */
    public void addProduit(Produit produit) {
        produits.add(produit);
    }

    /**
     * Gets the list of products in stock.
     *
     * @return The list of products.
     */
    public List<Produit> getProduits() {
        return produits;
    }
}