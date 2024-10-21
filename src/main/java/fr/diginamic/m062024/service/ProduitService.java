package fr.diginamic.m062024.service;

import fr.diginamic.m062024.model.Produit;
import fr.diginamic.m062024.model.Stock;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class to handle product-related operations.
 */
public class ProduitService {

    private Stock stock;

    /**
     * Constructor to initialize the service with a stock of products.
     *
     * @param stock the stock of products
     */
    public ProduitService(Stock stock) {
        this.stock = stock;
    }

    /**
     * Finds the best products by brand name.
     *
     * @param brandName the name of the brand
     * @return a list of the best products from the specified brand
     */
    public List<Produit> findBestByBrand(String brandName) {
        return stock.getProduits().stream()
                .filter(produit -> produit.getMarque().getNom().equalsIgnoreCase(brandName))
                .sorted((p1, p2) -> p1.getScoreNutritionnel().compareTo(p2.getScoreNutritionnel()))
                .collect(Collectors.toList());
    }

    /**
     * Finds the best products by category name.
     *
     * @param categoryName the name of the category
     * @return a list of the best products from the specified category
     */
    public List<Produit> findBestByCategory(String categoryName) {
        return stock.getProduits().stream()
                .filter(produit -> produit.getCategorie().getLibelle().equalsIgnoreCase(categoryName))
                .sorted((p1, p2) -> p1.getScoreNutritionnel().compareTo(p2.getScoreNutritionnel()))
                .collect(Collectors.toList());
    }
}
