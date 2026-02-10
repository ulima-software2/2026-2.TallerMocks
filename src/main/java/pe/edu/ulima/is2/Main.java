package pe.edu.ulima.is2;

import pe.edu.ulima.is2.model.VideoGame;
import pe.edu.ulima.is2.repository.InMemoryVideoGameRepository;
import pe.edu.ulima.is2.repository.VideoGameRepository;
import pe.edu.ulima.is2.service.SalesService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        VideoGameRepository repository = new InMemoryVideoGameRepository();
        SalesService salesService = new SalesService(repository);

        // 1. CREATE (CRUD)
        System.out.println("--- Creating Video Games ---");
        VideoGame g1 = repository.save(new VideoGame(null, "Elden Ring", "PC", 59.99, 10));
        VideoGame g2 = repository.save(new VideoGame(null, "The Legend of Zelda", "Switch", 49.99, 5));
        VideoGame g3 = repository.save(new VideoGame(null, "God of War", "PS5", 69.99, 3));

        // 2. READ (CRUD)
        System.out.println("\n--- All Video Games ---");
        repository.findAll().forEach(System.out::println);

        // 3. UPDATE (CRUD)
        System.out.println("\n--- Updating Price of Elden Ring ---");
        g1.setPrice(49.99);
        repository.update(g1);
        System.out.println(repository.findById(g1.getId()).orElse(null));

        // 4. SALES SIMULATION
        System.out.println("\n--- Processing Sales ---");
        try {
            Double total1 = salesService.processSale(g1.getId(), 2);
            System.out.println("Sale 1 successful! Total: $" + total1);

            Double total2 = salesService.processSale(g2.getId(), 5);
            System.out.println("Sale 2 successful! Total: $" + total2);

            // This should fail (insufficient stock)
            System.out.println("Attempting to sell more Zelda games...");
            salesService.processSale(g2.getId(), 1);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // 5. DELETE (CRUD)
        System.out.println("\n--- Deleting God of War ---");
        repository.deleteById(g3.getId());

        System.out.println("\n--- Final List ---");
        repository.findAll().forEach(System.out::println);
    }
}
