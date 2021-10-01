package javaproject;

/**
 *
 * @author Rock_it_twice
 * @param <T>
 */
@FunctionalInterface
public interface Calculator <T extends Number> {
    //Methods
    double calculateFees(T clubID);
}
