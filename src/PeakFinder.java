import java.util.Scanner;

public class PeakFinder {
    private final Scanner scanner;
    private final int[] array = {3, 40, 55, 155, 23, 7, 568, 7, 3};
    private int size;
    
    public PeakFinder(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void main(String[] args) {
        new PeakFinder(new Scanner(System.in)).run();
    }

    private void run() {
        System.out.println("1.Linear search for peak\n2.Binary search for peak");
        int method = Integer.parseInt(scanner.nextLine());
        int index;
        size = array.length;
        if(size == 1)
            index = 1;
        else if(array[0] >= array[1])
            index = size;
        else if(array[size - 1] >= array[size - 2])
            index = size - 1;
        else if(method == 1)
            index = linearSearch(size);
        else
            index = binarySearch(0, size / 2, size - 1);
        System.out.println("index = " + index);
    }

    private int binarySearch(int firstIndex, int middle, int last) {
        if ((array[middle] >= array[middle - 1] || middle == 0) &&
                (array[middle] >= array[middle + 1] || middle == size - 1))
            return middle;
        else if(middle > 0 && array[middle - 1] > array[middle])
            return binarySearch(firstIndex, (firstIndex + middle - 1) / 2, middle - 1);
        else
            return binarySearch(middle + 1, (middle + last + 1) / 2, last);
    }

    private int linearSearch(int size) {
        for(int i = 1; i < size - 1; i++) {
            if(array[i] >= array[i - 1] && array[i] >= array[i + 1])
                return i;
        }
        return size - 1;
    }
}
