import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Creates an integer array of size 100 filled with random values between 0 and 100, prints the unsorted array out to the console,
 * sorts the array using dual pivot quicksort, and prints the sorted array out the console.
 */
public class Simulate {

    public static void main(String [] args) {
        Simulate simulate = new Simulate();
        int [] unsortedArray = simulate.createUnsortedArray();

        System.out.println("------ UNSORTED ARRAY ------");
        simulate.printArray(unsortedArray);
        simulate.sortArray(unsortedArray);

        System.out.println();
        System.out.println();
        System.out.println("------ SORTED ARRAY ------");
        simulate.printArray(unsortedArray);
    }

    /**
     * Creates unsorted array with values randomly chosen between 0 and 100
     * @return int [] unsortedArray
     */
    private int[] createUnsortedArray() {
        final int ARRAY_SIZE = 100;
        int [] unsortedArray = new int[ARRAY_SIZE];

        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedArray[i] = ThreadLocalRandom.current().nextInt(0, 100);
        }
        return unsortedArray;
    }

    /**
     * Java uses dual pivot quicksort when the array size is larger than 47.
     * Utilizes Arrays collection class method to sort array from smallest to largest.
     * @param array
     */
    private void sortArray(int[] array) {
        Arrays.sort(array);
    }

    /**
     * Prints out the unsorted array and sets a newline after awhile to keep data on screen
     * @param array
     */
    public void printArray(int [] array) {
        int newline = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            if (i == (10 + newline)) {
                System.out.println();
                newline += 10;
            }
        }
    }
}
