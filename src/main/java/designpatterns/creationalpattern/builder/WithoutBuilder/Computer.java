package designpatterns.creationalpattern.builder.WithoutBuilder;

/**
 * This class demonstrates the problems that arise without using the Builder pattern,
 * leading to an anti-pattern known as "Telescoping Constructors".
 *
 * <h2>The Problem: Telescoping Constructors</h2>
 * When a class has multiple optional parameters, a common but problematic approach is to create multiple constructors,
 * each with a different set of parameters.
 * <pre>
 * // A "telescoping" series of constructors
 * Computer(String hdd, String ram) { ... }
 * Computer(String hdd, String ram, String graphicsCard) { ... } // adds one param
 * Computer(String hdd, String ram, String graphicsCard, String bluetooth) { ... } // adds another
 * </pre>
 * This becomes unwieldy and hard to manage for several reasons:
 * <ol>
 *     <li><b>Readability:</b> When you see `new Computer("500 GB", "8 GB", null, "Intel AX210")`, it's hard to know which parameter is which without looking at the constructor definition. The `null` for the graphics card is particularly confusing.</li>
 *     <li><b>Scalability:</b> If you need to add more optional parameters, the number of constructors can grow exponentially.</li>
 *     <li><b>Parameter Mismatch:</b> As shown in "Case 3" in the `main` method, if you have multiple parameters of the same type (like `String`), it's very easy to accidentally pass them in the wrong order, leading to subtle bugs. The compiler won't catch `new Computer(bluetooth, RAM)` as an error if it expects `(HDD, RAM)`.</li>
 * </ol>
 * The Builder pattern directly solves these issues by providing a clear, fluent API for object construction.
 */
public class Computer {

    private String HDD;
    private String RAM;
    private String graphicsCard;
    private String bluetooth;

    /**
     * Constructor for basic computer with only required fields.
     */
    public Computer(String hdd, String ram) {
        this.HDD = hdd;
        this.RAM = ram;
    }

    /**
     * Constructor with all possible fields.
     * To create an object without a graphics card, a client would have to pass `null`.
     */
    public Computer(String HDD, String RAM, String graphicsCard, String bluetooth) {
        this.HDD = HDD;
        this.RAM = RAM;
        this.graphicsCard = graphicsCard;
        this.bluetooth = bluetooth;
    }

    // What if you need a computer with RAM and a graphics card, but no HDD?
    // You would need another constructor, further complicating the design.
    // public Computer(String RAM, String graphicsCard) { ... }


    @Override
    public String toString() {
        return "Computer{" +
                "HDD='" + HDD + '\'' +
                ", RAM='" + RAM + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", bluetooth='" + bluetooth + '\'' +
                '}';
    }
}

class TestWithoutBuilder {
    public static void main(String[] args) {
        // Case 1: Creating an object with all parameters. Readable, but requires all fields.
        Computer computer1 = new Computer("1 TB", "16 GB", "NVIDIA", "Intel");
        System.out.println("Full config: " + computer1);

        // Case 2: Creating an object with only required parameters. This works because a specific constructor exists.
        Computer computer2 = new Computer("500 GB", "8 GB");
        System.out.println("Basic config: " + computer2);

        // Case 3: An attempt to create a computer with RAM and Bluetooth.
        // This is where the problem becomes clear. The developer intended to set bluetooth and RAM,
        // but accidentally called the (String, String) constructor for HDD and RAM.
        // The resulting object is valid but incorrect.
        String RAM = "8 GB";
        String bluetooth = "Generic Bluetooth";
        Computer computer3 = new Computer(bluetooth, RAM); // Oops! This sets HDD to "Generic Bluetooth" and RAM to "8 GB"
        System.out.println("Incorrect config due to parameter mismatch: " + computer3);

        // To get the desired object (e.g., no graphics card), you might have to pass nulls, which is ugly and error-prone.
        Computer computer4 = new Computer("1 TB", "16 GB", null, "Intel");
        System.out.println("Config with null parameter: " + computer4);

        // The Builder pattern solves all these ambiguity and readability issues.
    }
}
