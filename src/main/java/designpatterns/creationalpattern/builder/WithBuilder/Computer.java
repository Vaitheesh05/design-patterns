package designpatterns.creationalpattern.builder.WithBuilder;

/**
 * This class demonstrates the Builder design pattern.
 * The Builder pattern is a creational pattern designed to provide a flexible solution to various object creation problems.
 * It is used to construct a complex object step by step and the final step will return the object.
 *
 * <h2>Problem it Solves</h2>
 * The Builder pattern is an answer to the "Telescoping Constructor" anti-pattern. When an object can be created with many
 * possible configuration options, you might end up with a long list of constructors, each taking a different set of parameters.
 * This is confusing and hard to manage.
 * <pre>
 * // Telescoping Constructors (the problem)
 * Computer(String hdd, String ram) { ... }
 * Computer(String hdd, String ram, String graphicsCard) { ... }
 * Computer(String hdd, String ram, String graphicsCard, String bluetooth) { ... }
 * </pre>
 * Using JavaBeans style (setters) can lead to objects being in an inconsistent state during construction and is not thread-safe.
 * The Builder pattern avoids these issues.
 *
 * <h2>Implementation</h2>
 * This `Computer` class is the "Product". It's a complex object that we want to create.
 * The key components are:
 * <ol>
 *     <li><b>The Product (`Computer`):</b> The complex object to be built. Its constructor is private, forcing creation through the builder.</li>
 *     <li><b>The Static Nested Builder (`ComputerBuilder`):</b> This class contains the same fields as the outer class. It has a constructor for the required fields and methods for setting optional fields. These methods return the builder itself to allow for a "fluent" or "chained" API.</li>
 *     <li><b>The `build()` method:</b> The final method called on the builder, which creates and returns the final `Computer` object.</li>
 * </ol>
 */
public class Computer {
    // Fields of the final Computer object
    private final String HDD;
    private final String RAM;
    private final String graphicsCard;
    private final String bluetooth;

    /**
     * The constructor is private, so objects can only be created using the builder.
     */
    private Computer(ComputerBuilder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.graphicsCard = builder.graphicsCard;
        this.bluetooth = builder.bluetooth;
    }

    @Override
    public String toString() {
        return "Computer [HDD=" + HDD + ", RAM=" + RAM + ", GraphicsCard=" + graphicsCard + ", Bluetooth=" + bluetooth + "]";
    }

    /**
     * The static nested Builder class.
     */
    public static class ComputerBuilder {
        // Required parameters
        private final String HDD;
        private final String RAM;

        // Optional parameters
        private String graphicsCard;
        private String bluetooth;

        /**
         * Builder constructor for the required fields.
         * @param hdd The hard disk drive size.
         * @param ram The RAM size.
         */
        public ComputerBuilder(String hdd, String ram) {
            this.HDD = hdd;
            this.RAM = ram;
        }

        /**
         * Sets the optional graphics card.
         * @param graphicsCard The graphics card model.
         * @return The builder instance for method chaining.
         */
        public ComputerBuilder enableGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        /**
         * Sets the optional bluetooth adapter.
         * @param bluetooth The bluetooth adapter model.
         * @return The builder instance for method chaining.
         */
        public ComputerBuilder enableBluetooth(String bluetooth) {
            this.bluetooth = bluetooth;
            return this;
        }

        /**
         * Creates and returns the final Computer object.
         * @return A new instance of Computer.
         */
        public Computer build() {
            return new Computer(this);
        }
    }
}

/**
 * Client code to test the Builder pattern.
 */
class TestBuilderPattern {
    public static void main(String[] args) {
        // Using the builder to create a Computer object with optional parameters.
        // The fluent interface makes the code highly readable.
        Computer gamingComputer = new Computer.ComputerBuilder("1 TB", "16 GB")
                .enableGraphicsCard("NVIDIA RTX 4090")
                .enableBluetooth("Intel AX210")
                .build();

        System.out.println("Gaming Computer Config: " + gamingComputer);

        // Creating another object with a different configuration.
        Computer basicComputer = new Computer.ComputerBuilder("500 GB", "8 GB")
                .build(); // Optional parameters are not set

        System.out.println("Basic Computer Config: " + basicComputer);
    }
}
