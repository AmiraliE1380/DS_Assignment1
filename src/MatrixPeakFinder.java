import java.util.Scanner;

public class MatrixPeakFinder {
    private final Scanner scanner;
    private int[][] matrix;
    private int size;

    public MatrixPeakFinder(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void main(String[] args) {
        new MatrixPeakFinder(new Scanner(System.in)).run();
    }

    private void run() {
        matrix = DataGenerator.generateMatrix();
        System.out.println("1.Linear search for peak\n2.Binary search for peak");
        int method = Integer.parseInt(scanner.nextLine());
    }
}
