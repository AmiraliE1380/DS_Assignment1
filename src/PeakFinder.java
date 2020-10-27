import java.util.Scanner;

public class PeakFinder {
    private final Scanner scanner;
    private final int[] array = {3, 4, 55, 155, 23, 24,3 , 43, 43, 4, 3, 4, 3, 4, 43 ,5 , 5, 42,4, 12, 5, 6, 45,
            7, 568, 7, 8};
    
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
        int size = array.length;
        if(array[0] >= array[1]) {
            System.out.println("index = 0");
            return;
        }
        if(method == 1)
            index = linearSearch(size);
        else
            index = binarySearch(0, size / 2, size - 1);
        System.out.println("index = " + index);
        /*
        complete this part:
        if(array[size - 1] > array[size - 2]) {
            size--;
            System.out.println("index = " + size);
            return;
        }
         */
    }

    private int binarySearch(int firstIndex, int middle, int last) {
        if(array[middle] > array[middle + 1]);

        return firstIndex;
    }

    private int linearSearch(int size) {
        for(int i = 1; i < size - 1; i++) {
            if(array[i] >= array[i - 1] && array[i] >= array[i + 1])
                return i;
        }
        return size - 1;
    }
}
