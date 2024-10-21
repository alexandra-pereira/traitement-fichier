package fr.diginamic.m062024;

import fr.diginamic.m062024.model.Produit;
import fr.diginamic.m062024.model.Stock;
import fr.diginamic.m062024.service.ProduitService;
import fr.diginamic.m062024.utils.CSVFileReader;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Main application class for the Open Food Facts project.
 */
public class ApplicationOpenFoodFacts {
    private Stock stock;

    /**
     * Constructor to initialize the application with a stock of products.
     *
     * @param stock the stock of products
     */
    public ApplicationOpenFoodFacts(Stock stock) {
        this.stock = stock;
    }

    /**
     * Starts the application, allowing user interaction via a console menu.
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        ProduitService produitService = new ProduitService(stock);

        while (running) {
            // Display menu options
            System.out.println("1. Search by Brand");
            System.out.println("2. Search by Category");
            System.out.println("3. Search by Brand and Category");
            System.out.println("4. Display Common Allergens");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter brand name: ");
                    String brandName = scanner.nextLine();
                    List<Produit> bestByBrand = produitService.findBestByBrand(brandName);
                    System.out.println("Best products by brand " + brandName + ": " + bestByBrand);
                    break;
                case 2:
                    System.out.print("Enter category name: ");
                    String categoryName = scanner.nextLine();
                    List<Produit> bestByCategory = produitService.findBestByCategory(categoryName);
                    System.out.println("Best products by category " + categoryName + ": " + bestByCategory);
                    break;
                case 3:
                    // Implement search by brand and category
                    break;
                case 4:
                    // Implement displaying common allergens
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    /**
     * The main method to launch the application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Stock stock = new Stock();
        CSVFileReader reader = new CSVFileReader();

        try {
            stock = reader.loadProductsFromCSV("path/to/your/csv/file.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ApplicationOpenFoodFacts app = new ApplicationOpenFoodFacts(stock);
        app.start();
    }
}
