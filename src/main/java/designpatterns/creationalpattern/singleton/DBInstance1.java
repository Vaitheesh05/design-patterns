package designpatterns.creationalpattern.singleton;

/**
 * This class demonstrates the Singleton pattern using the "double-checked locking" mechanism.
 * This approach is a way to implement a thread-safe singleton with lazy initialization without incurring the synchronization overhead for every call to `getInstance()`.
 *
 * <h2>Implementation Details</h2>
 * <ul>
 *     <li><b>Private Constructor:</b> Prevents direct instantiation.</li>
 *     <li><b>`volatile` Static Instance:</b> The `INSTANCE` variable is declared as `volatile`. When we named as 'volatile' it will first directly into the memory. This is crucial to ensure that changes to this variable are immediately visible to all threads. Without `volatile`, a thread might see a partially constructed instance, leading to subtle bugs.</li>
 *     <li><b>`synchronized` Block:</b> Synchronization is only applied when the instance is null. This avoids the performance penalty of synchronization on every call once the instance has been created.</li>
 *     <li><b>Double Check:</b> The `INSTANCE == null` check is performed twice. The first check is outside the synchronized block to avoid the overhead of synchronization if the instance is already created. The second check is inside the synchronized block to prevent multiple threads from creating the instance simultaneously if they all pass the first check.</li>
 * </ul>
 *
 * <h2>Note on Modern Java</h2>
 * While double-checked locking is a well-known pattern, the "Initialization-on-demand holder idiom" (as seen in the `DBInstance` class) is often preferred in modern Java as it is simpler, cleaner, and guaranteed to be correct without the complexities of `volatile` and explicit synchronization.
 */
public class DBInstance1 {
   private static volatile DBInstance1 INSTANCE;
   private DBInstance1(){
   }

   public static DBInstance1 getInstance(){
       if(INSTANCE == null){
           synchronized (DBInstance1.class) {
               if(INSTANCE == null) { // Double-check
                   INSTANCE = new DBInstance1();
               }
           }
       }
       return INSTANCE;
   }
}
