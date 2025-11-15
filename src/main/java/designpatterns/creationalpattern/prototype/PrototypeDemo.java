package designpatterns.creationalpattern.prototype;

/**
 * The Prototype design pattern is a creational pattern that allows you to create new objects by copying an existing object, known as the prototype.
 * This pattern is used when the type of objects to create is determined at runtime, for example, by dynamic loading, or to avoid building a complex object from scratch.
 *
 * <h2>Problem it solves</h2>
 * It helps to avoid the cost of creating complex objects from scratch. When an object is complex and its creation is time-consuming,
 * cloning a pre-existing instance and modifying it can be more efficient. It also allows you to add or remove products at runtime.
 *
 * <h2>Use Case</h2>
 * Consider a scenario where you have an object that represents data fetched from a database.
 * If you need multiple instances of this object, it's more efficient to fetch the data once, create a prototype object, and then clone it for subsequent uses.
 * This avoids repeated, expensive database calls.
 *
 * <h2>Example</h2>
 * In the example below, we have a `BookShop` that loads a list of books. Instead of creating a new `BookShop` and loading the books again,
 * we can clone the original `BookShop` to create a new one. This is much faster if loading the data is a heavy operation.
 * The `clone()` method is the core of the prototype pattern.
 *
 * <h2>Copying Types</h2>
 * When implementing the clone method, it's important to understand the difference between shallow and deep copying.
 *
 * <h3>Shallow Copy</h3>
 * A shallow copy of an object copies all of the primitive type fields and the references of the object's fields. It does not create new objects for the referenced fields.
 * In the current `BookShop` example, the `clone` method performs a shallow copy of the `Book` objects. It creates a new `List`, but the `Book` objects inside the list are the same references as in the original object.
 * This means if you were to get a book from the first shop and change its name, the change would be reflected in the second shop as well. However, adding or removing books from one shop's list will not affect the other.
 *
 * <h3>Deep Copy</h3>
 * A deep copy, on the other hand, creates a new object and then recursively copies all the objects referenced by the original object.
 * The clone is a completely independent copy of the original. To achieve a deep copy for the `BookShop`, you would need to also clone each `Book` object inside the list.
 * For example, the `BookShop.clone()` method would look like this:
 * <pre>{@code
 * @Override
 * public BookShop clone() {
 *     BookShop clone = new BookShop();
 *     for (Book b : getBooks()){
 *         // Assuming Book also implements Cloneable and has a clone() method
 *         clone.getBooks().add(b.clone());
 *     }
 *     return clone;
 * }
 * }</pre>
 */
public class PrototypeDemo {
    public static void main(String[] args) {
        BookShop first = new BookShop();
        first.setShopName("RM Books");
        first.loadData();

        // The clone method here performs a shallow copy of the books.
        BookShop second = first.clone();
        second.setShopName("VN Books");

        // This only affects the list in the 'first' BookShop, not 'second',
        // because the list itself was newly created in the clone method.
        first.getBooks().remove(2);

        System.out.println("Original Shop:");
        System.out.println(first);
        System.out.println("\nCloned Shop:");
        System.out.println(second);
    }
}
